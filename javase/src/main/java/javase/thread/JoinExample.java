package javase.thread;

/**
 * @author: nano
 * @time: 2020/8/1 14:29
 */
public class JoinExample {

	private class A extends Thread {
		@Override
		public void run() {
			System.out.println("A");
		}
	}

	private class B extends Thread {
		// 传入线程A的实例
		private A a;

		B(A a) {
			this.a = a;
		}

		@Override
		public void run() {
			try {
				// 等待线程A执行
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("B");
		}
	}

	public void test() {
		// 开启线程A
		A a = new A();
		// 将线程A传入线程B
		B b = new B(a);
		// 开启线程B，但是线程B需要等待线程A先执行完毕
		b.start();
		// 开启线程A
		a.start();
	}

	public static void main(String[] args) {
		JoinExample example = new JoinExample();
		example.test();
	}
}
