/**
* HangmanPart3.java
* CS101 Assignment 7
* Nicole Lee Fella
*/

//IO
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//for integer parsing
import java.lang.String;

public class HangmanPart3
{
	HangmanGame hangmanGame;
	public static String currentGuessText;
	
	
	//constructor just starts input loop
	public HangmanPart3()
	{
		//call function to start input loop
		readInput();
	}
	
	//get input from user, looping until user types "Quit" or gives incorrect value
	public void readInput()
	{
		//wrap input stream read input from user
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ));
		
		//prompt user for input
		System.out.println( "Please enter a letter or type Quit to end.");
		
		try{
			String userGuess = in.readLine();
			
			//loop until the user types "Quit"
			do{
				//invoke guessletter function with String input
				hangmanGame.guessLetter(userGuess);
				//update currentGuessText
				currentGuessText = hangmanGame.getCurrentGuess();
				//trace out current guess
				System.out.println("Your current guess is: " + currentGuessText);
				//update remainingStrikes
				hangmanGame.numberOfRemainingStrikes();
				//trace out remaining number of strikes
				System.out.println("You currently have " + hangmanGame);
				//invoke revealAnswer function to check over gameOver, gameWon, and getAnswer
				revealAnswer();
			}while ( userGuess != "Quit" );
		}
		//catch IOException ioe
		catch (IOException ioe)
		{
			//tell exception to print its error log
			ioe.printStackTrace();
		}
	}
	
	/**
	* update game to reveal correct answer
	*/
	public void revealAnswer()
	{
		//check if game over
		if(hangmanGame.gameOver() == true){
			//if game over, get answer
			System.out.println( "The word was: " + hangmanGame.getAnswer());
		}
		//check if game won
		if(hangmanGame.gameWon() == true){
			//if game won, get answer and say "You win!"
			System.out.println( "You win! The word was: " + hangmanGame.getAnswer());
		}
		//check if game over and game lost
		if(hangmanGame.gameOver()==true && hangmanGame.gameWon()==false){
			//if game over and game lost, say "Sorry, you lose."
			System.out.println( "Sorry, you lose. The word was: " + hangmanGame.getAnswer());
		}
		
	}				
	
	public static void main( String[] args )
	{
		HangmanGame hangmanGame = new HangmanGame();

		//create new instance of class to get everything started
		new HangmanPart3();
	}
	
}
