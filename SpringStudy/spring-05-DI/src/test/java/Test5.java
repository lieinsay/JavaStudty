import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Student student = context.getBean("student",Student.class);
//        Student studentt = context.getBean("student",Student.class);
//        studentt.setName("newlie");
//        System.out.println(student);
//        System.out.println(studentt);
    }
}
