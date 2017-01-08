/*
 * Name: Aseel Molaldawila
 * File: Bishop.java
 * ------------------
 * This class represents the Bishop type of chess piece. This piece can move and capture 
 * pieces along diagonals. For more information visit: http://en.wikipedia.org/wiki/Bishop_(chess)
 */

public class Bishop extends ChessPiece{

	/** Constructor for the Bishop class */
	public Bishop(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the bishop can legally move
	 *  to the specified location.
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		boolean condition1 = (this.row+this.col==nextRow+nextCol);
		boolean condition2 = (this.row==this.col && nextRow==nextCol);
		boolean condition3 = (this.col-this.row)==(nextCol-nextRow);
		
		if( condition1 || condition2 || condition3){
			if(this.row>nextRow){ // moving from the bottom corners to the up
				if(this.col<nextCol){ // moving from bottom left to top right
					for(int r=this.row, c=this.col;r>nextRow && c<nextCol;r--,c++)
						if(board.pieceAt(r-1,c+1) != null && ((r-1!=nextRow)&&(c+1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
						
				}
				else{ // from right bottom to top left
					for(int r=this.row, c=this.col;r>nextRow && c>nextCol;r--,c--)
						if(board.pieceAt(r-1,c-1) != null && ((r-1!=nextRow)&&(c-1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
			}
			else{ // moving up to down
				if(this.col<nextCol){ // from top left corner to bottom right
					for(int r=this.row, c=this.col;r<nextRow && c<nextCol;r++,c++)
						if(board.pieceAt(r+1,c+1) != null && ((r+1!=nextRow)&&(c+1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
				else{ // moving from top right to bottom left
					for(int r=this.row, c=this.col;r<nextRow && c>nextCol;r++,c--)
						if(board.pieceAt(r+1,c-1) != null && ((r+1!=nextRow)&&(c-1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
			}
		}
		return false;
	}
	
	/** Implementation of getType() method for the Bishop class. Provides a way to identify
	 *  the Bishop-type chess piece as such.
	 */
	public PieceType getType() 
	{
		return PieceType.BISHOP;
	}
}
