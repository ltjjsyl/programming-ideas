package cn.chuxiao.designpattern.callback.case1;

/**
 * 异步回调
 */
public class JVMHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }

    private static class ShutdownHook extends Thread {
        public void run() {
            System.out.println("I am called during shutting down.");
        }
    }
}
