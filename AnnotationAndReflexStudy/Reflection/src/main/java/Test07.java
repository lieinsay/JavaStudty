import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        User user = new User();
        Class c1 = Class.forName("User");
        c1 = user.getClass();

        // 获得类名 包名
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        System.out.println("==================================");
        // 获得类的属性
        Field[] fields = c1.getDeclaredFields();
//        c1.getFields(); // 只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("==================================");
        // 获取指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        System.out.println("==================================");
        // 获取类的方法
        Method[] methods = c1.getMethods(); // 获得本类及其父类的所有public方法
        System.out.println("获得本类的所有方法");
        for (Method method : methods) {
            System.out.println(method);
        }
        methods = c1.getDeclaredMethods(); // 获得仅本类的所有方法
        System.out.println("获得仅本类书写的方法");
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("==================================");
        // 获得指定方法
        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName",String.class);
        System.out.println(getName);
        System.out.println(setName);
        System.out.println("==================================");
        // 获取指定的构造器
        Constructor[] constructors = c1.getConstructors();
        System.out.println("获得本类的所有public构造方法");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        System.out.println("获得本类的所有构造方法");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("==================================");
        // 获取指定的构造器
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class,int.class);
        System.out.println(constructor);
        System.out.println("==================================");
    }
}
