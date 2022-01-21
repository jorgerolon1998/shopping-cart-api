package com.api.shoppingcart.dto

import com.api.shoppingcart.model.Product

data class ProductByCartResponseDTO (
    val name: String,
    val sku: String,
    val description: String,
    val price: Double,
    var quantity: Int,
    val hasDiscount: Boolean
) {
    companion object {
        fun ProductFromShoppingCartProduct(product: Product) = ProductByCartResponseDTO(
            name = product.name,
            sku = product.sku,
            description = product.description,
            price = product.price,
            quantity = product.quantity,
            hasDiscount =  product.hasDiscount
        )
    }
}