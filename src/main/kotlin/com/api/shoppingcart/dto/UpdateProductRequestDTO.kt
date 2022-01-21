package com.api.shoppingcart.dto

import java.util.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class UpdateProductRequestDTO (
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotBlank(message = "SKU is required")
    val sku: String,
    @field:NotBlank(message = "Description is required")
    val description: String,
    @field:Positive(message = "Price must be greater than 0")
    val price: Double,
    @field:Min(value = 1, message = "Quantity can't be less than 1")
    var quantity: Int,
    @field:NotNull(message = "HasDiscount is required")
    val hasDiscount: Boolean
)