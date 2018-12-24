package cn.net.student.Thread;

import java.util.concurrent.Callable;

public class ByCallableAndFutureOfMenthod implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int i = 0;  
        	for(;i<100;i++)  
        	{  
            		System.out.println("call : "+Thread.currentThread().getName()+" "+i);  
        	}  
        	return i;  
	}

}
