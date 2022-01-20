package com.kepler.util.common.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * <p>线程工具类</p>
 *
 * @author 杨水美
 * @version 2019-05-31
 */
public class ThreadUtil implements ThreadLocalSupport {

    private static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder()
        .setNameFormat("ThreadUtil-ThreadPool-%d").build();

    public static ExecutorService executor = new ThreadPoolExecutor(10, 10,
        60L, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(1024), THREAD_FACTORY, new ThreadPoolExecutor.AbortPolicy());

    public static ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(1,
        THREAD_FACTORY);
}
