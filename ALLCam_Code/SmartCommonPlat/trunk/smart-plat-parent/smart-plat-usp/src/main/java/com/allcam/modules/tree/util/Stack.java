package com.allcam.modules.tree.util;

import java.util.LinkedList;

public class Stack<T>
{
    private LinkedList<T> list = new LinkedList<T>();
    
    public void push(T t)
    {
        list.addFirst(t);
    }
    
    public T top()
    {
        return list.getFirst();
    }
    
    public T pop()
    {
        return list.removeFirst();
    }
    
    public LinkedList<T> getAll()
    {
        return list;
    }
    
    public String toString()
    {
        return list.toString();
    }
    
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
