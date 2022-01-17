package com.averkina;

import com.averkina.family04.Cricetidae;
import com.averkina.genus05.Phodopus;
import com.averkina.species06.PhodopusRoborovskii;
import com.averkina.species06.PhodopusSungorus;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {
    private final java.util.Queue<T> list;
    private final int length;

    public Queue(int length) {
        this.list = new LinkedList<>();
        this.length = length;
    }

    public int maxSize() {
        return length;
    }
    public int size() {
        return list.size();
    }

    public void add(T t) {
        try {
            if (list.size() <= length) {
                list.add(t);
            } else {
                throw new QueueException();
            }
        } catch (QueueException e) {
            System.out.printf(e.toString());
        }
    }

    public T get() {
        return list.poll();
    }

    public T peek() {
        return list.peek();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
