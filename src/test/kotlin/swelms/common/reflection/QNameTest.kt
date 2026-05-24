package swelms.common.reflection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
class QNameTest {

   data class Person(val name: String, val age: Int)

   @Test
   fun qNameTest() {
     assertEquals("swelms.common.reflection.QNameTest.Person", Person::class.qName)
     val p = Person("Bob", 30)
     assertEquals("swelms.common.reflection.QNameTest.Person", p.qName)
   }

}
