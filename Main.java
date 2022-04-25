package SuperQueens;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ask the user to enter the length of the board.
		System.out.println("Please input the length of the board: ");
		Scanner scan = new Scanner(System.in);
		int board_length = scan.nextInt();		
		scan.close();
		
		//Create a fringe for the child states.
		Fringe fringe = new Fringe();
		
		//Create a new board with all 0 values.
		Board new_board = new Board(board_length);
		new_board.setEmptyToZero();
		new_board.printBoard();
		
		//And the start state to the fringe.
		fringe.board_arraylist.add(new_board);
		Board current_board = null;
		
		/*
		Board temp_board = new Board(4);
		int[][] temp_array = new int[][] {{1,0,0,0}, {0,1,0,0}, {0,0,0,1}, {0,0,0,0}};
		temp_board.array_board = temp_array;
		temp_board.printBoard();
		System.out.println(temp_board.hn);
		*/
		
		int count = 0;
		
		//Loop until there is no element in the fringe.
		while(fringe.board_arraylist.size() != 0) {
			System.out.println("The " + ++count + " steps: ");
			//Get the fringe with the minimum hn value
			fringe.SortFringeByFn();
			current_board = fringe.board_arraylist.get(0);
			current_board.printBoard();
			
			//Get the final state when the number of queens meets the length of the board.
			if(current_board.countQueens()) {
				System.out.println("\n\n\n\n\n\n");
				System.out.println("The final state with minimum super queens attacks is reached!");
				current_board.printBoard();
				while(current_board.parent_board != null) {
					System.out.println("The former board state:");
					current_board.parent_board.printBoard();
					current_board = current_board.parent_board;
				}
				break;
			}
			/*
			for(int i = 0; i < board_length; i++) {
				Board next_board = null;
				ArrayList<Board> board_arraylist = new ArrayList<Board>();
				board_arraylist = current_board.addQueenByRow(i);
				
				for(Board board: board_arraylist) {
					next_board = board;
					fringe.board_arraylist.add(next_board);
				}
			}
			*/
			
			//Check which row of the current_board needs to add the next queen.
			int row = 0;
			label: for(int i = board_length - 1; i >= 0; i--) {
				for(int j = board_length - 1; j >= 0; j--) {
					if(current_board.array_board[i][j] == 1) {
						row = i+1;
						break label;
					}
				}
			}
			
			//Add all the child states to the fringe.
			Board next_board = null;
			ArrayList<Board> board_arraylist = new ArrayList<Board>();
			board_arraylist = current_board.addQueenByRow(row);
			
			for(Board board: board_arraylist) {
				next_board = board;
				fringe.board_arraylist.add(next_board);
			}
			
			//Remove the current state from the fringe.
			fringe.board_arraylist.remove(current_board);
		}
	}

}
