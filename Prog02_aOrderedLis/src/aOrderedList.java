import java.util.Arrays;

/**
 *
 * CSC 1351 Programming Project No 2
 * Section 03
 *
 * @author Patrick Adeosun
 * @since 4/9/2019
 */
public class aOrderedList extends OrderedList{

    final int arraySize = 20;   

    private Comparable[] ListStore;          
    private int listSize;          
    private int numObjects;        

    private int curr;
    
    
    public aOrderedList() {
        numObjects = 0;
        listSize = arraySize;
        ListStore = new Comparable[arraySize];
    }//orderedlist

    public void add(Comparable newObject) {

        if (numObjects >= listSize) {
            ListStore = Arrays.copyOf(ListStore, ListStore.length + arraySize);
        }//if

        if (isEmpty())
        {
            ListStore[0] = newObject;
        }//if
        else {
            for (int i = 0; i < numObjects + 1; i++) {
                if (ListStore[i] == null) {
                    ListStore[i] = newObject;
                }//if
                else {
                    int result = ListStore[i].compareTo(newObject);
                    if (result > 0) {
                        Comparable nextObject = newObject;
                        for (int j = i; j <= numObjects; j++) {
                            Comparable tmp = ListStore[j];
                            ListStore[j] = nextObject;
                            nextObject = tmp;
                        }
                        break;
                    }//if
                }//else
            }//for
        }//else


        numObjects++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (numObjects > 0) {
            for (int i = 1; i < numObjects; i++) {
                stringBuilder.append(String.format("[%s]%n", ListStore[i].toString()));
            }//for
        }//if

        return stringBuilder.toString();
    }//toString

    public int size() {
        return numObjects;
    }//size

   
    public Comparable get(int index) {
        return ListStore[index];
    }//get

   
    public boolean isEmpty() {
        return numObjects == 0;
    }//isEmpty

    
    public void remove(int index) {
        for (int i = index; i <= numObjects; i++) {
            ListStore[i] = ListStore[i + 1];
        }//for
        numObjects--;
    }//remove

   
    public void reset() { 
    	curr = 0; 
    }//reset

    
    public Comparable next() {
        Comparable item = ListStore[curr + 1];
        curr++;
        return item;
    }//comparable

   
    public boolean hasNext() { 
    	return ListStore[curr + 1] != null; }

   
    public void remove() {
        reset();
        while(hasNext()) {
            next();
        }//while
        ListStore[curr] = null;
        reset();
    }//remove
}
