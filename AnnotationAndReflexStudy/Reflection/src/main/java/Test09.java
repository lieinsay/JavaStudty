import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 分析性能问题
public class Test09 {
    // 普通方式调用
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式调用1000000000:"+(endTime-startTime)+"ms");
    }
    // 反射方式调用
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = Class.forName("User");
        Method getName = c1.getDeclaredMethod("getName");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式调用1000000000:"+(endTime-startTime)+"ms");
    }
    // 反射方式调用 关闭检测
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = Class.forName("User");
        Method getName = c1.getDeclaredMethod("getName");
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式调用1000000000（关闭检测）:"+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
        /*
        * 普通方式调用1000000000:4ms
        * 反射方式调用1000000000:2411ms
        * 反射方式调用1000000000（关闭检测）:1055ms
        * */
    }
}
