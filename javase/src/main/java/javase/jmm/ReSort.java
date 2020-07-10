package javase.jmm;

/**
 * 测试重排序
 *
 * @author: nano
 * @time: 2020/7/9 16:42
 */
public class ReSort {

	public static void main(String[] args) {
		// 优化前
		int x = 1;
		int y = 2;
		int a1 = x * 1;
		int b1 = y * 1;
		int a2 = x * 2;
		int b2 = y * 2;

//		// 优化后
//		int x = 1;
//		int y = 2;
//		int a1 = x * 1;
//		int a2 = x * 2;
//		int b1 = y * 1;
//		int b2 = y * 2;


//		int a = 0;
//		int b = 0;
//		int x = 0;
//		int y = 0;
//		// 处理器A执行
//		a = 1;
//		x = b;
//		// 处理器B执行
//		b = 2;
//		y = a;
	}

}
