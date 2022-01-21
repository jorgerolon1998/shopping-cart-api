package com.api.shoppingcart.dto

import com.api.shoppingcart.model.Product
import java.util.*

data class ShoppingCartProductResponseDTO (
    val shoppingCartId: UUID?,
    val name: String,
    val sku: String,
    val description: String,
    val price: Double,
    var quantity: Int,
    var hasDiscount: Boolean
){
    companion object {
        fun ProductAndCartIdFromShoppingCartProductResponseDTO(product: Product, cartId: UUID) = ShoppingCartProductResponseDTO(
            shoppingCartId = cartId,
            name = product.name,
            sku = product.sku,
            description = product.description,
            price = product.price,
            quantity = product.quantity,
            hasDiscount = product.hasDiscount
        )
    }
}