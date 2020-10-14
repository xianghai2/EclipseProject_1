package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBoard {

	@Test
	public void testInit() {
		System.out.println("test Board init()");
		Board board = new Board();
		board.init();  
		
		assert(board.getCellContent(1,1) == Seed.EMPTY);
		assert(board.getCellContent(2,2) == Seed.EMPTY);
	}

	@Test
	public void testIsDraw() {
		System.out.println("test Board draw()");
		Board board = new Board();
		board.init();  
		assert( board.isDraw() == false );		
		
	}

	@Test
	public void testHasWon() {
		System.out.println("test Board HasWon()");
		Board board = new Board();
		board.init();
		assert( board.hasWon(Seed.CIRCLE) == false );
		assert( board.hasWon(Seed.CROSS) == false );
		assert( board.hasWon(Seed.EMPTY) == true );
	}

	@Test
	public void testPaint() {
		System.out.println("test Paint()");
		Board board = new Board();
		board.init();
		board.paint();
	}
	
	@Test
	public void testSetCellContent() {
		System.out.println("test Board setCellContent()");
		Board board = new Board();
		board.init();  
		board.setCellContent(1, 1, Seed.CIRCLE);
		board.setCellContent(2, 1, Seed.CROSS);
		board.setCellContent(0, 1, Seed.EMPTY);
		
		assert(board.getCellContent(1,1) == Seed.CIRCLE);
		assert(board.getCellContent(2,1) == Seed.CROSS);
		assert(board.getCellContent(0,1) == Seed.EMPTY);
	}
	
	@Test
	public void testGetCellContent() {
		System.out.println("test Board setCellContent()");
		Board board = new Board();
		board.init();  
		board.setCellContent(1, 1, Seed.CIRCLE);
		board.setCellContent(2, 1, Seed.CROSS);
		board.setCellContent(0, 1, Seed.EMPTY);
		
		assert(board.getCellContent(1,1) == Seed.CIRCLE);
		assert(board.getCellContent(2,1) == Seed.CROSS);
		assert(board.getCellContent(0,1) == Seed.EMPTY);
	}


}
