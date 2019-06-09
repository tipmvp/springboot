package boot.util;

import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;

/**
 * @author XRZ
 * @date 2019/5/24
 * @Description :
 */
public class JsonData implements Serializable {

    private static final long SerialVersionUID=1L;

    private  Integer code;
    private Object data;
    private  String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public  JsonData(){};

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public  static  JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }
    public  static  JsonData buildSuccess(Object data){

        return new JsonData(0,data,null);
    }
    public  static JsonData buildError(String msg){
        return  new JsonData(-1,null,msg);
    }
    public static JsonData buildError(String msg,Integer code){
        return new JsonData(code,null,msg);
    }
    public  static  JsonData buildSuccess(Object data,String msg){
        return new JsonData(0,data,msg);
    }
    public  static  JsonData buildSuccess(Object data, int code){
        return  new JsonData(code,data,null);
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
