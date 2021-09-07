/**
 * @(#)TableNotSynchronized.java
 *
 *
 * @author
 * @version 1.00 2021/5/19
 */

//Program to illuistrate threads working without being synchronized using the synchronized keyword.
//Synchronization is built around an internal entity known as a monitor or lock.
//A thread that needs consistent access to an objects fields has to acquire the objects lock
//Before accessing them, and then release the lock when it is done with the fields.
//Output fromt his program will be inconsistent because there is no synchronization.

class TableNotSynchronized {

	//Non-Synchronized method
	void printTable(int n) {
		for(int i=1; i<=5; i++){
			System.out.println(n*i);    //Multiply each iteration by the number received(5) and (100)

			try{
				Thread.sleep(400);      //Causes current thread to suspend execution for a specific period.
			} catch(Exception e){
				System.out.println(e);
			}//end catch
		}//end for
	}//end Non-Synchronized printTable method

	}//end class



	class MyThread1 extends Thread{
		TableNotSynchronized t;
		MyThread1(TableNotSynchronized t){
			this.t = t;
		}//end constructor

		public void run(){
			t.printTable(5);
		}//end run method
	}//end MyThread1 class




	class MyThread2 extends Thread{
		TableNotSynchronized t;

		MyThread2(TableNotSynchronized t){
			this.t = t;
		}//end constructor

		public void run(){
			t.printTable(100);
		}//end run method
	}//end MyThread2 class


	class TestSynchronization1{
		    public static void main(String args[]) {
		    	TableNotSynchronized obj = new TableNotSynchronized();   //Only one object
		    	MyThread1 t1 = new MyThread1(obj);
		    	MyThread2 t2 = new MyThread2(obj);
		    	t1.start();                  //Begin execution of threads
		    	t2.start();

    }//end main
	}//end TestSynchronization1 class


