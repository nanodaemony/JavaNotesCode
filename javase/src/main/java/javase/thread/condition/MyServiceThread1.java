package javase.thread.condition;

/**
 * @author: nano
 * @time: 2020/8/1 14:40
 */
public class MyServiceThread1 implements Runnable{

	private MyService service;

	public MyServiceThread1(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitA();
	}
}
