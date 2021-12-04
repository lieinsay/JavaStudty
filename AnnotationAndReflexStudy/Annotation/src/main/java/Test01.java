import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Test01 extends Object{

    // 重写的注解
    @Override
    public String toString() {
        return "Test01{}";
    }

    // 不推荐程序员使用，但能用，或者存在更好的方式
    @Deprecated
    public void test01(){
        System.out.println("sdfsdf");
    }

    //@SuppressWarnings("all") //镇压警告
    public void test02(){
        List list = new LinkedList();

    }

    @MyAnnotation(name = "LIE",age = 22,schools = {"sdfsdf","sdfs"})
    public void test03(){
        Class<Test01> c1 = Test01.class;
        Method[] methods = c1.getDeclaredMethods();
        for(Method method : methods){
            boolean methodHasAnno = method.isAnnotationPresent(MyAnnotation.class);
            if(methodHasAnno){
                //得到注解
                MyAnnotation methodAnno = method.getAnnotation(MyAnnotation.class);
                //输出注解属性
                int desc = methodAnno.age();
                System.out.println(method.getName() + " desc = " + desc);
            }
        }
    }
}
