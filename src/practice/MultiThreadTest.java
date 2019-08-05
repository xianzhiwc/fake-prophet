package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultiThreadTest {
    static class MyThread implements Callable<String> {  //实现Callable接口
        @Override
        public String call() throws Exception {    /*Callable规定的call()方法可以有返回值，
        	                                                                          也可以抛出异常*/
            return "Hello world";
        }
    }


    static class MyThread2 implements Runnable {   //实现Runnable接口
        @Override
        public void run() {            /*Runnable规定的run()方法不能有返回值，不可抛出异常*/

        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new MyThread());

        try {
            System.out.println(future.get());
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();
        }
    }
}