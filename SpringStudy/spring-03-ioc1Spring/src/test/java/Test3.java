import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserServiceImpl;

public class Test3 {
    public static void main(String[] args) {
        //ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
