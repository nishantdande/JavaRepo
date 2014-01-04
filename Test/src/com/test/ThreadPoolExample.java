package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample implements Runnable {

	int id;
	
	public ThreadPoolExample(int id) {
		this.id=id;
	}
	
	@Override
	public void run() {
		System.out.println("My Task : "+id+ " by "+Thread.currentThread().getName());
		/*ExecutorService service=Executors.newFixedThreadPool(3);
		for (int i = 1000; i < 1050; i++) {
			service.submit(new ThreadPoolExample(i));
		}*/
	}

}
