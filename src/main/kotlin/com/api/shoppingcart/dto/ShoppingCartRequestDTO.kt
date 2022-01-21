package com.api.shoppingcart.dto

import com.api.shoppingcart.model.Product
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class ShoppingCartRequestDTO(
    val shoppingCartId: UUID?,
    @field:Valid @field:NotNull val productId: UUID
)