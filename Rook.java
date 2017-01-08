/*

 * Name: Aseel Molaldawila
 * File: Rook.java
 * ------------------
 * This class represents the Rook type of chess piece. This piece can move and capture 
 * pieces along rows and columns. It is also known as a castle. For more information visit: 
 * http://en.wikipedia.org/wiki/Rook_(chess)
 */

public class Rook extends ChessPiece{

	/** Constructor for the Rook class */
	public Rook(int initialRow, int initialCol, int pieceColor)
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
		if(nextRow==this.row || nextCol==this.col){
			if(nextRow==this.row){		// moving along the same row
				if(this.col<nextCol){ // moving from left to right
					for(int c =this.col; c<nextCol; c++)
						if(board.pieceAt(this.row, c+1) != null && (c+1!=nextCol))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
				else // moving from right to left
					for(int c =this.col; c>nextCol; c--)
						if(board.pieceAt(this.row, c-1) != null && (c-1!=nextCol))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
			}
			else{ // moving along the same column
				if(this.row>nextRow){ // moving from bottom to up
					for(int r =this.row; r>nextRow; r--)
						if(board.pieceAt(r-1, this.col) != null && (r-1!=nextRow))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
				else // moving from up to down
					for(int r =this.row; r<nextRow; r++)
						if(board.pieceAt(r+1, this.col) != null && (r+1!=nextRow))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
			}
		}
		
		return false;
	}

	/** Implementation of getType() method for the Rook class. Provides a way to identify
	 *  the Rook-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.ROOK;
	}

}
