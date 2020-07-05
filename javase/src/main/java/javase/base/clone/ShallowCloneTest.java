package javase.base.clone;

/**
 * 测试浅拷贝
 *
 * @author: nano
 * @time: 2020/6/26 15:30
 */
public class ShallowCloneTest implements Cloneable{


	private int[] array;      // 可变类，浅拷贝会造成原对象与拷贝后的对象对此子对象域共享
	private int index;      // 基本类型没问题
	private String name;    // String 等不可变类就算共享也安全因为不可变

	public ShallowCloneTest() {
		array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public void set(int index, int value) {
		array[index] = value;
	}

	public int get(int index) {
		return array[index];
	}

	// 覆写克隆方法 其实就是调用超类的clone方法，默认是浅克隆
	@Override
	public ShallowCloneTest clone() throws CloneNotSupportedException {
		return (ShallowCloneTest) super.clone();
	}


	public static void main(String[] args) {

		ShallowCloneTest object1 = new ShallowCloneTest();
		try {
			ShallowCloneTest object2 = object1.clone();   // 克隆e1
			// 改变e1，e2中的arr[]也被改变了。因为浅拷贝使两者共享此子对象
			object1.set(2, 222);
			System.out.println(object2.get(2));  // 222
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
