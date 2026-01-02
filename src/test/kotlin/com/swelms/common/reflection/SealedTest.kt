package com.swelms.common.reflection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SealedTest {
    sealed class Vehicle {
        data class Car(val brand: String) : Vehicle()
        data class Bike(val type: String) : Vehicle()
        sealed class Truck : Vehicle() {
            data class SmallTruck(val capacity: Int) : Truck()
        }
    }

    @Test
    fun finalSubclasses() {
        val subclasses = Vehicle::class.finalSubclasses
        assertEquals(2, subclasses.size)
        assertTrue(subclasses.contains(Vehicle.Car::class))
        assertTrue(subclasses.contains(Vehicle.Bike::class))
    }

    @Test
    fun finalSubclassesRecursive() {
        val truckSubclasses = Vehicle.Truck::class.finalSubclasses
        assertEquals(1, truckSubclasses.size)
        assertTrue(truckSubclasses.contains(Vehicle.Truck.SmallTruck::class))
    }
}
