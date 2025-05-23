package com.sbarrasa.bank.repository

import com.sbarrasa.bank.config.DBConnection
import com.sbarrasa.bank.customer.Customer
import kotlinx.datetime.LocalDate
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Month
import kotlin.test.*
class CustomersTest{
    @BeforeTest
    fun setup() {
        DBConnection.init()
        transaction {
            SchemaUtils.create(Customers)
        }
    }

    @Test
    fun createFromEntity() {
        transaction {
            // Crear registros
            CustomerEntity.new(1) {
                name = "Sebastian Gabriel"
                lastName = "Barrasa"
                birthDay = LocalDate(1974, Month.JUNE, 7)
            }

            CustomerEntity.new(2) {
                name = "Rosa"
                lastName = "Testa"
                birthDay = LocalDate(1985, 1, 1)
            }

            val customer1 = CustomerEntity.findById(1)
            assertNotNull(customer1)
            assertEquals("Sebastian Gabriel", customer1.name)
            assertEquals("Barrasa", customer1.lastName)

            CustomerEntity.findById(1)?.delete()
            CustomerEntity.findById(2)?.delete()
        }
    }

    @Test
    fun createFromDTO() {
        transaction {
            // Borrar registros previos
            Customers.deleteWhere { id inList listOf(1, 2) }

            // Crear DTOs
            val customer1 = Customer(1, "Sebastian Gabriel", "Barrasa", LocalDate(1974, 6, 7))
            val customer2 = Customer(2, "Rosa", "Testa", LocalDate(1985, 1, 1))

            // Insertar usando DTO
            Customers.insert {
                it[id] = customer1.id
                it[name] = customer1.name
                it[lastName] = customer1.lastName
                it[birthDay] = customer1.birthDay
            }

            Customers.insert {
                it[id] = customer2.id
                it[name] = customer2.name
                it[lastName] = customer2.lastName
                it[birthDay] = customer2.birthDay
            }

            // Obtener DTO con id 1
            val fetchedCustomer = Customers.selectAll().where { Customers.id eq 1 }
                .map { row ->
                    Customer(
                        id = row[Customers.id].value,
                        name = row[Customers.name],
                        lastName = row[Customers.lastName],
                        birthDay = row[Customers.birthDay]
                    )
                }.first()

            assertNotNull(fetchedCustomer)
            assertEquals("Sebastian Gabriel", fetchedCustomer.name)
            assertEquals("Barrasa", fetchedCustomer.lastName)

            Customers.deleteWhere { id inList listOf(1, 2) }
        }
    }
}