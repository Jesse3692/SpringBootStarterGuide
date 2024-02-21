import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiyanlou.Provider;
import com.shiyanlou.RabbitApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class RabbitApplicationTests {

    @Autowired
    private Provider provider;

    @Test
    public void providerTest() {
        provider.sendMessage("Hello Shiyanlou");
    }
}
