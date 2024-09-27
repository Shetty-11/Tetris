class Tetromino{
	private int[][] shape; 
	private int posX,posY;
	public Tetromino(int shape[][]){
		this.posX=getposX();
		this.posY=getposY();
		this.shape=shape;
	}
	public int getposX(){
	return posX;

	}
	public int getposY()
	{ return posY;

	}
	public int[][] getShape(){
	return shape;

	}
	public void moveRight(){
		posX++;
	}
	public void moveLeft(){
		posX--;
	}
	public void moveUp(){
		posY++;
	}

	public void moveDown(){
		posY--;
	}
	public void rotate() {
    int n = shape.length;
    int[][] newShape = new int[n][n];  // Corrected declaration
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            newShape[j][n - 1 - i] = shape[i][j];  // Rotate clockwise
        }
    }
    shape = newShape;
}


	public boolean isValidMove(int[][] board) {
    int new_x = getposX();
    int new_y = getposY();
    
    for (int i = 0; i < shape.length; i++) {
        for (int j = 0; j < shape[i].length; j++) {
            if (shape[i][j] != 0) {
                // Check for boundary violations
                if (new_x + j < 0 || new_x + j >= board[0].length || new_y + i < 0 || new_y + i >= board.length) {
                    return false;
                }
                // Check if the space is already occupied
                if (board[new_y + i][new_x + j] != 0) {
                    return false;
                }
            }
        }
    }
    return true;
}


	

}


	



