public class LazySingle {

    private static boolean flag = false;

    private LazySingle() {
        synchronized (LazySingle.class){
            if(false == false){
                flag = true;
            }else{
                throw new RuntimeException("静止用反射破坏单例");
            }
        }
    }

    private static LazySingle lazySingle;

    public static LazySingle getInstance() {
        if (lazySingle == null) {
            synchronized (LazySingle.class){
                if (lazySingle == null) {
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }
}
