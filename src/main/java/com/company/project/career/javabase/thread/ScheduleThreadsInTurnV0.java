package com.company.project.career.javabase.thread;

/**
 * 调度两个线程使之交替执行
 * 
 * @author zhangyanxiang 2020年9月18日 上午11:09:15
 */
public class ScheduleThreadsInTurnV0 {

    private static volatile int scheduleSwitch = 0; //偶数-a线程执行，奇数-b线程执行，打印100次；

    /**
     * a线程执行完了，通知b线程执行，（）<br>
     */

    public static void main(String[] args) throws InterruptedException {

        //        Thread a_Thread = new Thread(() -> {
        //            while (true) {
        //                synchronized (scheduleLock) {
        //                    System.out.println(Thread.currentThread().getName());
        //                    try {
        //                        scheduleLock.wait();
        //                    } catch (InterruptedException e) {
        //                        e.printStackTrace();
        //                    }
        //                }
        //            }
        //
        //        }, "===a_Thread");
        //
        //        Thread b_Thread = new Thread(() -> {
        //            System.out.println(Thread.currentThread().getName());
        //
        //        }, "===b_Thread====");

    }
}
