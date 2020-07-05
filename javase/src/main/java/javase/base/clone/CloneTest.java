package javase.base.clone;

/**
 *
 * 测试Clone方法
 *
 * @author: nano
 * @time: 2020/6/26 15:13
 */
public class CloneTest implements Cloneable{

	private int a;
	private int b;

	// 仅覆写clone()方法没有实现了Cloneable接口
	@Override
	public CloneTest clone() throws CloneNotSupportedException {
		// 调用Object类的clone方法并强制转型
		return (CloneTest)super.clone();
	}

}
