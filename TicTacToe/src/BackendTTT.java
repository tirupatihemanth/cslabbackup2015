/**
 * 
 * @author HemanthKumarTirupati
 *
 * An abstract representation of the Tic - Tac - Toe board
 * 
 */
public class BackendTTT {
	
	int size = 3;
	boolean player1;
	boolean player2;
	short player1Moves;
	short player2Moves;
	short moves;
	short boardStatus[][];
	
	/**
	 * Constructor for the backend
	 * @param size
	 */
	public BackendTTT(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.player1 = true;
		this.player2 = false;
		boardStatus = new short[size][size];
	}
	
	
	
}