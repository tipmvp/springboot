package boot.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author XRZ
 * @date 2019/5/24
 * @Description :
 */
public class JsonUtils {

    public  static ObjectMapper objectMapper=new ObjectMapper();
    //对象转字符串
    public  static<T> String obj2ting(T obj){
        if (obj ==null){
            return  null;
        }
        try {
            return  obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
    //字符串转对象
    public  static <T> T string2obj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str) || clazz==null){
            return null;
        }
        try {
            return clazz.equals(String.class)?(T) str:objectMapper.readValue(str,clazz);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
