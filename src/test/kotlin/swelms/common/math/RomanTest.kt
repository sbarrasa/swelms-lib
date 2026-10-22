package swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RomanTest {
   @Test
   fun romanSybols() {
      assertEquals('I', romanSymbols[1])
      assertEquals('V', romanSymbols[5])
      assertEquals('X', romanSymbols[10])
      assertEquals('L', romanSymbols[50])
      assertEquals('C', romanSymbols[100])
      assertEquals('D', romanSymbols[500])
      assertEquals('M', romanSymbols[1000])
   }

   @Test
   fun convertsBasicNumerals() {
      assertEquals("I", arabicToRoman(1))
      assertEquals("V", arabicToRoman(5))
      assertEquals("X", arabicToRoman(10))
      assertEquals("L", arabicToRoman(50))
      assertEquals("C", arabicToRoman(100))
      assertEquals("D", arabicToRoman(500))
      assertEquals("M", arabicToRoman(1000))
   }

   @Test
   fun convertsSubtractiveNumerals() {
      assertEquals("IV", arabicToRoman(4))
      assertEquals("IX", arabicToRoman(9))
      assertEquals("XL", arabicToRoman(40))
      assertEquals("XC", arabicToRoman(90))
      assertEquals("CD", arabicToRoman(400))
      assertEquals("CM", arabicToRoman(900))
   }

   @Test
   fun convertsCombinedNumerals() {
      assertEquals("XIV", arabicToRoman(14))
      assertEquals("XLIX", arabicToRoman(49))
      assertEquals("MCMXCIX", arabicToRoman(1999))
      assertEquals("MMXXVI", arabicToRoman(2026))
   }

   @Test
   fun convertsMinimumAndMaximumValues() {
      assertEquals("I", arabicToRoman(1))
      assertEquals("MMMCMXCIX", arabicToRoman(3999))
   }

   @Test
   fun convertsRomanNumeralsToArabic() {
      assertEquals(1, romanToArabic("I"))
      assertEquals(4, romanToArabic("IV"))
      assertEquals(49, romanToArabic("XLIX"))
      assertEquals(1974, romanToArabic("MCMLXXIV"))
      assertEquals(1999, romanToArabic("MCMXCIX"))
      assertEquals(2026, romanToArabic("MMXXVI"))
      assertEquals(3999, romanToArabic("MMMCMXCIX"))
   }

   @Test
   fun acceptsLowercaseInput() {
      assertEquals(49, romanToArabic("xlix"))
   }

   @Test
   fun rejectsArabicNumbersOutsideSupportedRange() {
      assertFailsWith<IllegalArgumentException> {
         arabicToRoman(0)
      }
      assertFailsWith<IllegalArgumentException> {
         arabicToRoman(-1)
      }
      assertFailsWith<IllegalArgumentException> {
         arabicToRoman(4000)
      }
   }

   @Test
   fun rejectsInvalidRomanSymbols() {
      assertFailsWith<IllegalArgumentException> {
         romanToArabic("A")
      }
   }

   @Test
   fun rejectsNonCanonicalRomanNumerals() {
      assertFailsWith<IllegalArgumentException> {
         romanToArabic("IIII")
      }
      assertFailsWith<IllegalArgumentException> {
         romanToArabic("VX")
      }
      assertFailsWith<IllegalArgumentException> {
         romanToArabic("IC")
      }
   }

   @Test
   fun rejectsEmptyInput() {
      assertFailsWith<IllegalArgumentException> {
         romanToArabic("")
      }
   }
}