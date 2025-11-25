import com.swelms.common.locale.Locale;
import com.swelms.domain.cuit.Cuit;
import org.junit.Test;


public class LocaleTest {
  @Test
  public void test(){
    Locale.setRootPackage("com.bank.locale");
    System.out.println(Locale.text(Cuit.class).get("INVALID_LENGTH"));
    Locale.setLang("es");
    System.out.println(Locale.text(Cuit.class).get("INVALID_LENGTH"));



  }
}
