package com.api.shoppingcart.service

import com.api.shoppingcart.exception.BusinessException
import com.api.shoppingcart.model.Product
import com.api.shoppingcart.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class ProductServiceImpl(@Autowired private val repository: ProductRepository) : ProductService {

    override fun getProducts(): List<Product> = repository.findAll()

    override fun createProduct(product: Product): Product = repository.save(product)

    override fun deleteProduct(id: UUID): Unit{
        try {
            return repository.deleteById(id)
        } catch (e : EmptyResultDataAccessException) {
            throw BusinessException("The product doesn't exist")
        }
    }

    override fun updateProduct(id: UUID, product: Product): Product {
        try {
            repository.findById(id).get()
            val updateProduct = Product(
                product.name, product.sku, product.description,
                product.price, product.quantity, product.hasDiscount, id
            )
            return repository.save(updateProduct)
        } catch (e : NoSuchElementException){
            throw BusinessException("The product doesn't exist")
        }
    }

}