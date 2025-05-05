public class LinkBasedStack<T> implements StackInterface<T> {
    //head can be called top as well
    Node<T> top;
    int numOfItems;
    public LinkBasedStack(){
        top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int size(){
        return numOfItems;
    }
    public void push(T item){  //adds item to stack even if empty
        Node<T> n = new Node<>(item);
        n.next = top;
        top = n;
        numOfItems++;
    }
    public T pop() throws StackException{  //removes item from stack
        if(isEmpty())
            throw new StackException("Stack is empty");
        else {
            T temp = top.value;
            top = top.next;
            numOfItems--;
            return temp;
        }
    }
    public T peek() throws StackException{  //looks at the value of the top of the stack
        if(isEmpty())
            throw new StackException("Stack is empty");
        else {
            return top.value;
        }
    }
}