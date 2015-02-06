import java.util.Scanner;

//Board class which defines a 2d board for wordament and all methods required to work upon it
public class Board {
	int rows, columns;

	String[] board;

	// Constructor for getting inputs into the board
	public Board() {
		Scanner input = new Scanner(System.in);
		rows = input.nextInt();
		columns = input.nextInt();
		input.nextLine();
		board = new String[rows];
		for (int i = 0; i < rows; i++) {
			board[i] = input.nextLine().replace(" ", "");

		}
	}

	// printBoard method is used for debugging purpose to print to console
	public void printBoard() {
		for (int i = 0; i < rows; i++) {
			System.out.println(board[i]);
		}
	}
}
