package com.king2.commons.lock;

/**
 * Redis分布式锁接口
 */
public interface Lock {

    /**
     * 线程阻塞的加锁
     */
    void lock();

    /**
     * 尝试加锁 加锁失败就跳出
     * @return
     */
    boolean tryLock();

    /**
     * 解锁
     * @return
     */
    boolean unlock(String luaPath) throws Exception;
}
