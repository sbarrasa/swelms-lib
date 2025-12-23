package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class StringSlotsTest {

   @Test
   fun moreSlotsThanValues() {
      val text = "Hola {0} {1} {2}"
      val result = StringSlots(text).replace("Mundo")
      assertEquals("Hola Mundo {1} {2}", result)
   }

   @Test
   fun lessSlotsThanValues() {
      val text = "Hola {0}"
      val result = StringSlots(text).replace("Mundo", "Extra1", "Extra2")
      assertEquals("Hola Mundo Extra1 Extra2", result)
   }

   @Test
   fun sameSlotsAndValues() {
      val text = "{0} {1} {2}"
      val result = StringSlots(text).replace("A", "B", "C")
      assertEquals("A B C", result)
   }

   @Test
   fun repeatedSlots() {
      val text = "{0} y {0} son iguales"
      val result = StringSlots(text).replace("Valor")
      assertEquals("Valor y Valor son iguales", result)
   }

   @Test
   fun noSlots() {
      val text = "Texto sin slots"
      val result = StringSlots(text).replace("Extra")
      assertEquals("Texto sin slots Extra", result)
   }


   @Test
   fun extensionBasic() {
      val text = "Hola {0}{1}"
      val result = text.replaceSlots("Mundo", "!!!")
      assertEquals("Hola Mundo!!!", result)
   }

   @Test
   fun extensionExtraValues() {
      val text = "Solo {1} {2} {3}"
      val result = text.replaceSlots("Primero", "Segundo", "Tercero")
      assertEquals("Solo Primero Segundo Tercero", result)
   }

}
