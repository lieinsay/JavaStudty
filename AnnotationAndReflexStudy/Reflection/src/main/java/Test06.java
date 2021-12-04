public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException {

        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类的加载器的父类加载器-->扩展加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 或者扩展类加载器的父类加载器-->跟加载器(C/C++)
        ClassLoader grandparent = parent.getParent();
        System.out.println(grandparent);

        // 当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("Test06").getClassLoader();
        System.out.println(classLoader);

        // JDK内部的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("JDK内部的类是谁加载的:"+classLoader1);

        // 如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        // E:\My Lie\make\java\AnnotationAndReflex\Reflection\target\classes

        // 双亲委派机制
    }
}
