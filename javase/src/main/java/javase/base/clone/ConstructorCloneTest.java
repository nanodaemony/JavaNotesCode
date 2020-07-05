package javase.base.clone;

import java.util.Iterator;

/**
 * 测试用拷贝构造方法克隆
 *
 * @author: nano
 * @time: 2020/6/26 15:51
 */
public class ConstructorCloneTest {

	private int[] array;

	// 默认构造方法
	public ConstructorCloneTest() {
		array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	// 实现一个可以进行深拷贝的构造方法,传入需要拷贝的原对象
	public ConstructorCloneTest(ConstructorCloneTest original) {
		array = new int[original.array.length];

		// 依次将原对象的信息拷贝出来
		for (int i = 0; i < original.array.length; i++) {
			array[i] = original.array[i];
		}
	}

	public void set(int index, int value) {
		array[index] = value;
	}

	public int get(int index) {
		return array[index];
	}

	public static void main(String[] args) {
		ConstructorCloneTest object1 = new ConstructorCloneTest();     // 构造e1
		ConstructorCloneTest object2 = new ConstructorCloneTest(object1);   // 拷贝e1
		object1.set(2, 222);
		System.out.println(object2.get(2));      // 2 实现深拷贝

		int[] a = new int[4];
		a.clone();
	}

}
