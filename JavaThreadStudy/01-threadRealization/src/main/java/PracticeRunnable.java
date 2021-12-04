public class PracticeRunnable implements Runnable{
    private String url;
    private String name;

    public PracticeRunnable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        PracticeThread practiceThread1 = new PracticeThread("https://i1.hdslb.com/bfs/archive/f0b1a9c6da013a0a0d60610b57b8e92a266a0035.png@412w_232h_1c.png","【永劫无间】岳山~新版本新发型新捏脸新英雄新分享新JoHnathanZ的捏脸剪剪.jpg");
        PracticeThread practiceThread2 = new PracticeThread("https://i0.hdslb.com/bfs/archive/b12b6c6141eb9626875164df06477c3e0f0db242.jpg@412w_232h_1c.jpg","你是我遥不可及的浪漫.jpg");
        PracticeThread practiceThread3 = new PracticeThread("https://i2.hdslb.com/bfs/archive/37bf064cebafeeff5e5556dd2df533f372b6559a.jpg@412w_232h_1c.jpg","【永劫无间】修罗私货 太刀进阶教学 高端局才有的博弈操作 看完你也行.jpg");
        Thread thread1 = new Thread(practiceThread1);
        Thread thread2 = new Thread(practiceThread2);
        Thread thread3 = new Thread(practiceThread3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
