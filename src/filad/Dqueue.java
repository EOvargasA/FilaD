/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filad;

/**
 *
 * @author Osiris
 */
public class Dqueue <T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    Dqueue(){
        front = rear = null;
        size = 0;
    }
    
    Dqueue(T d){
        Node <T> n = new Node<T> (d);
        front = rear = n;
        size = 1;
    }
    
    public void enqueueFront (T d){
        Node <T> n = new Node<T> (d);
        if (isEmpty()){
            front = rear = n;
        } else {
            n.back = front;
            front.next = n;
            front = n;
        }
        size++;
    }
    
    public void enqueueLast (T d){
        Node <T> n = new Node<T> (d);
        if (isEmpty()){
            front = rear = n;
        } else {
            n.next = rear;
            rear.back = n;
            rear = n;
        }
        size++;
    }
    
    public T dequeueFront (){
        if(!isEmpty()){
            Node<T> n = front;
            if (size == 1){
                clearQueue();
            } else {
                front.back = front;
                front.next = null;
                size--;
            }
            return n.data;
        }
        return null;
    }
    
    public T dequeueRear (){
        if(!isEmpty()){
            Node<T> n = rear;
            if(size == 1){
                clearQueue();
            }else{
                rear.next = rear;
                rear.back = null;
                size--;
            }
            return n.data;
        }
        return null;
    }
    
    public T getFront(){
        return front.data;
    }
    
    public T getRear (){
        return rear.data;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clearQueue(){
        front = rear = null;
        size = 0;
    }
    
    public void showQueue() {
        Node<T> pointer = front;
        for (int i = 0; i < size; i++){
            System.out.print("["+pointer.data.toString()+"]");
            if (pointer.next != null){
                System.out.println("<->");
            }
            pointer = pointer.next;
        }
    }
}
