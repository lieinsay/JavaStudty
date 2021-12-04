public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        // forName获取
        Class c1 = Class.forName("Student");
        System.out.println(c1);
        // 类名.class获取
        Class c2 = Student.class;
        System.out.println(c2);
        // 通过对象获得
        Class c3 = person.getClass();
        System.out.println(c3);
        // 基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);
        // 获取父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "老师";
    }
}