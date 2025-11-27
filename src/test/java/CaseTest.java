import com.swelms.common.text.CaseUtilsKt;
import org.junit.Test;

public class CaseTest {

  @Test
  public void test() {
    var snake = CaseUtilsKt.snakeCase("Hola Mundo");

    System.out.println(snake);
  }
}
