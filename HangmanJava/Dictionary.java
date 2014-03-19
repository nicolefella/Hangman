/**
* Dictionary.java
* CS101 Assignment 7
* Nicole Lee Fella
*/

import java.lang.Math;

public class Dictionary
{
	//create an array of 5 words of MY choosing
	String[] dictionary = {"piano", "beach", "daisy", "library", "travel"};
	
		
	/** this function will retrun a random word from dictionary Array
	* will include a random number generator
	* and will return array value of dictionary[#]
	*/
	public String randomWord()
	{
		//generate random number between 0.0 and 1.0
		double randNum = Math.random();
		
		//use randNum to choose word from dictionary Array 
		//each choice has equal chance of being chosen
		if(randNum<(1/5)){
			//return first value in dictionary array
			return dictionary[0];
		}
		else if(randNum<(2/5)){
			//return second value
			return dictionary[1];
		}
		else if(randNum<(3/5)){
			//return third value
			return dictionary[2];
		}
		else if(randNum<(4/5)){
			//return fourth value
			return dictionary[3];
		}
		else{
			//return final value
			return dictionary[4];
		}
	}

}
