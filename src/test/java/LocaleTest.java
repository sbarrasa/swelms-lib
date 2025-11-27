import com.swelms.common.locale.Locale;
import com.swelms.domain.id.cuit.Cuit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LocaleTest {

  @Test
  public void test(){
    Locale.setRootPackage("com.bank.locale");
    assertEquals("TEST", Locale.text(Cuit.class, "TEST"));
    Locale.setLang("es");
    assertEquals("Prueba", Locale.text(Cuit.class, "TEST"));

  }
}
