/**
* HangmanGame.java
* CS101 Assignment 7
* Nicole Lee Fella
*/

public class HangmanGame
{
	//allowed number of strikes
	private int NUMBER_STRIKES = 7; 
	//strikes remaining
	private int remainingStrikes;
	// each index contains single letter of hidden word
	private String[] currentWordArray; 
	//index I is true if user has correctly guessed letter at that index
	private String[] currentGuessArray; 
	//holds current number of strikes against player
	private int strikes;
	//dictionary variable of class Dictionary
	private Dictionary dictionary = new Dictionary();
	//array functions variable of class ArrayFunctions
	private ArrayFunctions arrayFunctions = new ArrayFunctions();
	
	/**
	*Constructor to start init game
	*/
	public HangmanGame()
	{
		initGame();
	}
	
	/** This function initializes a game of "logic"
	* A word should be randomly chosen from the dictionary
	* with variables assigned accordingly
	*/
	public void initGame()
	{
		//decide chosen word, and store in variable chosenWord
		String chosenWord = dictionary.randomWord();
		//define new Array for currentWordArray
		currentWordArray = new String[chosenWord.length()];
		//assign Array of randomWord String --> changed with string2Array function
		currentWordArray = arrayFunctions.string2Array(chosenWord);
		//initialize strikes to zero
		strikes =0;
		//invoke initGuess function, to initialize currentWordArray
		initGuess();
	}
	
	/**
	* this "helper" function creates a new Array for currentGuess variable
	* it initializes all slots to be false
	*/
	public void initGuess()
	{
		//length of initGuess will be as long as length of currentWordArray
		//give currentGuessArray the length of currentWordArray
		currentGuessArray = new String[currentWordArray.length];
		//use for-loop to initialize all slots to be false
		for (int i=0; i<currentWordArray.length; i++){
			//initialize all slots to be false
			currentGuessArray[i]="0";
		}
		//invoke getCurrentGuess function 
		getCurrentGuess();
	}
	
	/**
	* This function will update the currentGuess variable
	* if the letter is not found, number of strikes should be updated
	*/
	public void guessLetter(String p)
	{
		//use for-loop to check each value of currentWordArray
		for(int i=0; i<currentWordArray.length;i++){
			//check if parameter p is found in currentWordArray
			if (p == currentWordArray[i]){
				//if true, replace currentGuess[i] with letter from 
				//parameter p
				currentGuessArray[i] = p;
			}
		}
	}
	
	/**
	* This function should return String "?" for unrevealed letters
	* This functino will "walk over" currentWord and currentGuess arrays
	* and create strings accordingly.
	* if false at index i in currentGuess, then ? should appear
	* if true at index i in currentGuess, then value in i'th slot should appear
	*/
	public String getCurrentGuess()
	{
		//define currentGuessString
		String currentGuessString = "";
		//use for-loop to "walk over" currentGuessArray
		for (int i=0; i<currentGuessArray.length; i++){
			//if false at index i in currentGuess, then ? should appear
			if (currentGuessArray[i] == "0"){
				//add ? in place for that character spot
				currentGuessString = currentGuessString + "?";
			}
			//if true at index i in currentGuess, then value in i'th slot
			//of currentWord should appear
			else{
				//add value in i'th slot of currentWord
				currentGuessString = currentGuessString + currentWordArray[i];
			}
		}
		//if currentGuessField text (last word guessed) is euqal to currentGuessString
		if (HangmanPart3.currentGuessText == currentGuessString){
			//invoke numberOfStrikes function to update number of strikes
			numberOfStrikes();
		}
		//trace currentGuessString to output window
		System.out.println( "Your current Guess is: " + currentGuessString);
		//return currentGuessString to the function
		return currentGuessString;
	}
	
	/**
	* returns number of strikes against player thus far
	* strike variable will be updated each time this function is invoked
	*/
	public int numberOfStrikes()
	{
		//update strikes variable--> add 1 to strikes variable
		strikes = strikes + 1;
		//return number of strikes against player so far
		return strikes;
	}
	
	/**
	* this funcitno will return remaining number of strikes for player
	* 
	* subtract current number of strikes from NUMBERS_STRIKES variable
	*/
	public int numberOfRemainingStrikes()
	{
		//define variable remaining strikes
		remainingStrikes = NUMBER_STRIKES - strikes;
		//return remaining strikes
		return remainingStrikes;
	}
	
	/**
	* this function will return the hidden word chosen from original dictionary Array
	*/
	public String getAnswer()
	{
		//change currentWordArray into a string which is returnable to function
		return arrayFunctions.array2String(currentWordArray);
	}
	
	/**
	* this function will return true whether the game is won or lose
	* the game must only be over to return true
	*/
	public boolean gameOver()
	{
		//true if remaining strikes equals zero OR if currentGuess is same as currentWord
		if ( (NUMBER_STRIKES == strikes) || (arrayFunctions.array2String(currentGuessArray)) == (arrayFunctions.array2String(currentWordArray)) ){
			return true;
		}
		//if not, then false
		else{
			return false;
		}
		
	}
	
	/**
	* this function will return true if player won game
	* meaning guess all the letters in the word
	*/
	public boolean gameWon()
	{
		//true if currentGuess=currentWord AND number of remaining strikes
		//doesn't equal zero
		if( (arrayFunctions.array2String(currentGuessArray) == arrayFunctions.array2String(currentWordArray) ) && (NUMBER_STRIKES != strikes))
		{
			return true;
		}
		//if not, then false
		else{
			return false;
		}
	}
	
}
