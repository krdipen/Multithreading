import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
    //extra
    private int catalogSize; //capacity
    //over

    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...

        this.catalog=catalog;
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        setSleepTime(sleepTime);
        this.inventory=inventory;
        this.catalogSize=catalogSize;

        //WORK DONE
    }
    
    public void sell() throws InterruptedException {

        //extra
        lock.lock();  //locked
        //over


            try {

                //TODO Complete the try block for produce method
                // ...


                while(catalog.size()==catalogSize)
                {
                    full.await();
                }

            if(inventory.isEmpty()!=true)
            {

                NodeBase<V> aitem;
                aitem=inventory.dequeue();
                catalog.enqueue(aitem);
                empty.signalAll();

                }

                //WORK DONE
            } catch(Exception e) {
                e.printStackTrace();
            }finally {
            //TODO Complete this block
            lock.unlock();
            //WORK DONE
            }

    }
}
