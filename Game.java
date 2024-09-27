import java.util.Scanner;

class Game {
    private Board board;
    private Tetromino currentPiece;
    private boolean isRunning;

    public Game() {
        board = new Board();
        currentPiece = new Tetromino(randomTetrimino());
        isRunning = true;
    }

    
    public void handleInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a move (l = left, r = right, d = down, q = rotate): ");
        char move = sc.next().charAt(0);
        switch (move) {
            case 'l':
                currentPiece.moveLeft();
                break;
            case 'r':
                currentPiece.moveRight();
                break;
            case 'd':
                currentPiece.moveDown();
                break;
            case 'q':
                currentPiece.rotate();
                break;
        }
    }

    
    public void start() {
        while (isRunning) {
            board.displayBoard();
            handleInput();
            currentPiece.moveDown();

            if (!isValid(currentPiece, board)) {
                placePiece(currentPiece, board);
                currentPiece = new Tetromino(randomTetrimino());
                clearCompleteLines();  // Check and clear lines if completed
                checkGameOver();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Places the current piece on the board
    public void placePiece(Tetromino piece, Board board) {
        for (int i = 0; i < piece.length(); i++) {
            for (int j = 0; j < piece.width(); j++) {
                if (piece.getShape()[i][j] == 1) {
                    board.setCell(piece.getposX() + j, piece.getposY() + i, 1);
                }
            }
        }
    }

    // Generates a random Tetromino
    public int[][] randomTetrimino() {
    int[][][] tets = {
        TetrominoShapes.I_SHAPE, 
        TetrominoShapes.O_SHAPE, 
        TetrominoShapes.T_SHAPE, 
        TetrominoShapes.L_SHAPE, 
        TetrominoShapes.J_SHAPE, 
        TetrominoShapes.S_SHAPE, 
        TetrominoShapes.Z_SHAPE
    };
    return tets[(int) (Math.random() * tets.length)];
}


    // Checks if the game is over
    public void checkGameOver() {
        if (!isMoveValid(currentPiece, board)) {
            isRunning = false;
            System.out.println("Game Over!");
        }
    }

    // Checks for and clears complete lines
   public void clearCompleteLines() {
    int linesCleared = 0;
    for (int i = 0; i < board.getHeight(); i++) {
        if (isLineComplete(i)) {
            clearLine(i);
            linesCleared++;
        }
    }
    if (linesCleared > 0) {
        board.incrementScore(linesCleared);  // Update score based on lines cleared
        System.out.println("Lines cleared: " + linesCleared);
    }
}


    // Determines if a line is complete
    public boolean isLineComplete(int row) {
        for (int j = 0; j < board.getWidth(); j++) {
            if (board.getCell(row, j) == 0) {
                return false;
            }
        }
        return true;
    }

    // Clears a line and shifts the board down
    public void clearLine(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 0; j < board.getWidth(); j++) {
                board.setCell(i, j, board.getCell(i - 1, j));
            }
        }
        // Clear the top row
        for (int j = 0; j < board.getWidth(); j++) {
            board.setCell(0, j, 0);
        }
    }
}
