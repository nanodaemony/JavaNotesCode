package javase.thread.condition;

/**
 * @author: nano
 * @time: 2020/8/1 14:40
 */
public class MyServiceThread2 implements Runnable{

	private MyService service;

	public MyServiceThread2(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitB();
	}
}
