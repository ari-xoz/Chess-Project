package Project;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn extends Piece{
	
	
	final ArrayList<Vector> whiteAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0,1), new Vector(0,2)));
	final ArrayList<Vector> blackAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0,-1), new Vector(0,-2) ));
	final ArrayList<Vector> whiteAttackdMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,1), new Vector(-1,1)));
	final ArrayList<Vector> blackAttackdMoves = new ArrayList<Vector>(Arrays.asList(new Vector(-1,-1), new Vector(1,-1)));
	
	
	public Pawn (Cell cell, Player player) {
		super(cell, player);
	}
	
	public boolean isValidPath(Cell finalCell) {
		return (this.validAttack(finalCell) || this.validNormalMove(finalCell));

	}

	public boolean validAttack(Cell finalCell){
		if(finalCell.getEmplacment()[0]> 8 || finalCell.getEmplacment()[1]> 8 || finalCell.isEmpty() || this.getColor() == finalCell.getPiece().getColor() ){
			return false;
		}
		else{
			Clr color = this.getColor();
			Cell initialCell = this.getCell();
			int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
			int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
			Vector moveVector = new Vector(directionX, directionY);

			if (color == Clr.WHITE) {
				if(whiteAttackdMoves.contains(moveVector)) {
					return true;
				}
			}
			else {
				if(blackAuthorizedMoves.contains(moveVector)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean validNormalMove(Cell finaCell){
		if(finalCell.getEmplacment()[0]> 8 || finalCell.getEmplacment()[1]> 8 || !finalCell.isEmpty()){
			return false;
		}
		else{
			if (color == Clr.WHITE) {
				if(whiteAuthorizedMoves.contains(moveVector)) {
					return true;
				}
			}
			else {
				Clr color = this.getColor();
				Cell initialCell = this.getCell();
				int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
				int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
				Vector moveVector = new Vector(directionX, directionY);
				if(blackAuthorizedMoves.contains(moveVector)) {
					return true;
				}
			}

		}
		return false;
	}
	
	public boolean attackPiece(Cell finalCell) {
		if(this.validAttack(finalCell)){
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}
	}
	
	public void transformToQueen(){
		if(this.getCell().getEmplacment()[1] == 8 ||  this.getCell().getEmplacment()[1] == -8 ) {
			Queen queen = new Queen(this.getCell(), this.getPlayer());
			this.getCell().setPiece(null);
			this.getCell().setPiece(queen);
		}
	}
}


