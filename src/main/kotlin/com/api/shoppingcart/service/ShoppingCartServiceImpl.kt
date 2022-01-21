package com.api.shoppingcart.service

import com.api.shoppingcart.dto.*
import com.api.shoppingcart.exception.BusinessException
import com.api.shoppingcart.model.ShoppingCart
import com.api.shoppingcart.model.State.COMPLETED
import com.api.shoppingcart.repository.ProductRepository
import com.api.shoppingcart.repository.ShoppingCartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class ShoppingCartServiceImpl(@Autowired private val repository: ShoppingCartRepository,
                              @Autowired private val productRepository: ProductRepository) : ShoppingCartService {

    @Value("\${discount-dividend}")
    var discountDivider: Int = 2

    override fun getProductsByCart(id: UUID): MutableList<ProductByCartResponseDTO> {
        var productsByCart = mutableListOf<ProductByCartResponseDTO>()
        val productList = repository.findById(id)
            .map(ShoppingCart::products)
            .get().forEach {
                val productByCart = ProductByCartResponseDTO.ProductFromShoppingCartProduct(it)
                productsByCart.add(productByCart)
            }
        return  productsByCart
    }

    override fun addProductToShoppingCart(shoppingCartRequest: ShoppingCartRequestDTO): ShoppingCartProductResponseDTO {
        try {
            var shoppingCart = ShoppingCart(mutableListOf())
            val product = productRepository.findById(shoppingCartRequest.productId).get()
            if (shoppingCartRequest.shoppingCartId != null) {
                shoppingCart = repository.findById(shoppingCartRequest.shoppingCartId).get()
            }
            shoppingCart.products.add(product)
            repository.save(shoppingCart)
            return ShoppingCartProductResponseDTO.ProductAndCartIdFromShoppingCartProductResponseDTO(
                product,
                shoppingCart.id
            )
        } catch (e : NoSuchElementException) {
            throw BusinessException("The product doesn't exist")
        }
    }

    override fun updateProductToCart(id: UUID, productCart: UpdateProductToCartRequestDTO): ShoppingCartProductResponseDTO {
        val shoppingCart = repository.findById(id).get()
        val product = productRepository.findById(productCart.productId).get()
        shoppingCart.products.forEach { if (it.id == productCart.productId) it.quantity = product.quantity }
        repository.save(shoppingCart)
        return ShoppingCartProductResponseDTO.ProductAndCartIdFromShoppingCartProductResponseDTO(product, id)
    }

    override fun deleteProductToCart(id: UUID, idProduct: UUID): ShoppingCartProductResponseDTO {
        val shoppingCart = repository.findById(id).get()
        val product = productRepository.findById(idProduct).get()
        shoppingCart.products = shoppingCart.products
            .filterNot { product -> product.id == idProduct }.toMutableList()
        repository.save(shoppingCart)
        return ShoppingCartProductResponseDTO.ProductAndCartIdFromShoppingCartProductResponseDTO(product, id)
    }

    override fun checkoutShoppingCart(id: UUID): CheckoutResponseDTO {
        try {
            val shoppingCart = repository.findById(id).get()
            val products = getProductsByCart(id)
            val totalWithDiscount = products
                .filter { it.hasDiscount }
                .sumOf { product -> (product.price * product.quantity) / discountDivider }
            val totalWithoutDiscount = products
                .filterNot { it.hasDiscount }
                .sumOf { product -> product.price * product.quantity }
            shoppingCart.state = COMPLETED
            repository.save(shoppingCart)
            return CheckoutResponseDTO(totalWithDiscount + totalWithoutDiscount)
        } catch (e : NoSuchElementException) {
            throw BusinessException("ShoppingCart doesn't exist")
        }
    }

}
