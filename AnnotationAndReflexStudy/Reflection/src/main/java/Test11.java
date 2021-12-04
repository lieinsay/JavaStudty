import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 反射操作注解
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class aClass = Class.forName("Student2");


        // 通过反射获得注解
        Annotation[] annotations = aClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解的value值
        TableLie tableLie = (TableLie)aClass.getAnnotation(TableLie.class);
        String value = tableLie.value();
        System.out.println(value);

        System.out.println("id================================");
        Field id = aClass.getDeclaredField("id");
        id.setAccessible(true);
        FieldLie fieldLieId = id.getAnnotation(FieldLie.class);
        System.out.println(fieldLieId.colName());
        System.out.println(fieldLieId.type());
        System.out.println(fieldLieId.length());

        Student2 student2 = new Student2();
        Method changeId = aClass.getDeclaredMethod("changeId", String.class, String.class, int.class);
        changeId.setAccessible(true);
        changeId.invoke(student2,fieldLieId.colName(),fieldLieId.type(),fieldLieId.length());


        System.out.println("age================================");
        Field age = aClass.getDeclaredField("age");
        FieldLie fieldLieAge = age.getAnnotation(FieldLie.class);
        System.out.println(fieldLieAge.colName());
        System.out.println(fieldLieAge.type());
        System.out.println(fieldLieAge.length());

        System.out.println("name================================");
        Field name = aClass.getDeclaredField("name");
        FieldLie fieldLieName = name.getAnnotation(FieldLie.class);
        System.out.println(fieldLieName.colName());
        System.out.println(fieldLieName.type());
        System.out.println(fieldLieName.length());

    }
}

@TableLie("db_student")
class Student2{
    @FieldLie(colName = "db_id",type = "int",length = 10)
    private int id;
    @FieldLie(colName = "db_age",type = "int",length = 10)
    private int age;
    @FieldLie(colName = "db_name",type = "varchar",length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void changeId(String colName,String type,int length){
        System.out.println(colName+type+length);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLie{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldLie{
    String colName();
    String type();
    int length();
}