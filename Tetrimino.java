class Tetrimino{
	private int[][] shape; 
	private int posX,posY;
	public Tetrimino(int shape[][]){
		this.posX=getposX();
		this.posY=getPosY();
		this.shape=shape;
	}
	public int getposX(){
	return posX;

	}
	public int getposY()
	{ return posY;

	}
	public int[][] getshape(){
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
	public void rotate(int row,int col){
		int n=shape.length;
		int new_shape[][]=new int[][];
	for(int i=0;i<n;i++){
		for(int j=0;j<shape[i].length;j++){
			new_shape[i][n-1-i]=shape[i][j];
		}
	}
	shape=new_shape;
	}

	public bool isvalidmove(int[][]shape){
		int n=shape.length;
		int m=shape[0].length;
		int new_x=getposX()+m;
		int new_y=getposY()+n;
		if(new_x>10 || new_y>20 || new_x<0 || new_y<0){
			return false;
		}
		return true;
	}

	

}

public class TetrominoShapes {  
    public static final int[][] I_SHAPE = {{1, 1, 1, 1}};
    public static final int[][] O_SHAPE = {{1, 1}, {1, 1}};
    public static final int[][] T_SHAPE = {{0, 1, 0}, {1, 1, 1}};
    public static final int[][] L_SHAPE = {{1, 0}, {1, 0}, {1, 1}};
    public static final int[][] J_SHAPE = {{0, 1}, {0, 1}, {1, 1}};
    public static final int[][] S_SHAPE = {{0, 1, 1}, {1, 1, 0}};
    public static final int[][] Z_SHAPE = {{1, 1, 0}, {0, 1, 1}};
}


	


