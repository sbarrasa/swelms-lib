package swelms.common.locale

var lang_en = Lang(locale_id = "en"){

      defaults {
         it["GENERAL"] = "This is a general message"
         it["TEST"] = "Test"
         it["NOT_IMPLEMENTED"] = "Not implemented yet"
      }


      component<IntRange> {
         it["OUT_OF_RANGE"] = "Value must be between {1} and {2}"
      }

   }

