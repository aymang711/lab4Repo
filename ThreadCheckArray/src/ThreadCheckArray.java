import java.util.ArrayList;
/**
 * an Runnable class to work in the program With thread in each instance of this class
 * @author Ruslan Abed elrahman 
 * @version 2.0v
 *
 */
public class ThreadCheckArray implements Runnable {
	/**
	 * the flag field is to stop the run method in case we finish and found the numbers
	 */
	private boolean flag;
	/** * winArray Field is an boolean array to save the true or false of the numbers with same index */
	private boolean[] winArray;
	/** the  instance of the sharedData, that contain the array and the number we need to check*/
	SharedData sd;
	/** array List to to get the array from the sd and work with it in this class */
	ArrayList<Integer> array;
	/** the number we want to check */
	int b;
	/**an Construcor to get an instance of this class
	 * 
	 * @param sd       instance of the sharedData the has the array and the number we want to check it
	 */
	public ThreadCheckArray(SharedData sd) {
		this.sd = sd;
		synchronized (sd) {
			array = (ArrayList<Integer>) sd.getArray();
			b = sd.getB();
		}
		winArray = new boolean[array.size()];
	}
	
	/** an recurcie function that  imlpement an dynamic program , we can chosse the number in the array or not ..
	 * if we chose the number we send to the next function with out this number ....
	 * @param n           array size
	 * @param b			  the sum with out the number ( if we chosse to go with this number )
	 */
	void rec(int n, int b) {
		synchronized (sd) {
			if (sd.getFlag())
				return;
		}
		if (n == 1) {
			if (b == 0 || b == array.get(n-1)) {
				flag = true;
				synchronized (sd) {
					sd.setFlag(true);
				}
			}
			if (b == array.get(n-1))
				winArray[n - 1] = true;
			return;
		}

		rec(n - 1, b - array.get(n-1));
		if (flag)
			winArray[n - 1] = true;
		synchronized (sd) {
			if (sd.getFlag())
				return;
		}
		rec(n - 1, b);
	}

	/**an method that will call when we start the thread , and it then it will call 
	 * the rec method..
	 * 
	 */
	public void run() {
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.size() - 1, b - array.get(array.size() - 1));
			else
				rec(array.size() - 1, b);
		if (array.size() == 1)
			if (b == array.get(0) && !flag) {
				winArray[0] = true;
				flag = true;
				synchronized (sd) {
					sd.setFlag(true);
				}
			}
		if (flag) {
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.size() - 1] = true;
			synchronized (sd) {
				sd.setWinArray(winArray);
			}
		}
	}
}
