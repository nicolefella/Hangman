/**
* ArrayFunctions.java
* CS101 Assignment 7
* Nicole Lee Fella
*/

public class ArrayFunctions
{
	/**
	* The parameter of this function is assumed to be an Array of Strings
	* Should return a String in concatenation of elements of Array 
	*(Summing up Array strings)
	*/
	public String array2String(String[] inputA)
	{
		//define String variable concatString, initialize to contain nothing
		String concatString = "";
		
		//use for-loop to go through each element of the array
		for (int i=0; i<inputA.length; i++){
			//"sum" up elements of Array into concatString
			concatString = concatString + inputA[i];
		}
		//retrun concatString
		return concatString;
	}
	
	/**
	* create Array that puts each letter of passed parameter into own slot
	*/
	public String[] string2Array(String inputS)
	{
		//define concatArray variable
		String[] concatArray = new String[inputS.length()];
		//use for-loop to go through each element of String
		for (int i=0; i<inputS.length(); i++){
			//put letter at certain place in String into spot in Array
			concatArray[i] = inputS.substring(i,i);
		}
		//return concatArray
		return concatArray;
	}
	
}
