package boot.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SerializeUtil {

	public static byte[] ObjTOSerialize(Object obj) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream byteOut = null;
		try {
			byteOut = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(byteOut);
			oos.writeObject(obj);
			byte[] bytes = byteOut.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * <p>
	 * Title: unSerialize
	 * </p>
	 * <p>
	 * Description: 反序列化
	 * </p>
	 *
	 * @param bytes
	 * @return
	 * @author
	 */
	public static Object unSerialize(byte[] bytes) {
		ByteArrayInputStream in = null;
		try {
			in = new ByteArrayInputStream(bytes);
			ObjectInputStream objIn = new ObjectInputStream(in);
			return objIn.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

       /* Jedis jedis = new Jedis("106.13.73.110");
        jedis.set("username","李华");
        System.out.println("jedis.get(\"username\") = " + jedis.get("username"));*/
        
        
		for (int i = 0; i < 50; i++) {
		new Thread(new MyThread()).start();
		}
	}

}
 /*连接redis*/
class MyThread implements Runnable {
	Jedis jedis = new Jedis("106.13.73.110");

	@Override
	public void run() {
		synchronized (MyThread.class) {
		String name = "华为";
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			String valueString = jedis.get("username");// 首先从redis查
			if (valueString == null) {// 如果redis没有
				System.out.println("从数据库中查到了" + name);// 从数据库中查询
				if(jedis.get("name")==null) {
					jedis.set("name", "华为");// 再次添加到redis
				}
				
			} else {
				System.out.println("从redis查到了" + valueString);
			}
		}

	}
}
