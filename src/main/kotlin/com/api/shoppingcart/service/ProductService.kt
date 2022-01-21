package com.api.shoppingcart.service

import com.api.shoppingcart.model.Product
import java.util.*

interface ProductService {

    fun getProducts(): List<Product>

    fun createProduct(product: Product): Product

    fun updateProduct(id: UUID,product: Product): Product

    fun deleteProduct(id: UUID)

}