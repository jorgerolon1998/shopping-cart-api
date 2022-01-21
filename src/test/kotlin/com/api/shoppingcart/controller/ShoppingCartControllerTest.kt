package com.api.shoppingcart.controller

import com.api.shoppingcart.dto.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoppingCartControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `should update product to shopping cart request`() {
        val product = UpdateProductToCartRequestDTO(UUID.fromString("fe9abde1-d79b-4a76-92e7-20f28805dcc6"), 25)
        restTemplate.put("/shopping-carts", product, "fe9abde1-d79b-4a76-92e7-20f28805dcc6")
    }

    @Test
    fun `should delete shipping cart request`() {
        restTemplate.delete("/shopping-carts", "fe9abde1-d79b-4a76-92e7-20f28805dcc6")
    }

}