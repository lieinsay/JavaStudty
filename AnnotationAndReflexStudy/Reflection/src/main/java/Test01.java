public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取对象
        Class c1 = Class.forName("User");
        Class c2 = User.class;
        Class c3 = new User().getClass();
        // 一个类在内存中只有个class对象
        // 一个类被加载后,类的整个结构都会被封装在class对象中。
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}



