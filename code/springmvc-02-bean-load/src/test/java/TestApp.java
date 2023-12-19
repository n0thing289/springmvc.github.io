import com.itheima.config.SpringConfig;
import com.itheima.controller.UserController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
    @Test
    public void test(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController u = ac.getBean(UserController.class);
        System.out.println(u);
    }
}
