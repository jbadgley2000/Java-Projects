public class Node<U> {
    U value;
    Node<U> next;
    public Node(){
        value = null;
        next = null;
    }
    public Node(U value){
        this.value = value;
        this.next = null;
    }
    public String toString(){
        return value+"";
    }
}
