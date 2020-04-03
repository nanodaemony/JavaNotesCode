package javase.proxy.staticproxy;

/**
 * 用户服务普通实现类
 * @author nano
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
