
public class Sudoku {
	public static boolean sudokuSolver(int[][] board, int boardLength) {
		boolean noZeros = true;
		int row = 0;
		int col = 0;
		
		for(int i = 0; i < boardLength; i++) {
			for(int j = 0; j < boardLength; j++) {
				if(board[i][j] == 0) {
					row = i;
					col = j;
					
					noZeros = false;
					break;
				}
			}
			
			if(!noZeros) {
				break;
			}
		}
		
		if(noZeros) {
			return true;
		}
		
		for(int num = 1; num <= boardLength; num++) {
			if(isPossible(board, row, col, num)) {
				board[row][col] = num;
				
				if(sudokuSolver(board, boardLength)) {
					return true;
				}
				
				else {
					board[row][col] = 0;
				}
			}
		}
		
		return false;
		
	}
	
	public static boolean isPossible(int[][] board, int row, int col, int num) {
		int sqrtBoard = (int) Math.sqrt(board.length);
		int beginRow = row - row % sqrtBoard;
		int beginCol = col - col % sqrtBoard;
		
		for(int i = 0; i < board.length; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		
		for(int j = 0; j < board.length; j++) {
			if(board[j][col] == num) {
				return false;
			}
		}
		
		for(int a = beginRow; a < beginRow + sqrtBoard; a++) {
			for(int b = beginCol; b < beginCol + sqrtBoard; b++) {
				if(board[a][b] == num) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void print(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
				if((j+1) % ((int) Math.sqrt(board.length)) == 0) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
			if((i+1) % ((int) Math.sqrt(board.length)) == 0) {
				System.out.print("\n");
			}
		}
	}
	
}
