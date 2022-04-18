import java.util.concurrent.atomic.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Batsirai Malcolm Dzimati
// Student Number: u20456078

public class MCSLock implements Lock{
	AtomicReference<QNode> tail;
	ThreadLocal<QNode> myNode;

	public MCSLock(){
		tail = new AtomicReference<QNode>(null);
		myNode = new ThreadLocal<QNode>(){
			protected QNode initialValue(){
				return new QNode();
			}
		};
	}

	class QNode{
		boolean locked = false;
		QNode next = null;
	}

	public void lock(){
		QNode qnode = myNode.get();
		QNode pred = tail.getAndSet(qnode);
		
		if(pred != null){
			qnode.locked = true;
			pred.next = qnode;
			while(qnode.locked) Thread.yield();
		}
	}

	public void unlock(){
		QNode qnode = myNode.get();
		if(qnode.next==null){
			if(tail.compareAndSet(qnode, null))
				return;

			while(qnode.next==null) Thread.yield();
		}
		qnode.next.locked = false;
		qnode.next = null;
	}
	
	public void lockInterruptibly() throws InterruptedException
        {
                throw new UnsupportedOperationException();
        }

        public boolean tryLock()
        {
                throw new UnsupportedOperationException();
        }

        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
        {
                throw new UnsupportedOperationException();
        }

        public Condition newCondition()
        {
                throw new UnsupportedOperationException();
        }

}
