package cc.juddar.other;

/**
 * @Description
 * @Author dasongju
 * @Date 2018/9/27 下午9:11
 */
public class MyThreadLocal {
    private static ThreadLocal<Long> intLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                intLocal.set(1L);
                System.err.println(intLocal.get());
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                intLocal.set(2L);
                System.err.println(intLocal.get());
            }
        });
        t2.start();


    }
}
