package com.kepler.util.common.id;

import com.jjsj.util.common.Constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 高效GUID产生算法(sequence),基于Snowflake实现64位自增ID算法。
 *
 * @author 杨水美
 * @version 2019/11/28
 */
public class IdWorker {

    /**
     * 毫秒格式化时间
     */
    public static final DateTimeFormatter MILLISECOND = DateTimeFormatter
        .ofPattern("yyyyMMddHHmmssSSS");
    /**
     * 主机和进程的机器码 3.2.1
     */
    private static IdGenerator ID_GENERATOR;

    /**
     * 获取唯一ID
     *
     * @return id spring应用可以通过@IdGenerator,非spring应用请自行控制IdGenerator的实例化
     */
    public static Long getId() {
        return Long.parseLong(ID_GENERATOR.nextId(new Object()).toString());
    }

    /**
     * 获取唯一ID
     *
     * @return id spring应用可以通过@IdGenerator,非spring应用请自行控制IdGenerator的实例化
     */
    public static String getIdStr() {
        return String.valueOf(ID_GENERATOR.nextId(new Object()));
    }

    /**
     * 格式化的毫秒时间
     */
    public static String getMillisecond() {
        return LocalDateTime.now().format(MILLISECOND);
    }

    /**
     * 时间 ID = Time + ID
     * <p>例如：可用于商品订单 ID</p>
     * spring应用可以通过@IdGenerator,非spring应用请自行控制IdGenerator的实例化
     */
    public static String getTimeId() {
        return getMillisecond() + getId();
    }

    /**
     * 有参构造器
     *
     * @param workerId 工作机器 ID
     * @param dataCenterId 序列号
     */
    public static void initSequence(long workerId, long dataCenterId) {
        ID_GENERATOR = new DefaultGenerator(workerId, dataCenterId);
    }

    /**
     * 自定义id 生成方式
     *
     * @param idGenerator id 生成器
     */
    public static void setIdGenerator(IdGenerator idGenerator) {
        ID_GENERATOR = idGenerator;
    }

    /**
     * 使用ThreadLocalRandom获取UUID获取更优的效果 去掉"-"
     */
    public static String getUUID_32() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString()
            .replace(Constant.DASH, Constant.EMPTY);
    }

}
