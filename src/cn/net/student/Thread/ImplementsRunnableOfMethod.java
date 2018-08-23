package cn.net.student.Thread;

public class ImplementsRunnableOfMethod implements Runnable {
	private Thread t;//声明线程
	private String ThreadName;//声明线程名
	
	public ImplementsRunnableOfMethod(String name) {
		this.ThreadName = name;
		System.out.println("creating the thread :" + ThreadName);
	}

	@Override
	public void run() {
	
			try {
				System.out.println("Running the thread :" + ThreadName);
				for(int i = 0; i < 10;i++){
					System.out.println("the thread :" + ThreadName + "第" + i);
					//让线程睡眠一会
					//Thread.sleep(50);
					//让线程从Running状态回到Runnable状态
					Thread.yield();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("the Thread :" + ThreadName + "interrupted");
			}
			System.out.println("the Thread :" + ThreadName + "exit");
	}
	
	
	public synchronized void start(){
		if(t == null){
			t = new Thread(this,ThreadName);
			//start()方法 使该线程开始执行；Java虚拟机调用该线程的run方法
			t.start();
			System.out.println("the Thread :" + ThreadName + "start");
		}
	}
	

}
