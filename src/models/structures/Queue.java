package models.structures;

public class Queue<T> extends List<T>{

    public void add(Node <T> actual){
        addElement(actual);
    }

    public Node <T> poll() throws NotFoundException {
        return getFirstAndDelete();
    }

    public Node <T> peek(){
        return getFirst();
    }
    
    public int getSize() {
    	return getSize();
    }
}
