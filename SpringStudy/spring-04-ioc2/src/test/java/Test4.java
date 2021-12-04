import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        User user0 = (User) context.getBean("user0");
        System.out.println(user0);
        User user1 = (User) context.getBean("user1");
        System.out.println(user1);
        User user2 = (User) context.getBean("user2");
        System.out.println(user2);
        User user3 = (User) context.getBean("user3");
        System.out.println(user3);
        User user4 = (User) context.getBean("user4");
        System.out.println(user4);
    }
}
