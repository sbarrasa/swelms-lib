package com.swelms.common.reflection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ReflectionTest {
    data class Person(val name: String, val age: Int)

    sealed class Shape {
        data class Circle(val radius: Double) : Shape()
        data class Square(val side: Double) : Shape()
    }

    @Test
    fun createFromMap() {
        val map = mapOf("name" to "Alice", "age" to 25)
        val person = createFromMap<Person>(map)
        
        assertNotNull(person)
        assertEquals("Alice", person.name)
        assertEquals(25, person.age)
    }

    @Test
    fun qNameTest() {
        assertEquals("com.swelms.common.reflection.ReflectionTest.Person", Person::class.qName)
        val p = Person("Bob", 30)
        assertEquals("com.swelms.common.reflection.ReflectionTest.Person", p.qName)
    }

    @Test
    fun finalSubclassesTest() {
        val subclasses = Shape::class.finalSubclasses
        assertEquals(2, subclasses.size)
        assertTrue { subclasses.contains(Shape.Circle::class) }
        assertTrue { subclasses.contains(Shape.Square::class) }
    }
}
