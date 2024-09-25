
package pa3;

/**
 * A queue of nodes.
 */
public class Queue {
    public Node[] arr;
    public int track;
    public int cap;
    /** 
     * Constructs an empty queue.
     */
    public Queue() {
        this.track = 0;
        this.cap = 10;
        this.arr = new Node[cap];
        
        
    }

    /**
     * Adds a node to the queue.
     * @param node
     */
        public void enqueue(Node value) 
        {
            if (track < cap)
            {
            this.arr[track] = value;
            track +=1;
            }
            else
            {
            cap += 5;
            Node[] history;
            history = this.arr;
            this.arr = new Node[cap];
            int i = 0;
            while(i <= track){
                this.arr[i] = history[i];
                i +=1 ;

            }
            this.arr[track] = value;
            }
        }
        
        
    

    /**
     * Removes and returns the node at the front of the queue.
     * @return the node at the front of the queue.
     */
    public Node dequeue() {
        Node removed = this.arr[0];
        int i = 0;
        while (i < track)
        {
            this.arr[i] = this.arr[i+1];
            i += 1;
        }
        track -=1;
        return removed;
        
    }

    /**
     * Returns true if the queue is empty.
     * @return true if the queue is empty.
     */
    public boolean isEmpty() {
        return track == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Node node1 = new Node(4);
        Node node2 = new Node(4);
        queue.enqueue(node1);
        queue.enqueue(node2);
        System.out.println(queue.dequeue().value); // Should print 4
    }
    
}

