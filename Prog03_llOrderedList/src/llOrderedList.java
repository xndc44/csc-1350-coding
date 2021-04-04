
public class llOrderedList extends OrderedList {

    private class Node {
        public Comparable data;
        public Node next;
    }

    private int numObjects;

    private Node first;
    private Node prev;
    private Node prev2;
    private Node curr;

    
    public llOrderedList() {
        first = null;
        prev = null;
        prev2 = null;
        curr = null;
    }

    
    public void add(Comparable newObject) {
        Node newNode = new Node();
        newNode.data = newObject;

        if (size() == 0) {
            first = newNode;
            curr = newNode;
        }
        else
        {
        	int counter = 0;
            Node previous = null;
            reset();
            while (counter < size()) {
            	if (curr.data.compareTo(newObject) > 0) {
                    Node tmp = curr;
                    newNode.next = curr.next;
                    if (previous != null) {
                        previous.next = newNode;
                    } else {
                        first = newNode;
                    }
                    curr = newNode;
                    newNode = tmp;
                }
                previous = curr;
                next();
                counter++;
            }
        	if (curr == null) {
        		prev.next = newNode;
        		curr = newNode;
        	}
        }
        numObjects++;
    }

    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (size() > 0) {
            for(int i = 0; i < size(); i++) {
                stringBuilder.append(String.format("[%s]%n", next().toString()));
            }
        }

        return stringBuilder.toString();
    }

    
    public int size() {
        return numObjects;
    }

   
    public boolean isEmpty() {
        return numObjects == 0;
    }


    public void reset()
    {
        curr = first;
        prev2 = null;
        prev = null;
    }

    
    public Comparable next() {
        Comparable item = curr.data;
        if (curr != first) {
        	prev2 = prev;
        }
        prev = curr;
        curr = curr.next;
        return item;
    }

   
    public boolean hasNext() { 
    	return curr != null && curr.next != null; 
    }


    public void remove() {
    	if (prev2 != null)
    		prev2.next = curr;
    	else
    		first = curr;
    	numObjects--;
    }
}
