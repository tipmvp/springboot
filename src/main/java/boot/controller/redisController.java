package boot.controller;

import boot.pojo.User;
import boot.util.JsonData;
import boot.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRZ
 * @date 2019/5/24
 * @Description :
 */
@RestController
@RequestMapping("redis")
public class redisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

 @RequestMapping("/setreids")
 public  Object setRedis(){
   redisTemplate.opsForValue().set("name","张三");
     return JsonData.buildSuccess();
 }
    @RequestMapping("/getreids")
    public  Object getreids(){
     String value=redisTemplate.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }
    @RequestMapping("/setadduser")
    public  Object setadduser(){
        User user=new User();
        user.setUserCode("huawei");
        user.setUserName("华为");
        String userStr= JsonUtils.obj2ting(user);//对象转字符串
        redisTemplate.opsForValue().set("base:user",userStr);
        return JsonData.buildSuccess();

    }
    @RequestMapping("/getadduser")
    public  Object getadduser(){
        String value=redisTemplate.opsForValue().get("base:user");
        User user= JsonUtils.string2obj(value,User.class);//字符串转对象
        return JsonData.buildSuccess(user);

    }
}
