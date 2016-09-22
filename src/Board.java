/**
 * Created by ahakobya on 9/9/2016.
 */
public class Board {

    private static final int LENGTH = 20;
    private static final int HEIGHT = 20;
    private  boolean penState;
    public Integer[][] board;

    public Board(){
        board = new Integer[LENGTH][HEIGHT];
        for(int i=0; i<LENGTH; i++){
            for(int j=0; j<HEIGHT; j++){
                board[i][j] = 0;
            }
        }
        penState = false;
    }

    public static int getLENGTH() {
        return LENGTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(int x, int y, int value) {
        board[x][y] = value;
    }

    public boolean isPenState() {
        return penState;
    }

    public void setPenState(boolean penState) {
        this.penState = penState;
    }
}
