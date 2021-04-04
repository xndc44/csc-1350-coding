import java.util.ArrayList;
import java.util.function.Function;

public class bstOrderedList extends OrderedList{
	private int sizer;
	
	class Node { 
		public Node leftChild;    
		public Comparable data;   
		public Node rightChild; 
	}
	private Node root;

	bstOrderedList () {
		
		root = null;
	}
	public void add(Comparable newObject) {
        if (isEmpty()) {
            root = new Node();
            root.data = newObject;
        }
        else
        {
            Addpoint(root, newObject);
        }
    }//insertion
	
	private Node Addpoint(Node root, Comparable data)
    {
        if (root == null) {
            root = new Node();
            root.data = data;
        }
        else
        {
            int dataC = data.compareTo(root.data);
            if (dataC < 0) {
                root.leftChild = Addpoint(root.leftChild, data);
            }
            else if (dataC > 0) {
                root.rightChild = Addpoint(root.rightChild, data);
            }
        }
        return root;
    }
	
	public void remove(Comparable object) {
        root = remove(root, object);
    }//remove
	
	private Node remove(Node root, Comparable data) {
        if (root == null) return root;

        int dataC = data.compareTo(root.data);
        if (dataC < 0) {
            root.leftChild = remove(root.leftChild, data);
        } else if (dataC > 0) {
            root.rightChild = remove(root.rightChild, data);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            root.data = minValue(root.rightChild);
            root.rightChild = remove(root.rightChild, root.data);
        }

        return root;
    }
	
	private Comparable minValue(Node root) {
	        Comparable minV = root.data;

	        while(root.leftChild != null) {
	            minV = root.leftChild.data;
	            root = root.leftChild;
	        }
	        return minV;
	}//minValue
	
    public int size() {
        sizer = 0;
        recursive(root, x -> sizer++);
        return sizer;
    }


    public boolean isEmpty() {
        return root == null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        recursive(root, x -> builder.append(String.format("[%s;]", x.toString())));
        return builder.toString();
    }

 
    public Comparable[] toArray(String sorting) {
        ArrayList<Comparable> list = new ArrayList<>();
        if (sorting.equals("Inorder")) {
            recursive(root, x -> list.add(x));
        } else if (sorting.equals("Postorder")) {
            afterrec(root, x -> list.add(x));
        } else if (sorting.equals("Preorder")) {
            prerec(root, x -> list.add(x));
        }
        Comparable[] out = new Comparable[list.size()];
        return list.toArray(out);
    }

   
    private void recursive(Node root, Function<Comparable, Object> function) {
        if (root != null) {
            recursive(root.leftChild, function);
            function.apply(root.data);
            recursive(root.rightChild, function);
        }
    }

    private void prerec(Node root, Function<Comparable, Object> function) {
        if (root != null) {
            function.apply(root.data);
            prerec(root.leftChild, function);
            prerec(root.rightChild, function);
        }
    }

    private void afterrec(Node root, Function<Comparable, Object> function) {
        if (root != null) {
            afterrec(root.leftChild, function);
            afterrec(root.rightChild, function);
            function.apply(root.data);
        }
    }
}
