public class Node {
    char value;
    Node next;
    public Node(){
        value = 0;
        next = null;
    }
    public Node(char value){
        this.value = value;
        this.next = null;
    }
    public String toString(){
        return value+"";
    }
}
