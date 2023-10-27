import java.util.ArrayList;

class ShapeStack<T> {
    private int numNodes = 0;
    private LinkedListNode<Shape> head = null;

    public boolean isEmpty() {
        return (head == null);
    }

    public void removeAll() {
        head = null;
        numNodes = 0;
    }
    public int size() {
        return numNodes;
    }
    public void addHead(Shape element ) {
        head = new LinkedListNode<Shape>(element, head);
        numNodes++;
    }

    public Shape peek() {
        if (isEmpty())
            return null;
        return head.getData();
    }
    @SuppressWarnings("unchecked")
    public Shape removehead() {
        Shape tempData;
        if (isEmpty())
            return null;
        tempData = head.getData();
        head = head.getNext();
        numNodes--;
        return tempData;
    }

    public void removeEnd(Shape element) {
        LinkedListNode<Shape> node= head;
        while(node.getNext() != null)
        { node = node.getNext();
        }
        node.setNext(new LinkedListNode<Shape>((Shape)element, null));
    }


    public ArrayList<Shape> toArray() {
        ArrayList<Shape> shapesArr=new ArrayList<Shape>();
        LinkedListNode<Shape> node= head;
        while (node!=null)
        {
            shapesArr.add(node.getData());
            node = node.getNext();
        }
        return shapesArr;
    }

}
