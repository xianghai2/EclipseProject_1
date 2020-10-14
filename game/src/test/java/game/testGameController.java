package game;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;

public class testGameController {

	@Test
	public void testGameLoop() {
		System.out.println("test GameController GameLoop()");
		
		String gameConsoleInput = "Alice\r\n2 2\r\n1 2\r\n1 1\r\n3 2\r\n3 3\r\n"; // simulate input 
		InputStream stdin = System.in;
		PrintStream systemOut = System.out;
		try {
			System.setIn(new ByteArrayInputStream(gameConsoleInput.getBytes()));
			ByteArrayOutputStream testOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(testOut));

			GameController gameController = new GameController();
			gameController.GameLoop();

			String testString = "Alice won! ";
			String result = testOut.toString();

			assert(result.contains(testString)); // validate the game result 

			System.setOut(systemOut);		 
			System.out.println(result);

		} finally {
			System.setIn(stdin);
			System.setOut(systemOut);
		}
	}

}
