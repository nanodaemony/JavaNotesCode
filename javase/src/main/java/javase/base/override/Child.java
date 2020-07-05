package javase.base.override;

import java.util.ArrayList;

/**
 * 测试覆写子类
 *
 * @author: nano
 * @time: 2020/6/25 15:20
 */
public class Child extends Father{

	@Override
	public ArrayList<Integer> test() throws RuntimeException {
		return new ArrayList<>();
	}

}
