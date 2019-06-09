package boot.service.impl;
import boot.dao.UserMapper;
import boot.pojo.User;
import boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value="user")//首先从缓存找数据，如果缓存中没有，就从数据库查找，然后再添加到缓存
    public User finuser(Integer id) {
        System.out.println("执行了数据库查找");
        User user=this.userMapper.finuser(id);
        return user;
    }

    @Override
    @Cacheable(value="user")
    public User getUserByUseruserName(String userName) {
        System.err.println("执行了数据库的查找");
        User user=this.userMapper.getUserByUseruserName(userName);
        return user;
    }

    @Override
    @CachePut(value="base:user1")
    public User addUser(User user) {
        System.out.println("执行了数据库更新");
        return this.userMapper.addUser(user);
    }
}
