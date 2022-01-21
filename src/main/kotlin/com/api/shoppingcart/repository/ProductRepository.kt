package com.api.shoppingcart.repository

import com.api.shoppingcart.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, UUID>