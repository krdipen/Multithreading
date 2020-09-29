import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {

    //extra
    private int catalogSize; //capacity
    //over

    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...

        this.catalog=catalog;
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        setSleepTime(sleepTime);
        setIteration(iteration);
        this.catalogSize=catalogSize;

        //WORK DONE
    }

    public void buy() throws InterruptedException {
        //extra
        lock.lock(); //locked
        //over
	try {
            //TODO Complete the try block for consume method
            // ...

            while(catalog.size()==0)
            {
                empty.await();
            }
            NodeBase<V> n=catalog.dequeue();

            //WORK DONE
            System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
            n.show(); // DO NOT REMOVE (For Automated Testing)
            // ...
            full.signalAll();  //extra
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
            lock.unlock();
            //WORK DONE
	}
    }
}
