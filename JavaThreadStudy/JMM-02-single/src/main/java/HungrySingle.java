public class HungrySingle {

    // 提前创建出对象，可能会浪费空间
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];

    private HungrySingle() {
    }

    private final static HungrySingle HUNGRY_SINGLE = new HungrySingle();

    public static HungrySingle getInstance(){
        return HUNGRY_SINGLE;
    }
}
