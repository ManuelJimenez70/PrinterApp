package models.structures;

public abstract class List<T> {

    private Node<T> first;

    protected void addElement(Node<T> node){
        if(first == null){
            first = node;
            return;
        }
        Node<T> actual = first;
        while(actual.getNext() != null){
            actual = actual.getNext();
        }
        actual.setNext(node);
    }

    protected void addAtStart(Node<T> node){
        node.setNext(first);
        first = node;
    }

    protected void addNextTo(T baseName, Node<T> node) throws NotFoundException {
        Node<T> base = search(baseName);
        node.setNext(base.getNext());
        base.setNext(node);
    }

    public Node<T> search(T name) throws NotFoundException {
        Node<T> actual = first;
        while(actual != null){
            if(actual.getData().equals(name)){
                return actual;
            }
            actual = actual.getNext();
        }
        throw new NotFoundException();
    }

    protected void delete(T name) throws NotFoundException {
        if(first.getData().equals(name)){
            first = first.getNext();
        }else{
            Node<T> base = searchPrevious(name);
            base.setNext(base.getNext().getNext());
        }
    }

    private Node<T> searchPrevious(T name) throws NotFoundException {
        Node<T> actual = first;
        while(actual.getNext() != null){
            if(actual.getNext().getData().equals(name)){
                return actual;
            }
            actual = actual.getNext();
        }
        throw new NotFoundException();
    }

    public int getSize(){
        int count = 0;
        Node<T> actual = first;
        while(actual != null){
            actual = actual.getNext();
            count++;
        }
        return count;
    }

    protected Node<T> getFirst(){
        return first;
    }

    protected Node<T> getFirstAndDelete() throws NotFoundException {
        if(isEmpty()){
            throw new NotFoundException();
        }
        Node<T> result = first;
        delete(first.getData());
        return result;
    }

    protected Node<T> getLastAndDelete() throws NotFoundException {
        Node<T> actual = first;
        while(actual.getNext() != null){
            actual = actual.getNext();
        }
        delete(actual.getData());
        return actual;
    }

    public boolean isEmpty(){
        return getFirst() == null;
    }
}
