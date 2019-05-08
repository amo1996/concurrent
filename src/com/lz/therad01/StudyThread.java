package com.lz.therad01;


/**
 * 1、继承Thread类
 */
public class StudyThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println(super.getName());
        System.out.println(new StudyThread().getName());
        System.out.println(this.isAlive());
    }

    public static void main(String[] args) {
       //    new StudyThread().start(); //通知线程规划器 此线程已经准备就绪，等待调用run()方法
        Thread a= new StudyThread();
        System.out.println(a.isAlive());  //判断此线程是否处于活动状态
        a.start();
    }
}
