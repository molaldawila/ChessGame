/*
 * Name: Aseel Molaldawila
 * File: Chess.java
 * ------------------
 * This program plays the game Chess.
 */

import java.awt.Color;
import java.awt.event.*;

/** The main class responsible for managing the chess game */
public class Chess extends GraphicsProgram{

	
	/** Object responsible for handling the graphical display on the screen */
	ChessDisplay display;
	
	/** Object that keeps track of the locations of all pieces */
	ChessBoard board;

	/** class vairables that is shared between all objects to keep tracks of the mouseClicks */
	 private static int mouseClicks = 0;

	 private ChessPiece pieceToMove;
	 private ChessPiece selectedSpot;
	 
	 private static int player = ChessPiece.WHITE;
	/** Method called before run responsible for initializing the ChessDisplay and 
	 *  ChessBoard objects */
	public void init()
	{
		display = ChessDisplay.getInstance(this);			 
		board = new ChessBoard();
		
		display.useRealChessLabels(true);					 
	}
	
	/** The main method that runs the program */
	public void run()
	{
		display.draw(board);	
		// Must call this method to be able to get mouse events
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e){
		int []location = display.getLocation(e.getX(), e.getY());
		int row = location[0];
		int col = location[1];
		selectedSpot = board.pieceAt(row, col);

		if(isFirstClick()){			
			if(selectedSpot.getColor()==player){
				display.selectSquare(row, col,Color.green);
				pieceToMove = selectedSpot;
				display.draw(board);
			}
		}
		else{
			if(isMoveLegal(pieceToMove, row, col)&& selectedSpot != pieceToMove){
				board.removePiece(pieceToMove.getRow(), pieceToMove.getCol());
				pieceToMove.moveTo(row, col);
				board.addPiece(pieceToMove);
				display.unselectAll();
				display.draw(board);
				
				switchPlayer();
				isGameOver();
			}
			else{
				display.unselectAll();
				display.draw(board);	
			}	
		}		
	}

	public void switchPlayer(){
		if(player==ChessPiece.WHITE){
			player = ChessPiece.BLACK;
		}
		else{
			player = ChessPiece.WHITE;
		}
	}
	public String playerInWords(){
		if(player==1)
			return "WHITE";
		else
			return "BLACK";
	}
	public void isGameOver(){
		if(isInCheckMate(board, player)){
			println("Player " +playerInWords() +" is inCheckMate");
			println("Game Over!");
		}
		if(isInStalemate(board, player)){
			println("Player " +playerInWords() +" is isInStalemate");	
			println("Game Over!");
		}
		if(isInCheck(board, player)){
			println("Player " +playerInWords() +" is isInCheck");	
		}
	}
	
	public boolean isFirstClick(){
		if(mouseClicks==0){
			mouseClicks++; // increment mouse counter 
		    return true;
		}
		else
		    mouseClicks = 0; // reset counter 
			return false;
	}
	
	
	/*
	 * notice that the piece object argument is the piece to move
	 * and row and col is the new location where the piece wants to move
	 * and NOT its current location
	 */
	public boolean isMoveLegal(ChessPiece piece, int row, int col){
		switch (piece.getType())
		{
			case KING:
				return piece.canMoveTo(row, col, board);
			case KNIGHT:
				return piece.canMoveTo(row, col, board);
			case QUEEN:
				return piece.canMoveTo(row, col, board);
			case ROOK:
				return piece.canMoveTo(row, col, board);
			case BISHOP:
				return piece.canMoveTo(row, col, board);
			case PAWN:
				return piece.canMoveTo(row, col, board);
			default:
				return false;
		}

	}
	}
