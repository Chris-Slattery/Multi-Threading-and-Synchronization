/**
 * @(#)SynchronizedWithAnnonymousClass.java
 *
 *
 * @author
 * @version 1.00 2021/5/19
 */

//Program to illustrate Synchronization while using annonymous class.
//The Annonymous class will create 2 threads.

public class SynchronizedWithAnnonymousClass {

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

}//end SynchronizedWithAnnonymousClass class


class TestSynchronization3{
	public static void main(String args[]){
		final SynchronizedWithAnnonymousClass obj = new SynchronizedWithAnnonymousClass();    //Only one object.
		Thread t1 = new Thread(){

        //Annonymous class
		public void run(){
			obj.printTable(5);
		}//end run method
		};   //end annonymous thread class


        //Annonymous class
		Thread t2 = new Thread(){
			public void run(){
				obj.printTable(100);
			}//end run method
		};   //end annonymous thread class

		//Execute threads
		t1.start();
		t2.start();


	}//end main
}//end class


