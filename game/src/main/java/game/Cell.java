package game;

public class Cell {

	Seed content; 
	
	int row, col; 

	//initialize this cell 
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.content = Seed.EMPTY;
	}

	// Clear the cell 
	public void clear() {
		content = Seed.EMPTY;
	}
	
	public Seed getContent() {
		return this.content;
	}
	
	public void setContent(Seed seed) {
		this.content = seed;
	}

	// Paint itself
	public void paint() {
		
		switch (content) {
		case CROSS:  System.out.print(" X "); break;
		case CIRCLE: System.out.print(" O "); break;
		case EMPTY:  System.out.print("   "); break;
		}
	}
}
