//Wordament class works upon Board and manipulates upon the board object(Board class) and various functions and features
public class Wordament {

	Board board;

	// Constructor for initialisng a new Wordament game
	public Wordament() {
		board = new Board();
	}

	// to print the board which just call the printBoard method in Board class
	public void printBoard() {
		board.printBoard();
	}

	// find presence of a word in the board
	public boolean findWord(String word) {
		boolean[][] freq = new boolean[board.rows][board.columns];
		for (int i = 0; i < board.rows; i++) {
			for (int j = 0; j < board.columns; j++) {
				if (board.board[i].charAt(j) == word.charAt(0)) {
					initialiseArray(freq);
					if (findRecursiveAdj(word, 0, i, j, freq)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// Recursive backtracking counterpart for finding the presence of a word in
	// the board
	private boolean findRecursiveAdj(String word, int idx, int posi, int posj,
			boolean[][] freq) {

		freq[posi][posj] = true;

		if (idx == word.length() - 1) {
			return true;
		}

		if (posj > 0 && freq[posi][posj - 1] != true
				&& board.board[posi].charAt(posj - 1) == word.charAt(idx + 1)) {
			if (findRecursiveAdj(word, idx + 1, posi, posj - 1, freq)) {
				return true;
			}
		}

		if (posj < board.columns - 1 && freq[posi][posj + 1] != true
				&& board.board[posi].charAt(posj + 1) == word.charAt(idx + 1)) {
			if (findRecursiveAdj(word, idx + 1, posi, posj + 1, freq)) {
				return true;
			}
		}

		if (posi > 0 && freq[posi - 1][posj] != true
				&& board.board[posi - 1].charAt(posj) == word.charAt(idx + 1)) {
			if (findRecursiveAdj(word, idx + 1, posi - 1, posj, freq)) {
				return true;
			}
		}

		if (posi < board.rows - 1 && freq[posi + 1][posj] != true
				&& board.board[posi + 1].charAt(posj) == word.charAt(idx + 1)) {
			if (findRecursiveAdj(word, idx + 1, posi + 1, posj, freq)) {
				return true;
			}
		}

		freq[posi][posj] = false;
		return false;
	}

	// initialiseArray to check if the path for finding the word has already
	// been used up
	private void initialiseArray(boolean[][] freq) {
		for (int i = 0; i < board.rows; i++) {
			for (int j = 0; j < board.columns; j++) {
				freq[i][j] = false;
			}
		}
	}

}
