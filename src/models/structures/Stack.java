package models.structures;

public class Stack<T> extends List<T>{

    public void push(Node <T> actual){
        addAtStart(actual);
    }

    public Node <T> pop() throws NotFoundException {
        return getFirstAndDelete();
    }

    public Node <T> peek(){
        return getFirst();
    }
}
