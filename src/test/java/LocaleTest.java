import com.swelms.common.locale.Locale;
import com.swelms.domain.id.cuit.Cuit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.swelms.common.locale.*;

public class LocaleTest {

  @Test
  public void test(){
    Locale.registerConfigs(LocaleConfig_es.INSTANCE,LocaleConfig_en.INSTANCE, LocaleConfig_ar.INSTANCE);
    assertEquals("TEST", Locale.text(Cuit.class, "TEST"));
    Locale.setLang("es");
    assertEquals("Prueba", Locale.text(Cuit.class, "TEST"));

  }
}
