package boot.controller;

import boot.pojo.User;
import boot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

     @RequestMapping("/index")
    public  User test(@RequestParam("id")Integer id){

        return userService.finuser(id);
    }
    @RequestMapping("/text")
    public  User getusername(@RequestParam("userName") String userName){
         return userService.getUserByUseruserName(userName);
    }
    @RequestMapping("/addUser")
    public  Object addUser(User user){
         User user1 =new User();
         user1.setUserCode("huawei");
         user1.setUserName("huawei");
        return userService.addUser(user1);

    }
}
