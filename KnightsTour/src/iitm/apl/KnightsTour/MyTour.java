package iitm.apl.KnightsTour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MyTour extends ChessBoard{

	//reference variable for storing all the moves taken
	List<Move> movesList;
	
	@Override
	List<Move> tour(Move m) {
		// TODO Auto-generated method stub
		movesList = new ArrayList<Move>();
		
		
		backTrackMoves(m);
		return movesList;
	}
	
	//comparator class for ordering elements in moves according to the heuristic i.e 
	//taking the move such that it has lesser reachable moves from there on(Heuristic)
	
	class MyComparator implements Comparator<Move>{

		@Override
		public int compare(Move o1, Move o2) {
			// TODO Auto-generated method stub
			int count1=0, count2=0;
			
			for(Move move: o1.reachableMoves()){
				if(isNextMoveValid(move)){
					count1++;
				}
			}
			
			for(Move move : o2.reachableMoves()){
				if(isNextMoveValid(move)){
					count2++;
				}
			}
			return count1 - count2;
		}


		
	}
	
	//backtracking with the heuristic mentioned above
	private boolean backTrackMoves(Move m){
		
		movesList.add(m);
		makeMove(m);
		
		MyComparator myComparator = new MyComparator();
		
		PriorityQueue<Move> pQueue = new PriorityQueue<Move>(10, myComparator);
		
		if(movesList.size() == getBoardSize()*getBoardSize()){
			return true;
		}
		
		for(Move move: m.reachableMoves()){
			if(isNextMoveValid(move)){
				pQueue.add(move);
			}
		}
		
		Move move;
		
		for(int i=0;i<pQueue.size();i++){
			move = pQueue.poll();
			if(backTrackMoves(move)){
				return true;
			}
			else{
				movesList.remove(move);
				undoMove();
			}
		}
		
/*		
 * 		Backtracking if used without heuristic
 * 		for(Move move: m.reachableMoves()){
			if(isNextMoveValid(move)){
				
				if(backTrackMoves(move)){
					return true;
				}
				else{
					movesList.remove(move);
					undoMove();
				}
			}
		}*/
		
		return false;
	}
	
	public static void main(String[] args){
		initialise(new MyTour());
		
	}
	
}
