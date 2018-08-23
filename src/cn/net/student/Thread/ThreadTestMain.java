package cn.net.student.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTestMain {
	/**
	 * 创建线程的三种方式的对比
		1. 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
		
		2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
		笔记：通过学习线程，我发现创建线程方式本质上其实就是两种类型，第一种就是实现Runnable接口，但这种从形式上会有两种，第一种创建线程类直接实现Runnable接口，
		第二种，创建线程类继承Thread类本身，但这种本质还是实现了Runable类的形式，以我目前所学的内容看，实现Runnable本质有这两种展示形式，第二种，就是创建线程类，
		实现Callable接口，而这种展现形式目前只知道一种，过程：首先创建线程类实现Callable接口，然后创建此类的实例，再然后通过FutureTask类将此实例对象包装,再然后将
		FutureTask对象作为Thread类的对象的target创建和开启新线程，最后调用FutureTask的get()方法来获得此子线程执行结束后的返回值。——David WEN
	 * @param args
	 */

	public static void main(String[] args) {
		/*
		 * 1、通过实现Runnable接口创建线程
		 */
//		int startTime = (int) System.currentTimeMillis();
//		ImplementsRunnableOfMethod runnable = new ImplementsRunnableOfMethod("Thread-1");
//		runnable.start();
//		ImplementsRunnableOfMethod runnable2 = new ImplementsRunnableOfMethod("Thread-2");
//		runnable2.start();
//		ImplementsRunnableOfMethod runnable3 = new ImplementsRunnableOfMethod("Thread-3");
//		runnable3.start();
//		int finishTime = (int) System.currentTimeMillis();
//		System.out.println("开始时间："+startTime+"\n结束时间："+finishTime+"\n运行时间："+ (finishTime - startTime));
		/*
		 * 2、内部类实现线程
		 */
//		Thread t = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				for(int i = 0;i < 4;i++){
//					System.out.println("内部类实现线程:"+i);
//				}
//				
//			}
//			
//		},"Thread-2");
//		t.start();
		/*
		 *3、通过继承Thread本身实现线程的方法
		 */
//		ExtendsThreadOfMenthod thread = new ExtendsThreadOfMenthod("Thread - one");
//		thread.start();
		/*
		 *4、通过实现Callable接口创建线程
		 */
		ByCallableAndFutureOfMenthod ctt = new ByCallableAndFutureOfMenthod();  
        FutureTask<Integer> ft = new FutureTask<>(ctt);  
        for(int i = 0;i < 100;i++)  
        {  
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);  
            if(i==20)  
            {  
                new Thread(ft,"有返回值的线程").start();  
            }  
        }  
        try  
        {  
            System.out.println("子线程的返回值："+ft.get());  
        } catch (InterruptedException e)  
        {  
            e.printStackTrace();  
        } catch (ExecutionException e)  
        {  
            e.printStackTrace();  
        }  
		
	}

}
