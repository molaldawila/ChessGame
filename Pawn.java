/*
 * Name:
 * Section Leader:
 * File: Pawn.java
 * ------------------
 * This class represents the Pawn type of chess piece. This piece can move only straight 
 * forward (away from your side toward the other side). In can normally move only one space
 * at a time, except on the first move, when it has the option of moving two spaces. The pawn,
 * although it moves only forward, captures only diagonally forward. Turns out, this makes it
 * the most difficult to implement in code (fair warning). For more information go 
 * here: http://en.wikipedia.org/wiki/Pawn_(chess)
 */

public class Pawn extends ChessPiece{

	/** Constructor for the Pawn class */
	public Pawn(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
		isFirstMove = true;
		}	

	private boolean isFirstMove;
	/** Method that returns a boolean indicating whether or not the pawn can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		int color = board.pieceAt(this.row, this.col).color;
		boolean oneWhiteMove = this.row-nextRow==1;
		boolean twoWhiteMoves = this.row-nextRow==2;
		boolean oneBlackMove = nextRow-this.row==1;
		boolean twoBlackMoves = nextRow- this.row==2;
		
		switch(color){
		case ChessPiece.WHITE:
			//do white stuff
			if(!oneWhiteMove && !twoWhiteMoves ){
				return false;
			}
			else
				if(oneWhiteMove){
					if(this.col==nextCol){
						if(board.pieceAt(nextRow, nextCol)==null && !moveWouldCauseCheck(nextRow, nextCol, board)){
							isFirstMove=false;
							return true;
						}
						else
							return false;	
					}
					else
						if(board.pieceAt(nextRow, nextCol)!=null && board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
							if(!moveWouldCauseCheck(nextRow, nextCol, board))
								isFirstMove=false;
								return true;
						}
				}
				else{
					if(this.col==nextCol && isFirstMove)
						if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
							if(!moveWouldCauseCheck(nextRow, nextCol, board))
								isFirstMove=false;
								return true;
						}
				}	
		case ChessPiece.BLACK:
			if(!oneBlackMove && !twoBlackMoves )
				return false;
			else
				if(oneBlackMove){
					if(this.col==nextCol){
						if(board.pieceAt(nextRow, nextCol)==null && !moveWouldCauseCheck(nextRow, nextCol, board)){
							isFirstMove=false;
							return true;
						}
						else
							return false;
					}
					else
						if(board.pieceAt(nextRow, nextCol)!=null && board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
							if(!moveWouldCauseCheck(nextRow, nextCol, board))
								isFirstMove=false;
								return true;
						}
				}
				else{
					if(this.col==nextCol && isFirstMove)
						if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
							if(!moveWouldCauseCheck(nextRow, nextCol, board))
								isFirstMove=false;
								return true;
						}
				}
		default:
			return false;
		}

	}

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.PAWN;
	}
	
}
