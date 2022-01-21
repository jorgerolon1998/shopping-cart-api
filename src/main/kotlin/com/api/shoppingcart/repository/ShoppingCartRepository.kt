package com.api.shoppingcart.repository

import com.api.shoppingcart.model.ShoppingCart
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShoppingCartRepository : JpaRepository<ShoppingCart, UUID>