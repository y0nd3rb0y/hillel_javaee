package com;

import java.util.concurrent.*;
public class ThreadCreationTest {
	public static void main(String[]args) throws ExecutionException, InterruptedException {
        System.out.println("main ->"+Thread.currentThread().getName());
        new CustomThread("my custom name ->").run();
		new Thread(new CustomRunnable()).start();
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<String> submit = service.submit(new CustomCallable());
		String s = submit.get();
		System.out.println("msg from thread"+s);
		service.shutdown();
        }
}
		class CustomRunnable implements Runnable {
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		}
		
		class CustomCallable implements Callable<String> {
			public String call() throws Exception {
				Thread.sleep(500);
				return "Hello";
			}
			
		}
        class CustomThread extends Thread {
			public CustomThread(String name){
				super(name);
			}
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }
		