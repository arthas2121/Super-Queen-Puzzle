package SuperQueens;

import java.util.ArrayList;

public class Board {

	public int[][] array_board;
	public int length_board;
	public int fn = 0, gn = 0, hn = 0;
	public Board parent_board;
	public ArrayList<Board> child_board = new ArrayList<Board>();
	
	// Constructor when creating a board
	public Board(int length_board) {
		super();
		this.length_board = length_board;
		this.array_board = new int[length_board][length_board];
		this.gn = 0;
		this.hn = Heuristic.HeuristicFunction(this);
		this.fn = this.gn + this.hn;
	}

	// Set all element to 0 when creating a board
	public void setEmptyToZero() {
		for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				array_board[i][j] = 0;
			}
		}
	}	
	
	// Print the board
	public void printBoard() {
		System.out.print("The number of attack pairs is: ");
		System.out.println(this.hn);
		for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				System.out.print(array_board[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	// Copy the element of the board to a new board in order to add the next queen
	public int[][] copyArray(){
		int[][] copy_array = new int[length_board][length_board];
		for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				copy_array[i][j] = array_board[i][j];
			}
		}
		return copy_array;
	}
	
	//Add Queen in one row. There will be (number of the board_length) new states when adding a queen to a new row.
	public ArrayList<Board> addQueenByRow(int row) {
		
		ArrayList<Board> board_arraylist = new ArrayList<Board>();
		
			for(int j = 0; j < length_board; j++) {
				Board new_board = new Board(length_board);
				new_board.array_board = this.copyArray();
				new_board.array_board[row][j] = 1;
				new_board.gn = this.gn + 1;
				new_board.hn = Heuristic.HeuristicFunction(new_board);
				new_board.fn = new_board.gn + new_board.hn;
				new_board.parent_board = this;
				this.child_board.add(new_board);
				board_arraylist.add(new_board);
			}
			return board_arraylist;
	}
	
	//Count if the state has enough queens. When it meets, then end the program and print out the final state.
	public boolean countQueens() {
		boolean EnoughNumberOfQueens = false;
		int numberOfQueens = 0;
		for(int i = 0; i < length_board * length_board; i++) {
			if(array_board[i/length_board][i%length_board] == 1) {
				numberOfQueens++;
			}
			
			if(numberOfQueens == length_board) {
				EnoughNumberOfQueens = true;
				break;
			}
		}
		
		return EnoughNumberOfQueens;
	}
}
