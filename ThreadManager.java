import java.util.ArrayList;

public class ThreadManager {
	public Integer[]toBeCalculated;
	public Double[]out;
	public ArrayList<A> arr = new ArrayList<A>();
	
	//assuming int array has already been past - would normally handle this
	public void setThreading(int threadCount, Class<A> a) {		
		if(!(toBeCalculated.length % threadCount==0)) {
			return;
		} //only if we can split to that thread count
		
		
		int index = 0;
		//create group of threads equivilent to desired threading amount
		
		int split = toBeCalculated.length/threadCount;
		for(int i = 0; i < toBeCalculated.length ;i++) {
			if(i%(split) == 0) {				
				arr.add(new A(i, i + split-1, index, this));
				index++;
			}
		}
	}
	
	public void startThreads() {
		for (A a : arr) {
			a.run();
		}
	}
	
	public void joinThreads() {
		for (A a : arr) {
			try {
				a.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
    public synchronized double average(int i,int j){
  	  
  	  double avg=0;
  	  int count=0;
  	  for(int k=i;k<j;k++)
  	  {
  		  avg=avg+toBeCalculated[k];
  		  count++;
  	  }
  	  return avg/count;
    }
    
    public synchronized void collect(int index,double o)
    {
  	  out[index]=o;
    }
    
    
	

}
