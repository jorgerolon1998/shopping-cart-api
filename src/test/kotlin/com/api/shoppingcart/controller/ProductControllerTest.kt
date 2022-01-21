package com.api.shoppingcart.controller

import com.api.shoppingcart.model.Product
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `should get all products request`() {
        val entity = restTemplate.getForEntity<List<Product>>("/products")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `should create product request`() {
        val product = Product("Test Product", "sku-test",
            "test description", 10.0, 10, false)
        val entity = restTemplate.postForEntity("/products", product, Product::class.java)
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)

        val entityGet = restTemplate.getForEntity<List<Product>>("/products")
        Assertions.assertThat(entityGet.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entityGet.body?.size).isEqualTo(1)
    }

    @Test
    fun `should update product request`() {
        val product = Product("Test product", "sku-test", "test description", 20.0, 5, true)
        restTemplate.put("/products", product, "fe9abde1-d79b-4a76-92e7-20f28805dcc6")
    }

    @Test
    fun `should delete product request`() {
        restTemplate.delete("/products", "fe9abde1-d79b-4a76-92e7-20f28805dcc6")
    }

}