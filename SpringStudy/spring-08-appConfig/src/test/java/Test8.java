import com.lie.config.TestConfig;
import com.lie.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test8 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
//        User user1 = context.getBean("user", User.class);
//        User user2 = context.getBean("user", User.class);
//        System.out.println(user1);
//        System.out.println(user2);
    }
}
