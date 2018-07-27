import java.util.Arrays;

class ThreadTest
{
	     private static final Class<A> A = null;

		//Coupling threadData object with A? Is this better or worse?
		public static void main(String args[])
       { 


		//setup array to be calculated
		int sum = 0;
		int threads = 3;
		int numCount = 90; // only odd
		ThreadManager td = new ThreadManager();
		td.toBeCalculated = new Integer[numCount];
		td.out=new Double[threads];
		
		for(int i=0;i<numCount;i++) {
			int num = (int) (Math.random()*10+1);
			td.toBeCalculated[i]= num;
			sum += num;
		}
		System.out.println(Arrays.toString(td.toBeCalculated));
		System.out.println("Average should be " + sum/numCount);	
		
		td.setThreading(threads,  A);
		td.startThreads();
		td.joinThreads();
		
 
       System.out.println("Threaded groups are " + td.out[0]+" "+td.out[1]+" "+td.out[2]);
       int avg = (int) (td.out[0]+td.out[1]+td.out[2])/3;
       System.out.println("Avg = " + avg);
                   
                   
           }
}
