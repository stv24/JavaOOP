package ru.JavaOOP.stv.MyList;

public class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data){
        this.data = data;
    }

    public Node(){

    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData(){
        if (data == null) {
            throw new NullPointerException("нет данных");
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext(){
        return  next;
    }

    public void setNext(Node<T> next){
        this.next  = next;
    }
}
