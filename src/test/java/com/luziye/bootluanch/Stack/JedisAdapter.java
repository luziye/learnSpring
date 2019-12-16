package com.luziye.bootluanch.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.List;

public class JedisAdapter {
    private static final Logger logger = LoggerFactory.getLogger(JedisAdapter.class);
    JedisPool pool = new JedisPool("redis://localhost:6379/");


    public long sadd(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sadd(key, value);
        } catch (Exception e) {
            logger.error("发生异常"+e.getMessage());
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return 0;
    }
    public long srem(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.srem(key, value);
        } catch (Exception e) {
            logger.error("发生异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

    public long scard(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.scard(key);
        } catch (Exception e) {
            logger.error("发生异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

    public boolean sismember(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sismember(key, value);
        } catch (Exception e) {
            logger.error("发生异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    public List<String> brpop(int timeout, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.brpop(timeout, key);
        } catch (Exception e) {
            logger.error("发生异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public long lpush(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpush(key, value);
        } catch (Exception e) {
            logger.error("发生异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

    public static void display(int index,Object o){
        System.out.println(String.format("%d, %s", index, o.toString()));

    }
    public static void main(String[] args) {
        Jedis jedis=new Jedis("redis://localhost:6379/");
        //get set
        jedis.set("age","20");
        display(1,jedis.get("age"));
        jedis.rename("age","newage");
        display(1,jedis.get("newage"));
        jedis.setex("expire",10,"100");
        display(1,jedis.get("expire"));

        jedis.set("pv","100");
        jedis.incr("pv");
        jedis.incrBy("pv",5);
        display(2,jedis.get("pv"));
        jedis.decrBy("pv",2);
        display(2,jedis.get("pv"));
        jedis.del("100");
        display(3,jedis.keys("*"));

        String listName="list";
        jedis.del(listName);
        for (int i=10;i>=1;i--){
            jedis.lpush(listName,"a"+String.valueOf(i));
        }
        display(4,jedis.lrange(listName,0,3));
        display(4,jedis.lrange(listName,2,5));
        display(5,jedis.llen(listName));
        display(6,jedis.lpop(listName));
        display(7,jedis.llen(listName));
        display(7,jedis.lrange(listName,0,9));
        display(8,jedis.lindex(listName,5));
        display(9,jedis.linsert(listName, BinaryClient.LIST_POSITION.BEFORE,"a4","before"));
        display(9,jedis.linsert(listName, BinaryClient.LIST_POSITION.AFTER,"a4","after"));
        display(10,jedis.lrange(listName,0,jedis.llen(listName)));

        //hash
        String userkey="userxxq";
        jedis.hset(userkey,"name","luziye");
        jedis.hset(userkey,"age","20");
        jedis.hset(userkey,"salary","3000");
        display(11,jedis.hget(userkey,"name"));
        display(12,jedis.hgetAll(userkey));
        display(13,jedis.hdel(userkey,"age"));
        display(14,jedis.hgetAll(userkey));
        display(15,jedis.hexists(userkey,"email"));
        display(16,jedis.hexists(userkey,"salary"));
        display(16,jedis.hkeys(userkey));
        display(17,jedis.hvals(userkey));
        jedis.hsetnx(userkey,"sex","male");
        jedis.hsetnx(userkey,"name","xulele");
        display(18,jedis.hgetAll(userkey));

        //set
        String likeKey1="like1";
        String likeKey2="like2";
        for (int i=0;i<10;i++){
            jedis.sadd(likeKey1,String.valueOf(i));
            jedis.sadd(likeKey2,String.valueOf(i*i));
        }
        display(19,jedis.smembers(likeKey1));
        display(20,jedis.smembers(likeKey2));
        display(21,jedis.sunion(likeKey1,likeKey2));
        display(22,jedis.sdiff(likeKey1,likeKey2));
        display(23,jedis.sinter(likeKey1,likeKey2));
        display(24,jedis.sismember(likeKey1,"9"));
        display(25,jedis.sismember(likeKey1,"100"));
        jedis.srem(likeKey1,"5");
        display(26,jedis.smembers(likeKey1));
        jedis.smove(likeKey2,likeKey1,"25");
        jedis.smove(likeKey2,likeKey1,"49");
        jedis.smove(likeKey2,likeKey1,"81");
        display(27,jedis.smembers(likeKey1));
        display(28,jedis.scard(likeKey1));

        String rankKey="rankKey";
        jedis.zadd(rankKey,20,"ben");
        jedis.zadd(rankKey,30,"alice");
        jedis.zadd(rankKey,45,"john");
        jedis.zadd(rankKey,10,"paul");
        jedis.zadd(rankKey,1,"dog");
        jedis.zadd(rankKey,3,"cat");
        jedis.zadd(rankKey,7,"sleep");
        display(29,jedis.zcard(rankKey));
        display(30,jedis.zcount(rankKey,10,30));
        display(31,jedis.zscore(rankKey,"alice"));
        jedis.zincrby(rankKey,2,"ben");
        display(32,jedis.zscore(rankKey,"ben"));
        display(33,jedis.zrange(rankKey,0,100));
        display(34,jedis.zrange(rankKey,0,10));
        display(35,jedis.zrange(rankKey,1,3));
        display(36,jedis.zrevrange(rankKey,1,3));
        for (Tuple tuple:jedis.zrangeByScoreWithScores(rankKey,10,100)){
            display(37,tuple.getElement()+":"+tuple.getScore());
        }
        display(38,jedis.zrank(rankKey,"dog"));
        display(39,jedis.zrevrank(rankKey,"dog"));


    }
}
