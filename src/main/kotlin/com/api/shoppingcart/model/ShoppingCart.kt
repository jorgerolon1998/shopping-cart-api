package com.api.shoppingcart.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany
import com.api.shoppingcart.model.State.PENDING

@Entity
class ShoppingCart(
    @OneToMany var products: MutableList<Product>,
    var state: State = PENDING,
    id: UUID? = null
) : AssignedUUID(id)