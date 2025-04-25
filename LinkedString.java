public class LinkedString {
    private Node head;
    private int length;
    public LinkedString(char[] value) {
        for (char c : value) {
            append(c);
        }
    }
    public LinkedString(String original) {
        for (int i = 0; i < original.length(); i++) {
            append(original.charAt(i));
        }
    }public LinkedString() {
        this.head = null;
        this.length = 0;
    }
    public int length() {
        return length;
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }
    public LinkedString concat(LinkedString str) {
        LinkedString result = new LinkedString();
        Node curr = this.head;
        while (curr != null) {
            result.append(curr.value);
            curr = curr.next;
        }
        curr = str.head;
        while (curr != null) {
            result.append(curr.value);
            curr = curr.next;
        }
        return result;
    }
    public LinkedString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        LinkedString result = new LinkedString();
        Node curr = head;
        for (int i = 0; i < beginIndex; i++) {
            curr = curr.next;
        }
        for (int i = beginIndex; i < endIndex; i++) {
            result.append(curr.value);
            curr = curr.next;
        }
        return result;
    }
    private void append(char c) {
        Node n = new Node(c);
        if (head == null) {
            head = n;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = n;
        }
        length++;
    }
}