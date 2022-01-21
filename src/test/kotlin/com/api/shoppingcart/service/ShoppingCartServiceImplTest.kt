package com.api.shoppingcart.service

import com.api.shoppingcart.model.Product
import com.api.shoppingcart.model.ShoppingCart
import com.api.shoppingcart.model.State
import com.api.shoppingcart.repository.ProductRepository
import com.api.shoppingcart.repository.ShoppingCartRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

class ShoppingCartServiceImplTest  {

    private val repository: ShoppingCartRepository = Mockito.mock(ShoppingCartRepository::class.java)
    private val productRepository: ProductRepository = Mockito.mock(ProductRepository::class.java)

    private val id: UUID = UUID.fromString("d58749de-ded2-401b-997f-0e940b8fdc2d")

    private lateinit var service: ShoppingCartServiceImpl

    @BeforeEach
    fun setUp() {
        service = ShoppingCartServiceImpl(repository, productRepository)
        val shoppingCart = ShoppingCart(getProducts(), State.PENDING, id)
        Mockito.`when`(repository.findById(id)).thenReturn(Optional.of(shoppingCart))
        Mockito.`when`(repository.save(shoppingCart)).thenReturn(shoppingCart)
    }

    @Test
    fun getProductsByCart_OK() {
        val productsByCart = service.getProductsByCart(id)
        Assertions.assertEquals(productsByCart.size, getProducts().size)
    }

    private fun getProducts(): MutableList<Product> = mutableListOf(
        Product("product1", "sku1", "description1", 50.0, 6, true, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae976")),
        Product("product2", "sku2", "description2", 150.0, 1, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae977")),
        Product("product3", "sku3", "description3", 250.20, 5, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae978")),
        Product("product4", "sku4", "description4", 52.0, 1, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae979")),
        Product("product5", "sku5", "description5", 5.0, 3, true, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae980"))
    )

}