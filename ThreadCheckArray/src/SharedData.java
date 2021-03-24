import java.util.ArrayList;
/** a class to use as a model to save the data an array of it ,
 * 
 * 
 * @author Ruslan abed alrahman
 * @version 2.0v
 *
 */
public class SharedData 
{
	/** an Array List  to save the numbers (Intgers) with  */
	private ArrayList<Integer> array;
	/** an Array to save the numbers that we need to return in case it is true  */
	private boolean [] winArray;
	/** an Flag to declare that it found the numbers the program need   */
	private boolean flag;
	/** save the number that need to check it  */
	private final int b;
	
	/** Construcor to get an instance of this class
	 *@param array                the array of the numbers
	 *@param b                    the number we need to check
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}
   /**
    * 
    * @return get the numbers we found
    */
	public boolean[] getWinArray() 
	{
		return winArray;
	}
	/**
	 * 
	 * @param winArray                set the array of the numbers that found
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * 
	 * @return an array of the orignal numbers that we need to check in it
	 */
	public ArrayList<Integer> getArray() 
	{
		return array;
	}

	/**
	 * 
	 * @return the number to check if we can found an sum of numbers in the array 
	 * that can equal to it 
	 */
	public int getB() 
	{
		return b;
	}
	/**
	 * 
	 * @return the flag say if we found the numbers yet -> true
 	 */
	public boolean getFlag() 
	{
		return flag;
	}
	
	/** 
	 * 
	 * @param flag            set the flag , in case we found the numbers it means it is equal to true
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
