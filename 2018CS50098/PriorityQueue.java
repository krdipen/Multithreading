
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private NodeBase<V> tempo;
    private int capacity, currentSize, front, rear;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.currentSize=0;
        queue = new NodeBase[this.capacity];
        front=0;
        rear=0;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        if(currentSize==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
	
    public boolean isFull() {
        if(currentSize==capacity)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void add(int p, V s) {
        Node<V> node=new Node<V>(p,s);
        enqueue(node);
        }

    public void enqueue(NodeBase<V> node)  {

            if(this.isFull())
            {
                return;
                }
            queue[rear]=node;
            rear=((rear+1)%(this.capacity));
            currentSize=currentSize+1;
            for(int i=0;i<currentSize-1;i++)
            {
                for(int j=i+1;j<currentSize;j++)
                {
                    if(queue[(front+i)%(this.capacity)].getPriority()>queue[(front+j)%(this.capacity)].getPriority())
                    {
                        tempo=queue[(front+i)%(this.capacity)];
                        queue[(front+i)%(this.capacity)]=queue[(front+j)%(this.capacity)];
                        queue[(front+j)%(this.capacity)]=tempo;
                    }
                }
            }

    }

    public NodeBase<V> removeMin(){
        return dequeue();
        }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        if(this.isEmpty())
        {return null;
            }
            tempo = queue[front];
            front = ((front+1)%(this.capacity));
            currentSize=currentSize-1;
            return tempo;
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[(front+i)%(this.capacity)].show();
	}
    }
}

