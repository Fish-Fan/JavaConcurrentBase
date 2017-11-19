package com.connectionPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by yanfeng-mac on 2017/11/5.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        for(int i = 0;i < initialSize;i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public void releaseConnection(Connection connection) {
        if(connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if(mills <= 0) {
                //万分紧急的线程优先通过，但本例中if段代码永远得不到执行，因为mills都是1000
                while (pool.isEmpty()) {
                    pool.wait();
                }

                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait();
                    remaining = future - System.currentTimeMillis();
                }

                Connection result = null;
                if(!pool.isEmpty()) {
                    result = pool.removeFirst();
                }

                return result;
            }
        }
    }
}
