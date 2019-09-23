
public class SimpleLinkedList<E> {

    // Static nested Class
    /*<listing chapter="2" number="1">*/
    /**
     * A Node is the building block for the SingleLinkedList
     */
    private static class Node<E> {

        //Data Fields
        /**
         * The reference to the data.
         */
        private E data;
        /**
         * The reference to the next node
         */
        private Node<E> next = null;

        //Constructors
        /**
         * Creates a new node with a null next field
         *
         * @param dataItem - The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Create a new node that references another node
         *
         * @param dataItem - The data stored
         * @param nodeRef - The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }

    }
    /*</listing>*/

    // Data fields
    /**
     * A reference to the first node in the list
     */
    private Node<E> head = null;
    /**
     * The number of items in the list
     */
    private int size = 0;

    //demo: how to connect nodes directly inside class SingleLinkedList<E>.
    public static void main(String[] args) {
        //create 4 Node<String> objects with given data values
        //Have 4 reference variables pointing to them respectively
        Node<String> tom = new Node<String>("Tom");
        Node<String> dick = new Node<String>("Dick");
        Node<String> harry = new Node<String>("Harry");
        Node<String> sam = new Node<String>("Sam");

        //connect Node<String> objects direcctly
        tom.next = dick;
        dick.next = harry;
        harry.next = sam;
        System.out.println("----------------");

        //connect Node<Integer> objects directly
        //Run these lines and check the list yourself.
        Node<Integer> number1 = new Node<Integer>(10);
        Node<Integer> number2 = new Node<Integer>(20);
        number1.next = number2;

    }

    /**
     * Add an item to the front of the list.
     *
     * @param item The item to be added
     */
    public void addFirst(E item) {
        //create a new Node (data: item, next: pointing to current first node)
        //make head point to this new Node
        head = new Node<E>(item, head);
        size++;
    }

    // Helper Methods
    /**
     * Add a node after a given node in the parameter
     *
     * @param node The given node preceding the new item
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item) {
        //The given node: the node referenced by the parameter: node.
        //create a new Node (data: item, next: pointing to the given node's current immediately following neighbor)
        // and make the given node's next data field point to this new Node        
        node.next = new Node<E>(item, node.next);
        size++;
    }

    /**
     * Remove the first node from the list
     *
     * @returns The removed node's data or null if the list is empty
     */
    private E removeFirst() {
        Node<E> temp = head;    //save the reference to the first node in the linked list
        if (head != null) {     //this list is not empty.
            head = head.next;   //make head point to the 2nd node in this list
        }
        //return data at old head or null if this list is empty
        if (temp != null) {     //if this list is not empty
            size--;
            return temp.data;   //return the data in the old first node
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     *
     * @param node The node before the one to be removed. (Assume node is not
     * null).
     * @returns The data from the removed node, or null if there is no node to
     * remove
     */
    private E removeAfter(Node<E> node) { //Given node: the node referenced by the parameter: node
        Node<E> temp = node.next;         //save the reference to the given node's current immediately following neighbor
        if (temp != null) {               //if given node is not last node on this linked list
            node.next = temp.next;        //make the given node's data field: next point to its 2nd following neighbor
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    //end lec 7 here
    /**
     * Get the node at a specified position (i.e. index)
     *
     * @param index The position (i.e. index) of the node sought
     * @returns The node at index or null if it does not exist
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;                //make the first node the current node to check
        for (int i = 0; //initialize counter i to first position at index 0
                i < index && node != null; //if counter i has not reached target position: index, and there are still nodes to check.
                i++) {                      //increase counter i
            node = node.next;               //move on to the next node in this linked list
        }
        return node;
    }

    // Public Methods
    /**
     * Get the data item at a specific position (i.e. index)
     *
     * @param index The position(i.e. index) of the data item to return
     * @returns The data item at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {       //invalid index
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);          //call private method getNode(..) to get the desired node
        return node.data;
    }

    /**
     * Change the data item at the given position (index). Store a reference to
     * an Entry in the element at given position (index)
     *
     * @param index The position(index) of the item to change
     * @param newValue The new value
     * @returns The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {   //invalid index
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);      //call private method getNode(..) to get the desired node
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * Insert the specified item at index. Insert the given item at the given
     * position in the list. If insertion is successful, the indices of any
     * subsequent elements will be increased by 1. 1).
     *
     * @param index The position where the given item is to be inserted
     * @param item The given item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {        //invalid index
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {                       //Given position: index is first position
            addFirst(item);                     //call public method: addFirst(....) to do the insertion
        } else {
            //call private getNode(...) to get the node immediately before the node at the given position
            Node<E> node = getNode(index - 1);
            //call addAfter(..) to add the item after the node returned by getNode(..)
            addAfter(node, item);
        }
    }

    /**
     * Append the given item to the end of the list
     *
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        //call add(int index, E item) to complete the task, passing this list's size as target position
        add(size, item);
        return true;
    }

    /**
     * Obtain a string representation of the list
     *
     * @return A String representation of the list
     */
    @Override
    public String toString() {
        //Create a StringBuilding object, storing the resulting string value
        StringBuilder sb = new StringBuilder("[");
        //p: current node reference
        //make p point to first node on this linked list
        Node<E> p = head;
        if (p != null) {            //if haven't checked all nodes on this linked list
            while (p.next != null) {    //if current NODE<E> is not the last Node<E> on this linked list
                sb.append(p.data.toString());   //append the current Node<E>'s data value String to the result string
                sb.append(" ==> ");
                p = p.next;             //move on the next Node<E> on this linked list
            }
            sb.append(p.data.toString());   //append the last Node<E>'s data value string
        }
        sb.append("]");
        return sb.toString();           //place the result string into a String object, return the String object
    }

    //Following are section exercises to be completed by you.

    // count each node and and return count
    public int size() {
        int s = 0;

        Node<E> nextNode = this.head;
        while (nextNode != null) {
            nextNode = nextNode.next;
            s++;
        }

        return s;
    }

    // traverse LinkedList, keep track of current index, find item
    public int indexOf(E item) {
        int index = -1;
        Node<E> nextNode = this.head;
        while (nextNode != null) {
            index++;
            if (nextNode.data.equals(item))
                return index;

            nextNode = nextNode.next;
        }
        return -1; // not found
    }

    // remove the element at index index
    public E remove(int index) {
        E e =  null;
        int c = 0;
        Node<E> currNode = this.head.next;
        Node<E> prevNode = this.head;

        if (index == c) { // if index is 0
            e = head.data;
            this.head = head.next;
            return e;
        }

        while (currNode != null) {
            if (++c == index)  {
                e = currNode.data;
                prevNode.next = currNode.next;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }

        return e;
    }

    // keep track of current and previous node
    // if current node should be deleted, set previous node to point at next node
    // let garbage collector deal with the node
    public boolean remove(E item) {

        Node<E> currNode = this.head;
        Node<E> prevNode = this.head;
        while (currNode != null) {
            if (this.head.data.equals(item)) // in case we remove the first element
                this.head = head.next;

            if (currNode.data.equals(item)) {
                prevNode.next = currNode.next;

                return true;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }

    public void add2(int index, E item) {

        Node<E> currNode = this.head.next;
        Node<E> prevNode = this.head;
        Node<E> tmp;

        if (index == 0) {
            this.head.next = new Node<E>(item);
        }

        while (currNode != null && index-- > 0) {
            currNode = currNode.next;
        }

        if (index == 0) {
            tmp = currNode;
            prevNode.next = new Node<>(item);
            prevNode.next.next = tmp;
        } else {
            System.out.println("Index out of bounds!");
        }
    }
}
/*</listing>*/
