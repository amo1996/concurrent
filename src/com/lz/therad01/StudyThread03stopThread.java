package com.lz.therad01;


/**
 * 1、继承Thread类
 */
public class StudyThread03stopThread extends Thread{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
            StudyThread03stopThread s3=new StudyThread03stopThread();
            Thread t1=new Thread(s3);
            s3.interrupt();//表示停止线程  仅仅是设置一个标记 并不是真的停止线程
    }
}
