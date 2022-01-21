package com.api.shoppingcart.controller

import com.api.shoppingcart.config.BaseController
import com.api.shoppingcart.dto.*
import com.api.shoppingcart.service.ShoppingCartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/shopping-carts")
class ShoppingCartController(@Autowired private val service: ShoppingCartService) : BaseController() {

    @GetMapping("/{id}")
    fun getProductsByCart(
        @PathVariable id: UUID
    ): MutableList<ProductByCartResponseDTO> = service.getProductsByCart(id)

    @PostMapping
    fun addProductToCart(
        @Validated @RequestBody shoppingCartRequest: ShoppingCartRequestDTO
    ): ShoppingCartProductResponseDTO = service.addProductToShoppingCart(shoppingCartRequest)

    @PutMapping("/{id}")
    fun updateProductToCart(
        @PathVariable id: UUID,
        @Valid @RequestBody product: UpdateProductToCartRequestDTO
    ): ShoppingCartProductResponseDTO = service.updateProductToCart(id, product)

    @DeleteMapping("/{id}/{idProduct}")
    fun deleteProductToCart(
        @PathVariable id: UUID,
        @PathVariable idProduct: UUID
    ): ShoppingCartProductResponseDTO = service.deleteProductToCart(id, idProduct)

    @GetMapping("/{id}/checkout")
    fun checkoutShoppingCart(
        @PathVariable id: UUID
    ): CheckoutResponseDTO = service.checkoutShoppingCart(id)

}