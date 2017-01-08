/*

 * Name: Aseel Molaldawila
 * File: Queen.java
 * ------------------
 * This class represents the Queen type of chess piece. This piece can move and capture
 * in any straight line (diagonally, horizontally, or vertically). For more information go 
 * here: http://en.wikipedia.org/wiki/Queen_(chess)
 */

public class Queen extends ChessPiece{

	/** Constructor for the Queen class */
	public Queen(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the queen can legally move
	 *  to the specified location.
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		boolean rookCondition = (nextRow==this.row || nextCol==this.col);
		boolean bishopCondition1 = (this.row+this.col==nextRow+nextCol);
		boolean bishopCondition2 = (this.row==this.col && nextRow==nextCol);
		boolean bishopCondition3 = (this.col-this.row)==(nextCol-nextRow);
		
		
		if(rookCondition){
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
		
		if( bishopCondition1 || bishopCondition2 || bishopCondition3){
			if(this.row>nextRow){
				if(this.col<nextCol){
					for(int r=this.row, c=this.col;r>nextRow && c<nextCol;r--,c++)
						if(board.pieceAt(r-1,c+1) != null && ((r-1!=nextRow)&&(c+1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
						
				}
				else{
					for(int r=this.row, c=this.col;r>nextRow && c>nextCol;r--,c--)
						if(board.pieceAt(r-1,c-1) != null && ((r-1!=nextRow)&&(c-1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
			}
			else{
				if(this.col<nextCol){
					for(int r=this.row, c=this.col;r<nextRow && c<nextCol;r++,c++)
						if(board.pieceAt(r+1,c+1) != null && ((r+1!=nextRow)&&(c+1!=nextCol)))
							return false;
					if(board.pieceAt(nextRow, nextCol)==null || board.pieceAt(nextRow, nextCol).color!=board.pieceAt(this.row, this.col).color){
						if(!moveWouldCauseCheck(nextRow, nextCol, board))
							return true;
					}
				}
				else{
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

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such
	 */
	public PieceType getType() 
	{
		return PieceType.QUEEN;
	}
	
}
