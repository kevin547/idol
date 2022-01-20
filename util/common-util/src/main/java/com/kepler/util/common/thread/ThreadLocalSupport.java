package com.kepler.util.common.thread;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * <p>线程工具类</p>
 *
 * @author 杨水美
 * @version 2019-05-31
 */
public interface ThreadLocalSupport {

    ThreadLocal<Map<String, Object>> MAP_THREAD_LOCAL = ThreadLocal
        .withInitial(Maps::newHashMap);

    ThreadLocal<Object> THREAD_LOCAL = ThreadLocal.withInitial(() -> null);

}
