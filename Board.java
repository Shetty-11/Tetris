public class Board {
    private final int row = 20;
    private final int col = 10;
    private int[][] grid = new int[row][col];
    private int score = 0;  // Variable to keep track of the score

    // Checks if a cell is empty
    public boolean isCellEmpty(int x, int y) {
        return grid[x][y] == 0;
    }

    // Sets the value of a cell
    public void setCell(int x, int y, int value) {
        grid[x][y] = value;
    }
	
	public int getCell(int x, int y) {
    return grid[x][y];
}

    // Displays the board and score
    public void displayBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] == 0 ? "." : "#");
            }
            System.out.println();
        }
        // Display the score at the bottom of the board
        System.out.println("Score: " + score);
    }

    // Increments the score when a line is cleared
    public void incrementScore(int linesCleared) {
        // Increment score based on the number of lines cleared
        // You can adjust the scoring logic as needed (e.g., +100 points per line)
        score += linesCleared * 100;
    }

    // Gets the board width
    public int getWidth() {
        return col;
    }

    // Gets the board height
    public int getHeight() {
        return row;
    }
	
}
