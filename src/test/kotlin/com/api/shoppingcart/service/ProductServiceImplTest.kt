package com.api.shoppingcart.service

import com.api.shoppingcart.model.Product
import com.api.shoppingcart.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import java.util.*

internal class ProductServiceImplTest {

    private val repository: ProductRepository = Mockito.mock(ProductRepository::class.java)

    private lateinit var service: ProductServiceImpl

    @BeforeEach
    fun setUp() {
        service = ProductServiceImpl(repository)
        val updateProduct = Product(
            "product test", "sku-test", "test description",
            15.0, 5, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae852")
        )
        Mockito.`when`(repository.save(updateProduct)).thenReturn(updateProduct)

    }

}