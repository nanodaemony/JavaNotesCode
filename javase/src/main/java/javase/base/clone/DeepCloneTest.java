package javase.base.clone;

import lombok.Data;

/**
 * @author: nano
 * @time: 2020/6/26 15:44
 */
@Data
public class DeepCloneTest implements Cloneable{

	private int[] array;
	private int index;
	private String name;

	public DeepCloneTest() {
		array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	// 重写实现了一个实现了深拷贝的clone方法
	@Override
	public DeepCloneTest clone() throws CloneNotSupportedException {
		// 先用Object的默认方法生成一个对象
		DeepCloneTest result = (DeepCloneTest) super.clone();
		// 再克隆该对象的全部可变类子类的内容（全部状态）
		result.array = new int[array.length];
		// 依次复制
		for (int i = 0; i < array.length; i++) {
			result.array[i] = array[i];
		}
		// 复制安全的属性
		result.index = this.index;
		result.name = this.name;
		return result;
	}

	public void set(int index, int value) {
		array[index] = value;
	}

	public int get(int index) {
		return array[index];
	}

	public static void main(String[] args) {
		DeepCloneTest object1 = new DeepCloneTest();
		try {
			// 克隆e1
			DeepCloneTest object2 = object1.clone();
			// 修改对象1
			object1.set(2, 222);
			// 由于是深拷贝，对象2不受影响，结果为2
			System.out.println(object2.get(2));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}


}
