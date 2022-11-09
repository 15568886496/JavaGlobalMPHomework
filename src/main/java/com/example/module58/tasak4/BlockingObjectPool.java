package com.example.module58.tasak4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
* Pool that block when it has not any items or it full

*/
public class BlockingObjectPool {

    private ArrayList list;

    private Integer MAX_COUNT = 100000;

    private int CURRENT_COUNT = 0;

    /**
    * Creates filled pool of passed size
    *
    * @param size of pool
    */
    public BlockingObjectPool(int size) {
        //...
        list = new ArrayList<>(MAX_COUNT);
    }

    /**
    * Gets object from pool or blocks if pool is empty
    *
    * @return object from pool
    */
    public synchronized Object get(Integer index) {
        if(list.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            return list.get(index);
        }
        return null;
    }

    /**
    * Puts object to pool or blocks if pool is full
    *
    * @param object to be taken back to pool
    */
    public synchronized void take(Object object) throws InterruptedException {
        //...
        if(CURRENT_COUNT>MAX_COUNT){
            wait();
        }else{
            CURRENT_COUNT++;
            notifyAll();
        }
    }
}
