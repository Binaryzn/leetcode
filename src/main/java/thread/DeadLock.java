package thread;

/**
 * @Classname DeadLock
 * @Description TODO
 * @Date 2020/2/10 17:10
 * @Created by zheng.nie
 */
public class DeadLock {

    private static Object A = new Object();

    private Object B = new Object();

    public static void main(String[] args) {
        new DeadLock().deadLock();

    }

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try { Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

}
