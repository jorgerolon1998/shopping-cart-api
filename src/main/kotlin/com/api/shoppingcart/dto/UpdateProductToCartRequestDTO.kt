package com.api.shoppingcart.dto

import java.util.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class UpdateProductToCartRequestDTO (
        @field:NotNull(message = "ProductId is required")
        val productId: UUID,
        @field:NotNull(message = "Quantity is required")
        @field:Min(value = 1, message = "Quantity can't be less than 1")
        var quantity: Int
)