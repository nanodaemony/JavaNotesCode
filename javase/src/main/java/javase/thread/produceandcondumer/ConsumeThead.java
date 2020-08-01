package javase.thread.produceandcondumer;

/**
 * @author: nano
 * @time: 2020/8/1 14:46
 */
public class ConsumeThead implements Runnable{

	private PCService service;

	public ConsumeThead(PCService service) {
		this.service = service;
	}

	@Override
	public void run() {
		for (;;) {
			// 不但消费
			service.consume();
		}
	}
}
