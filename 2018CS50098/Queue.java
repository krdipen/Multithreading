// This class implements the Queue

public class Queue<V> implements QueueInterface<V>    {

    //TODO Complete the Queue implementation

    private NodeBase<V>[] queue;
    private NodeBase<V> tempo;
    private int capacity, currentSize, front, rear;
	
    @SuppressWarnings("unchecked")
    public Queue(int capacity)  {
        this.capacity = capacity;
        this.currentSize=0;
        queue = new NodeBase[this.capacity];
        this.front=0;
        this.rear=0;
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

    public void enqueue(NodeBase<V> node)  {

        if(this.isFull())
        {return;
            }
            queue[rear]=node;
            rear = ((rear+1)%(this.capacity));
            currentSize=currentSize+1;

    }

    public NodeBase<V> dequeue() {

        if(this.isEmpty())
        {return null;
            }

            tempo = queue[front];
            front = ((front+1)%(this.capacity));
            currentSize=currentSize-1;
            return tempo;
    }

}

