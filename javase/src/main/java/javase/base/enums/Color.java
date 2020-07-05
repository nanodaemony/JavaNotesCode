package javase.base.enums;

/**
 * 演示枚举模板
 *
 * @author: nano
 * @time: 2020/6/25 17:30
 */
public enum Color {

	RED("红色", 1),
	GREEN("绿色", 2),
	BLANK("白色", 3),
	YELLO("黄色", 4);  //定义枚举实例


	// 自定义成员变量
	private String name;
	private int index;

	// 定义构造方法
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}
	// 添加方法
	public static String getName(int index) {
		for (Color c : Color.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}
	// get set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
