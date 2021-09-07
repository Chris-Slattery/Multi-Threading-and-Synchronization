/**
 * @(#)TableSynchronized.java
 *
 *
 * @author
 * @version 1.00 2021/5/19
 */

//Program to illuistrate threads working while synchronized using the synchronized keyword.
//A synchronized method is used to lock an object for any shared resource.
//When thread invokes a synchronized method, it automatically acquires the lock for that object.
//And releases it when the thread completes its task.
//This will ensure that the output is consistent.

public class TableSynchronized {

		//Synchronized method
	synchronized void printTable(int n) {
		for(int i=1; i<=5; i++){
			System.out.println(n*i);    //Multiply each iteration by the number received(5) and (100)

			try{
				Thread.sleep(400);      //Causes current thread to suspend execution for a specific period.
			} catch(Exception e){
				System.out.println(e);
			}//end catch
		}//end for
	}//end Synchronized printTable method


}//end TableSynchronized class


	class MyThread1 extends Thread{
		TableSynchronized t;
		MyThread1(TableSynchronized t){
			this.t = t;
		}//end constructor

		public void run(){
			t.printTable(5);
		}//end run method
	}//end MyThread1 class


		class MyThread2 extends Thread{
		TableSynchronized t;

		MyThread2(TableSynchronized t){
			this.t = t;
		}//end constructor

		public void run(){
			t.printTable(100);
		}//end run method
	}//end MyThread2 class


		class TestSynchronization2{
		    public static void main(String args[]) {
		    	TableSynchronized obj = new TableSynchronized();   //Only one object
		    	MyThread1 t1 = new MyThread1(obj);
		    	MyThread2 t2 = new MyThread2(obj);
		    	t1.start();                  //Begin execution of threads
		    	t2.start();

    }//end main
	}//end TestSynchronization1 class






