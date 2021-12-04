public class TestLambda {
    static class LikeInner implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like Lambda 内部类");
        }
    }

    public static void main(String[] args) {
        // 外部类
        ILike like1 = new LikeOUT();
        like1.lambda();
        // 内部类
        ILike like2 = new LikeInner();
        like2.lambda();
        // 局部内部类
        class LikeLocalInner implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like Lambda 局部内部类");
            }
        }
        ILike like3 = new LikeLocalInner();
        like3.lambda();
        // 匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda 匿名内部类");
            }
        };
        like4.lambda();
        // lambda简化(只能简化单个方法的接口)
        ILike like5 = ()->{
            System.out.println("I like Lambda lambda简化");
        };
        like5.lambda();
    }
}

interface ILike{
    void lambda();
}

class LikeOUT implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like Lambda 外部类");
    }
}