package javase.thread.produceandcondumer;

/**
 * @author: nano
 * @time: 2020/8/1 14:46
 */
public class ProduceThread implements Runnable{

	private PCService service;

	public ProduceThread(PCService service) {
		this.service = service;
	}

	@Override
	public void run() {
		for (;;) {
			// 不断生产
			service.produce();
		}
	}

}
