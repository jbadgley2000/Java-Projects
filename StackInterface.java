public interface StackInterface<T> {
    public boolean isEmpty();
    public int size();
    public void push(T item); //should throw exception for an array based stack
    public T pop() throws StackException;
    public T peek() throws StackException;
}
