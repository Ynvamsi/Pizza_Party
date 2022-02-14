package com.zybooks.pizzaparty

import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * PizzaCalculator calculates the number of pizzas required
 *
 * @param partySize describes the size of party
 * @param hungerLevel describes the level of hungry
 *
 */

class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }


    /**
     * HungerLevel declares the 3 levels of hungers
     */
    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    /**
     * totalPizzas calculates the number of pizzas required
     *
     * @return returns an integer of total pizzas requires
     * @param partySize indicates the members of the party
     * @param numSlices indicates the number of slices people eat
     */
    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}

