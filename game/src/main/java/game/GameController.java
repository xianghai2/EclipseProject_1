package game;
import java.util.Scanner;
import java.io.*;

public class GameController {

	private Board board;            
	private GameState currentState; 
	private Seed currentPlayer;     

	private static Scanner consoleInput = new Scanner(System.in);  

	public static void main(String[] args) {

		GameController gameController = new GameController();  
		gameController.GameLoop();

	}
	
	public void GameLoop() {
		
		board = new Board(); 
		board.init();  

		currentState = GameState.PLAYING; // ready to play

		System.out.println( "Please choose who will play first ( Alice stands for X, Bob stands for O ): "); 
		// Who play first
		do {			

			String str  = consoleInput.nextLine();

			if( str.equalsIgnoreCase("Alice")) {  //Alice plays first
				currentPlayer = Seed.CROSS;       
				break; 
			} else if(str.equalsIgnoreCase("Bob"))	{  // Bob plays first
				currentPlayer = Seed.CIRCLE;      
				break; 
			}

		}while(true) ;  

		// Game main loop 
		do {

			playerMove(currentPlayer); // update the content, currentRow and currentCol

			board.paint();             // ask the board to paint itself

			if (board.hasWon(currentPlayer)) {  // win or not
				currentState = (currentPlayer == Seed.CROSS) ? GameState.CROSS_WON : GameState.CIRCLE_WON;
			} else if (board.isDraw()) {  // draw or not
				currentState = GameState.DRAW;
			}


			if (currentState == GameState.CROSS_WON) {
				System.out.println("Alice won! ");
			} else if (currentState == GameState.CIRCLE_WON) {
				System.out.println("Bob won! ");
			} else if (currentState == GameState.DRAW) {
				System.out.println("It's Draw! Game over! ");
			}

			// switch turn
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.CIRCLE : Seed.CROSS;

		} while (currentState == GameState.PLAYING);  
	}


	public GameController() {
		
	}


	// The current player makes one move
	private void playerMove(Seed seed) {

		boolean validInput = false;  // flag for validating input

		do {

			if (seed == Seed.CROSS) {
				System.out.println("Player Alice ('X'), enter your move (row[1-3] column[1-3]): ");
			} else {
				System.out.println("Player Bob ('O'), enter your move (row[1-3] column[1-3]): ");
			}

			int row = consoleInput.nextInt() - 1;
			int col = consoleInput.nextInt() - 1;

			if (row >= 0 && row < Board.ROWS 
					&& col >= 0 && col < Board.COLS
					&& board.getCellContent(row, col) == Seed.EMPTY) {

				board.setCellContent(row, col, seed);
				validInput = true; // input okay, exit loop

			} else {
				System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is invalid. Try again...");
			}

		} while (!validInput);   // repeat until input is valid

	}

}
