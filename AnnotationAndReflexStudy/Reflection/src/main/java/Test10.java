import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

// 通过反射获取泛型
public class Test10 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test10.class.getMethod("test01", Map.class, List.class);
        System.out.println(method);
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println("#"+type);
            if(type instanceof ParameterizedType){
                System.out.println("参数是泛型，里面的值为{");
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
                System.out.println("}");
            }
        }
        System.out.println("=======================");
        Method method1 = Test10.class.getMethod("test02");
        System.out.println(method1);
        Type type = method1.getGenericReturnType();
        if(type instanceof ParameterizedType){
            System.out.println("返回值是泛型，里面的值为{");
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
            System.out.println("}");
        }

    }
}
