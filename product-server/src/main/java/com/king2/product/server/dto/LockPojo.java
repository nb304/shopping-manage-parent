package com.king2.product.server.dto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁的POJO
 */
public class LockPojo {
    private ReentrantLock lock;
    private Condition condition;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
        this.condition = this.lock.newCondition();
    }

    public Condition getCondition() {
        return condition;
    }

}
