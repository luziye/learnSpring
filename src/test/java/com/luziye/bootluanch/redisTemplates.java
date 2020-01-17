package com.luziye.bootluanch;

import com.luziye.bootluanch.model.Address;
import com.luziye.bootluanch.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTemplates {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    @Test
    public void testValueObj() throws Exception{
        Person person = new Person("kobe","byrant");
        person.setAddress(new Address("shanghai","china"));
//        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        valueOperations.set("player:1",person,20, TimeUnit.SECONDS); //10秒之后数据消失

        Person getBack = (Person)valueOperations.get("player:1");
        System.out.println(getBack);
    }
    @Test
    public void testSetOperation() throws Exception{
        Person person = new Person("kobe","byrant");
        Person person2 = new Person("curry","stephen");
        Person person3 = new Person("lebron","james");
        Person person4 = new Person("michael","jordan");

        setOperations.add("playerset",person,person2,person3,person4);
        Set<Object> result = setOperations.members("playerset");
        System.out.println(result);
    }
    @Test
    public void HashOperations() throws Exception{
        Person person = new Person("boke","byrant");
        hashOperations.put("hash:player","firstname",person.getFirstname());
        hashOperations.put("hash:player","lastname",person.getLastname());
        hashOperations.put("hash:player","address",person.getAddress());
        System.out.println(hashOperations.get("hash:player","firstname"));
    }

    @Test
    public void  ListOperations() throws Exception{

        listOperations.leftPush("list:player",new Person("kobe","byrant"));
        listOperations.leftPush("list:player",new Person("Jordan","Mikel"));
        listOperations.leftPush("list:player",new Person("curry","stephen"));

        System.out.println(listOperations.leftPop("list:player"));
    }
}
