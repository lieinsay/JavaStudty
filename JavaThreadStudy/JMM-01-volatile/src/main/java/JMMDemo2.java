public class JMMDemo2 {
    private volatile static int num = 0;
    public synchronized static void add(){
        num++;
        /**
         * getstatic    获得num
         * iconst_1     将num变成临时变量iconst_1
         * iadd         iconst_1+1
         * putstatic    将值返回给num
         * return       程序结束
         */
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(num);
    }
}
