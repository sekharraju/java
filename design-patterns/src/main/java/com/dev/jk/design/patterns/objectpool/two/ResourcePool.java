package com.dev.jk.design.patterns.objectpool.two;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public abstract class ResourcePool<T> {

    private long objectLifeTime;

    private Hashtable<T, Long> leased, unLeased;

    public ResourcePool() {
        objectLifeTime = TimeUnit.MINUTES.toMillis(5);
        leased = new Hashtable<>();
        unLeased = new Hashtable<>();
    }

    abstract T create();

    abstract boolean validate(T o);

    abstract void expireIt(T o);

    public synchronized T leaseResource() {
        long now = System.currentTimeMillis();
        T t;
        if (unLeased.size() > 0) {
            Enumeration<T> e = unLeased.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unLeased.get(t)) > objectLifeTime) {
                    unLeased.remove(t);
                    expireIt(t);
                } else {
                    if (validate(t)) {
                        unLeased.remove(t);
                        leased.put(t, now);
                        return (t);
                    } else {
                        unLeased.remove(t);
                        expireIt(t);
                    }
                }
            }
        }
        t = create();
        leased.put(t, now);
        return (t);
    }

    public synchronized void requiteResource(T t) {
        leased.remove(t);
        unLeased.put(t, System.currentTimeMillis());
    }
}

