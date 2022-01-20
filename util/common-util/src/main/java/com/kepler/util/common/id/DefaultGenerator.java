package com.kepler.util.common.id;



/**
 * 默认ID生成器
 *
 * @author 杨水美
 * @version 2019/11/28
 */
public class DefaultGenerator implements IdGenerator {

    private final Sequence sequence;

    public DefaultGenerator() {
        this.sequence = new Sequence();
    }

    public DefaultGenerator(long workerId, long dataCenterId) {
        this.sequence = new Sequence(workerId, dataCenterId);
    }

    public DefaultGenerator(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public Long nextId(Object entity) {
        return sequence.nextId();
    }
}
