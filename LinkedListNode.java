public class LinkedListNode<T> {
    private Shape data;
    private LinkedListNode next;

    public LinkedListNode(Shape nodeData ) {
        this( nodeData, null);
    }

    public LinkedListNode(Shape nodeData, LinkedListNode nodeNext ) {
        data = nodeData;
        next = nodeNext;
    }
    public Shape getData() {
        return data;
    }
    public LinkedListNode getNext() {
        return next;
    }
    public void setData( Shape newData ) {
        data = newData;
    }
    public void setNext( LinkedListNode newNext ) {
        next = newNext;
    }
}