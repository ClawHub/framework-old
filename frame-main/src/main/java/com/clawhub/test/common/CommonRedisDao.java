package com.clawhub.test.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;


/**
 * <Description> redis操作封装  <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
@Repository
public class CommonRedisDao {

    /**
     * 引入redisTemplate
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 一小时，秒级
     */
    public static final long ONE_HOUR = 60L * 60;

    /**
     * 6小时，秒级
     */
    public static final long SIX_HOUR = 60L * 60 * 6;

    /**
     * 一天，秒级
     */
    public static final long ONE_DAY = 60L * 60 * 24;

    /**
     * 7天，秒级
     */
    public static final long ONE_WEEK = 60L * 60 * 24 * 7;

    /**
     * 30天，秒级
     */
    public static final long ONE_MONTH = 60L * 60 * 24 * 30;

    /**
     * Description: 批量删除<br>
     * （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删）
     *
     * @param pattern redis的key<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void batchDel(String... pattern) {
        for (String kp : pattern) {
            redisTemplate.delete(redisTemplate.keys(kp + "*"));
        }
    }

    /**
     * Description: 给key设置超时时间<br>
     *
     * @param key        <br>
     * @param expireTime <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void setExpire(String key, long expireTime) {
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    /**
     * Description: redis原子性自增操作<br>
     *
     * @param key   key
     * @param delta 每次自增量
     * @return 增加后的值<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * Description: redis set操作<br>
     *
     * @param key   key
     * @param value value<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * Description: redis set操作, 同时设置超时时间<br>
     * Set the {@code value} and expiration {@code expireTime} for {@code key}.<br>
     *
     * @param key        key
     * @param value      value<br>
     * @param expireTime 超时时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void setValueWithExpire(String key, String value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * Description: redis get操作<br>
     *
     * @param key key
     * @return <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * Description: redis del操作<br>
     *
     * @param key <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Description: 判断redis中是否包含key<br>
     *
     * @param key key
     * @return <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * Description: 判断value值存不存在于key对应的set中<br>
     *
     * @param key   key
     * @param value value
     * @return <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public boolean isValueExistInSet(String key, String value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * Description: 向key对应的set中增加指定的值<br>
     *
     * @param key    key
     * @param values 要添加的值<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void addValueToSet(String key, String[] values) {
        redisTemplate.opsForSet().add(key, values);
    }

    /**
     * Description: 删除key对应的set中指定的值<br>
     *
     * @param key   key
     * @param value 要删除的值<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void removeValueInSet(String key, String value) {
        redisTemplate.opsForSet().remove(key, value);
    }

    /**
     * Description: 从左侧向redis的list中推数据<br>
     *
     * @param key    <br>
     * @param values <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public void leftPushToList(String key, String... values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * Description: 从右侧拉取redis的list中的数据<br>
     *
     * @param key <br>
     * @return <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public String rightPopFromList(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }
}
