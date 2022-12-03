package Project;

public class Cell {
	public Piece piece;
	public int[] emplacment;
	public Clr color;
	public final Board board;
	
	public Cell(int coordX, int coordY, Clr color) {
		piece = null;
		emplacment[0] = coordX;
		emplacment[1] = coordY;
		this.color = color;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int[] getEmplacment() {
		return emplacment;
	}

	public void setEmplacment(int[] emplacment) {
		this.emplacment = emplacment;
	}

	public Clr getColor() {
		return color;
	}

	public void setColor(Clr color) {
		this.color = color;
	}
	
	
	public boolean isEmpty(){
		if(this.getPiece() == null) {
			return true;
		}
		else
			return false;
		
	}
	public Cell add(Vector vector){
		int x = this.getEmplacment()[0];
		int y = this.getEmplacment()[1];
		if(x+vector.getDirectionX()>8 || x+vector.getDirectionX()<0 || y+vector.getDirectionY()>8 || y+vector.getDirectionY()<0){
			return null;
		}
		return Board.getCell()

		
	}
	
	public Piece replacePiece(Piece other) {
		Piece old = this.getPiece();
		this.setPiece(other);
		old.setInGame(false);
		return old;
	}
	
	

}
