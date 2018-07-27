class A extends Thread
{
	 int start;			
	 int end;
	 int indx;
	 ThreadManager tData;
       public A(int i, int j, int indx, ThreadManager thrdData) {
    	   start=i;
    	   end=j;
    	   this.indx=indx;
    	   tData = thrdData;
		// TODO Auto-generated constructor stub
	}

	public void run()
         {
		        double out1=tData.average(start,end);
		        tData.collect(indx, out1);

         }
}
