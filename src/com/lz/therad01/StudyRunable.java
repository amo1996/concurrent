package com.lz.therad01;

/**
 * extends Thread  implements Runnable
 * Runnable接口只有一个run()方法
 * Thread 构造方法 有
 * Thread(Runnable)
 * 所以启动实现接口Runnable的线程需要传入一个Runnable接口的实现类的对象
 */
public class StudyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("运行线程");
    }

    public static void main(String[] args) {
                 Thread t1=new Thread(new StudyRunable());
                 t1.start();
    }
}
