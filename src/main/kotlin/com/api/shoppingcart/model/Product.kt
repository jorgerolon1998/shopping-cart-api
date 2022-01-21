package com.api.shoppingcart.model

import java.util.*
import javax.persistence.Entity
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive


@Entity
class Product(
    @field:Valid @field:NotNull @field:NotBlank(message = "Name is required")
    val name: String,
    @field:Valid @field:NotNull @field:NotBlank(message = "SKU is required")
    val sku: String,
    @field:Valid @field:NotNull @field:NotBlank(message = "Description is required")
    val description: String,
    @field:Valid @field:NotNull
    @field:Positive(message = "Price not found")
    val price: Double,
    @field:Valid @field:NotNull
    @field:Min(value = 1, message = "Quantity not found")
    var quantity: Int,
    @field:Valid @field:NotNull(message = "HasDiscount is required")
    val hasDiscount: Boolean,
    id: UUID? = null
): AssignedUUID(id){
    constructor() : this("", "",
        "", 0.0, 0,
        false
    )
}
