package boot.service;
import boot.pojo.User;
import java.util.List;
public interface UserService {

    User finuser(Integer id);

    User getUserByUseruserName(String userName);

    User addUser(User user);
}
