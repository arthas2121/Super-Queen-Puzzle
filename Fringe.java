package SuperQueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fringe {

	ArrayList<Board> board_arraylist = new ArrayList<Board>();
	
	
	// Sort the fringe by the value of Fn.
	public void SortFringeByFn() {
		Collections.sort(board_arraylist, new Comparator<Board>(){
			@Override
			public int compare(Board first_board, Board second_board) {
				// TODO Auto-generated method stub
				if(first_board.fn > second_board.fn) {
					return 1;
				}else if(first_board.fn < second_board.fn) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		System.out.println("The size of the fringe is " + this.board_arraylist.size());
	}
	
}
