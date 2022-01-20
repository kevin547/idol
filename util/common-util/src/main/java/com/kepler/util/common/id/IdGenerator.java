package com.kepler.util.common.id;



/**
 * Id生成器接口
 *
 * @author 杨水美
 * @version 2019/11/28
 */
public interface IdGenerator {

    /**
     * 生成Id
     *
     * @param entity 实体
     * @return id
     */
    Number nextId(Object entity);

    /**
     * 生成Id {
     *
     * @param entity 实体
     * @return id
     */
    default String nextIdStr(Object entity) {
        return String.valueOf(nextId(entity));
    }

    /**
     * 获取uuid
     *
     * @param entity 实体
     * @return uuid
     */
    default String nextUUID(Object entity) {
        return IdWorker.getUUID_32();
    }
}
