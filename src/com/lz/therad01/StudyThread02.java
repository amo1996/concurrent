package com.lz.therad01;


/**
 * 1、继承Thread类
 */
public class StudyThread02 extends Thread{
       private int count=5;

    public StudyThread02(String name) {
            super();
            this.setName(name);
    }

    @Override
    public void run() {
      while (count>0){
          count--;
          System.out.println("由"+Thread.currentThread().getName()+"计算 count="+count);
      }
    }

    synchronized public static void main(String[] args) {
            // this.start();
        /** start的顺序不代表线程执行的顺序
           因为每次调用start()是 new 的一个新对象 所以count是线程私有的变量
         如果使用:
         StudyThread02 a=new StudyThread02();
         Thread A=new Thread(a,"A");
         Thread B=new Thread(a,"B");
         Thread C=new Thread(a,"C");
         这种方式就会共享count变量，产生非线程安全问题
         因为i-- 分为三步：
         1、取得原有i值
         2、计算i-1
         3、对i进行赋值
         在这几个步骤中，如果有多个线程同时访问，那么就会出现非线程安全问题
         当然   可以在 run 方法前面加上synchronized 关键字 就不会出现这种问题了
         非线程安全：指多个线程对同一个对象的同一个实例变量进行操作时会出现值被更改、值不同步的情况
         */
              new StudyThread02("A").start();
        new StudyThread02("B").start();
        new StudyThread02("C").start();
    }
}
