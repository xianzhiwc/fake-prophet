package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultiThreadTest {
    static class MyThread implements Callable<String> {  //ʵ��Callable�ӿ�
        @Override
        public String call() throws Exception {    /*Callable�涨��call()���������з���ֵ��
        	                                                                          Ҳ�����׳��쳣*/
            return "Hello world";
        }
    }


    static class MyThread2 implements Runnable {   //ʵ��Runnable�ӿ�
        @Override
        public void run() {            /*Runnable�涨��run()���������з���ֵ�������׳��쳣*/

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