import com.swelms.common.text.CaseUtilsKt;
import org.junit.Test;

public class CaseTest {

  @Test
  public void test() {
    var snake = CaseUtilsKt.toSnakeCase("Hola Mundo");

    System.out.println(snake);
  }
}
