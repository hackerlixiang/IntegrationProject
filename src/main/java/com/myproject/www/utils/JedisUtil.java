package com.myproject.www.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * redis辅助工具类
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class JedisUtil
{
    
    private static String db;
    
    private static JedisPool pool;
    
    static
    {
    	Properties property = new Properties();
		try {
			InputStream propertiesFileStream = System.class.getResourceAsStream("/config/properties/redis.properties");
			property.load(propertiesFileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//        PropertiesCache property = new PropertiesCache("redis.properties");
        String ip = property.getProperty("redis.master.url");
        String port = property.getProperty("redis.master.port");
        db = property.getProperty("redis.master.db");
        pool = new JedisPool(new JedisPoolConfig(), ip, Integer.valueOf(port));
    }
    
    private static Jedis getJedis() throws Exception
    {
        Jedis redis = pool.getResource();
        redis.select(Integer.valueOf(db));
        return redis;
    }
    
    private static void giveBack(Jedis redis) throws Exception
    {
        if (redis != null)
        {
            pool.returnResource(redis);
        }
    }
    
    /**
     * 获取redis所有key
     * @return
     * @throws Exception
     */
    public static Set<String> getAllKeys() throws Exception
    {
        Jedis redis = getJedis();
        Set<String> keys = redis.keys("*");
        giveBack(redis);
        return keys;
    }
    
    /**
     * 清空所有key（谨慎使用）
     * @return
     * @throws Exception
     */
    public static String clear() throws Exception
    {
        Jedis redis = getJedis();
        String result = redis.flushAll();
        giveBack(redis);
        return result;
    }
    
    /**
     * 更改key的名称（谨慎使用）
     * @return
     * @throws Exception
     */
    public static String rename(String key, String newKey) throws Exception
    {
        Jedis redis = getJedis();
        String result = redis.rename(key, newKey);
        giveBack(redis);
        return result;
    }
    
    /**
     * 获取key对应值的类型
     * @return
     * @throws Exception
     */
    public static String getType(String key) throws Exception
    {
        Jedis redis = getJedis();
        String result = redis.type(key);
        giveBack(redis);
        return result;
    }
    
    public static String getVal(String key) throws Exception
    {
        Jedis redis = getJedis();
        String result = redis.get(key);
        giveBack(redis);
        return result;
    }
    
    /**
     * key是否存在
     * @return
     * @throws Exception
     */
    public static boolean exists(String key) throws Exception
    {
        Jedis redis = getJedis();
        boolean ret = redis.exists(key);
        giveBack(redis);
        return ret;
    }
    
    /**
     * 删除redis的key对应的值
     * @param key
     * @return
     * @throws Exception
     */
    public static long del(String... keys) throws Exception
    {
        Jedis redis = null;
        try
        {
            redis = getJedis();
            long ret = redis.del(keys);
            if (ret < 1)
            {
                for (String string : keys)
                {
                    del(string);
                }
            }
            return ret;
        }
        catch (JedisConnectionException e)
        {
            pool.returnBrokenResource(redis);
            redis = null;
            throw e;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            giveBack(redis);
        }
    }
    
    /**
     * 删除redis的key对应的值
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static long del(String key) throws Exception
    {
        long ret = 0;
        Jedis redis = null;
        try
        {
            redis = getJedis();
            // 如果key不存在
            if (!redis.exists(key))
            {
                return ret;
            }
            ret = redis.del(key);
        }
        finally
        {
            giveBack(redis);
        }
        
        return ret;
    }
    
    public static String add(String key, String value) throws Exception
    {
        Jedis redis = getJedis();
        String ret = redis.set(key, value);
        giveBack(redis);
        return ret;
    }
    
    public static String add(String key, int seconds, String value) throws Exception
    {
        Jedis redis = getJedis();
        String ret = redis.setex(key, seconds, value);
        giveBack(redis);
        return ret;
    }
    
    /**
     * 批量增加key，value键值对
     * @param keysvalues = 键值对字符串，如："haha","111","xixi","222"
     * @return
     * @throws Exception
     */
    public static String addMoreString(final String... keysvalues) throws Exception
    {
        Jedis redis = getJedis();
        String ret = redis.mset(keysvalues);
        giveBack(redis);
        return ret;
    }
    
    /**
     * 批量获取key，value键值对
     * @param keys = 键字符串，如："haha","xixi"
     * @return
     * @throws Exception
     */
    public static List<?> getMore(final String... keys) throws Exception
    {
        Jedis redis = getJedis();
        List<?> list = redis.mget(keys);
        giveBack(redis);
        return list;
    }
    
    /**
     * 设置哈希表的值
     * @param tableKey = 哈希表名
     * @param key = 域
     * @param value = 值
     * @return
     * @throws Exception
     */
    public static String setMap(String tableKey, Map<String, String> map) throws Exception
    {
        Jedis redis = null;
        try
        {
            redis = getJedis();
            String ret = redis.hmset(tableKey, map);
            return ret;
        }
        catch (JedisConnectionException e)
        {
            pool.returnBrokenResource(redis);
            redis = null;
            throw e;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            giveBack(redis);
        }
    }
    
    /**
     * 获取哈希表的值
     * @param tableKe = 哈希表名
     * @return
     * @throws Exception
     */
    public static Map<String, String> getMap(String tableKey) throws Exception
    {
        Jedis redis = null;
        try
        {
            redis = getJedis();
            Map<String, String> ret = redis.hgetAll(tableKey);
            return ret;
        }
        catch (JedisConnectionException e)
        {
            pool.returnBrokenResource(redis);
            redis = null;
            throw e;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            giveBack(redis);
        }
    }
    
    /**
     * 增加list数据集合
     * @param tableKey
     * @param map
     * @return
     * @throws Exception
     */
    public static long addToList(String key, String value) throws Exception
    {
        Jedis redis = getJedis();
        long ret = redis.lpush(key, value);
        giveBack(redis);
        return ret;
    }
    
    /**
     * 获取list列表区间值
     * @param key =列表key
     * @param start =区间开始位置，初始值0
     * @param end =区间结束位置，初始值-1 说明：参数start和end都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素
     *            ，以此类推。你也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
     * @return
     * @throws Exception
     */
    public static List<String> getList(String key, long start, long end) throws Exception
    {
        Jedis redis = getJedis();
        List<String> list = redis.lrange(key, start, end);
        giveBack(redis);
        return list;
    }
    
    /**
     * 根据字节key获取数据
     * @param bytes
     * @return byte[]
     * @throws Exception
     */
    public static Object getObject(String key) throws Exception
    {
        Jedis redis = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream inputStream = null;
        try
        {
            redis = getJedis();
            
            byte[] bs = redis.get(key.getBytes());
            
            if (bs != null)
            {
                bis = new ByteArrayInputStream(bs);
                return new ObjectInputStream(bis).readObject();
            }
        }
        finally
        {
            if (bis != null)
            {
                bis.close();
            }
            if (inputStream != null)
            {
                inputStream.close();
            }
            giveBack(redis);
        }
        return null;
    }
    
    /**
     * 根据字节key获取对象
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String setObject(String key, Object object) throws Exception
    {
        Jedis redis = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try
        {
            // 对象序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            byte[] byteArray = bos.toByteArray();
            
            redis = getJedis();
            return redis.set(key.getBytes(), byteArray);
        }
        finally
        {
            if (oos != null)
            {
                oos.close();
                bos.close();
            }
            giveBack(redis);
        }
    }
    
    /**
     * 添加元素到redis-SET集合 <功能详细描述>
     * @param key
     * @param member
     * @return
     * @throws Exception
     * @return long
     */
    public static long sadd(String key, String member) throws Exception
    {
        Jedis redis = getJedis();
        long result = redis.sadd(key, member);
        giveBack(redis);
        return result;
    }
    
    /**
     * 将元素从redis-set集合中删掉 <功能详细描述>
     * @param key
     * @param member
     * @return
     * @throws Exception
     * @return long
     */
    public static long srem(String key, String member) throws Exception
    {
        Jedis redis = getJedis();
        long result = redis.srem(key, member);
        giveBack(redis);
        return result;
    }
    
    public static Set<String> smembers(String key) throws Exception
    {
        Jedis redis = getJedis();
        Set<String> set = redis.smembers(key);
        giveBack(redis);
        return set;
    }
    
    public static void main(String[] args)
    {
        try
        {
            System.out.println("=============keys=============");
            Set<String> keys = (Set<String>) getAllKeys();
            Iterator<String> t3 = keys.iterator();
            while (t3.hasNext())
            {
                Object obj3 = t3.next();
                System.out.println(obj3+"="+getVal(obj3.toString()));
            }
//            clear();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * <一句话功能简述>
     * 模糊查询满足条件的key
     * @param key
     * @return
     * 
     * @return Set<String>
     * @throws Exception 
     */
    public static Set<String> getKeys(String key) throws Exception
    {
        Jedis redis = getJedis();
        if (StringUtils.isBlank(key))
        {
            key = "*";
        }
        Set<String> keys = redis.keys(key);
        giveBack(redis);
        return keys;
    }
    
}
