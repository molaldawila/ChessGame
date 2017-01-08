/*
 * Name:
 * Section Leader:
 * File: King.java
 * ------------------
 * This class represents the King type of chess piece. This piece can move (and capture) one 
 * space in any direction. If you lose it, you lose the game. For more information go here: 
 * http://en.wikipedia.org/wiki/King_(chess)
 */

public class King extends ChessPiece{
	
	/** Constructor for the King class */
	public King(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the king can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{	
		boolean condition1 = (this.row==nextRow) && (Math.abs(nextCol-this.col)==1);
		boolean condition2 = (this.row-nextRow==1) && (nextCol-this.col==0 || Math.abs(nextCol-this.col)==1);
		boolean condition3 = (nextRow-this.row==1) && (nextCol-this.col==0 || Math.abs(nextCol-this.col)==1);
		
		if(condition1 || condition2 || condition3){
			if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
				if(!moveWouldCauseCheck(nextRow, nextCol, board))
					return true;
			}
		}
		return false;
	}
	
	/** Implementation of getType() method for the King class. Provides a way to identify
	 *  the King-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.KING;
	}
	
}
