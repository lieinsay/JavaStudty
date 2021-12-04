import java.lang.annotation.*;

// 表示注解可以用在那些地方
@Target({ElementType.METHOD})
// 表示注解在什么地方还有效 RUNTIME > CLASS > SOURCE
@Retention(RetentionPolicy.RUNTIME)
// 表示是否将注解生成在javaDoc中
@Documented
// 子类可以继承父类的注解
@Inherited
public @interface MyAnnotation{
    String name() default "";
    int age() default 0;
    int id() default -1;// 默认值为-1.代表不存在
    String[] schools() default {"xxx大学"};
}
