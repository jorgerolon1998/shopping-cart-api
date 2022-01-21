package com.api.shoppingcart.service

import com.api.shoppingcart.dto.*
import java.util.*

interface ShoppingCartService {

    fun getProductsByCart(id: UUID): MutableList<ProductByCartResponseDTO>

    fun addProductToShoppingCart(shoppingCartRequest: ShoppingCartRequestDTO): ShoppingCartProductResponseDTO

    fun updateProductToCart(id: UUID, product: UpdateProductToCartRequestDTO): ShoppingCartProductResponseDTO

    fun deleteProductToCart(id: UUID, idProduct: UUID): ShoppingCartProductResponseDTO

    fun checkoutShoppingCart(id: UUID): CheckoutResponseDTO

}