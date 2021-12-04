import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 动态的创建对象，通过反射的方式
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class c1 = Class.forName("User");

        // 构造一个对象
        User user = (User)c1.getDeclaredConstructor(String.class,int.class,int.class).newInstance("LIE",1,1);
        System.out.println(user);

        // 通过反射调用普通方法
        User user1 = (User)c1.getDeclaredConstructor(String.class,int.class,int.class).newInstance("LIE",1,1);
        Method setName = c1.getDeclaredMethod("setName",String.class);
        setName.setAccessible(true);
        setName.invoke(user1,"FuckYou");
        System.out.println(user1);

        // 通过反射操作属性
        User user2 = (User)c1.getDeclaredConstructor(String.class,int.class,int.class).newInstance("LIE",1,1);
        Field field = c1.getDeclaredField("age");
        field.setAccessible(true); // 不能操作私有属性，需要关闭安全检测，需要让属性或者方法的setAccessible(true)
        field.set(user2,500);
        System.out.println(user2);
    }
}
