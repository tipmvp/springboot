package boot.dao;
import boot.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User finuser(Integer id);

    User getUserByUseruserName(@Param("userName") String userName);

    User addUser(User user);


}
