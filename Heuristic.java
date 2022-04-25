package SuperQueens;

public class Heuristic {

	//By checking all the 1's pairs and adding all the conflicted 1's pairs to get the hn value
	public static int HeuristicFunction(Board board) {
		int heuristic_value = 0;
		int numberOfPosition = board.length_board*board.length_board;
		
		for(int i = 0; i < numberOfPosition - 1; i++) {
			if(board.array_board[i/board.length_board][i%board.length_board] == 1) {
				for(int j = i+1; j < numberOfPosition; j++) {
					if(board.array_board[j/board.length_board][j%board.length_board] == 1) {
						heuristic_value += check_conflicts(i/board.length_board,i%board.length_board,j/board.length_board,j%board.length_board);
					}
				}
			}
		}
		return heuristic_value;
	}
	
	// Check conflicts
	public static int check_conflicts(int x1, int y1, int x2, int y2) {
		int value = 0;
		if(x1 == x2) {
			value++;
		}
		if(y1 == y2) {
			value++;
		}
		if(Math.abs(x1-x2) == Math.abs(y1-y2)) {
			value++;
		}
		if((Math.abs(x1-x2) == 1 && Math.abs(y1-y2) == 2) ||
			(Math.abs(x1-x2) == 2 && Math.abs(y1-y2) == 1)) {
			value++;
		}
		
		return value;

	}
	

}
