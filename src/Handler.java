
/**
 * Created by ahakobya on 9/9/2016.
 * this class is for handling all actions to move turtle on the board
 */
public class Handler {

    Board board;
    Turtle turtle;

    public Handler() {
        board = new Board();
        turtle = new Turtle();
    }

    /**
     * the method changes turtle head direction
     *
     * @param direction
     * @throws CustomException
     */
    public void changeHeadDirection(String direction) throws CustomException {

        if (direction.equals(Constants.Down) || direction.equals(Constants.LEFT) || direction.equals(Constants.RIGHT) || direction.equals(Constants.UP)) {
            turtle.setHeadDirection(direction);
        } else {
            throw new CustomException("Invalid head direction");

        }
    }


    /**
     * the method changes turtle coordinates on the board and tracks the trajectory when the pen is down
     *
     * @param count
     * @param direction
     * @throws CustomException
     */
    public void move(int count, String direction) throws CustomException {
        int currX = turtle.getX();
        int currY = turtle.getY();

        if (isOnBoard(count, direction, currX, currY)) {
            changeHeadDirection(direction);

            switch (direction) {
                case Constants.Down:
                    turtle.setY(turtle.getY() + count);
                    break;
                case Constants.UP:
                    turtle.setY(turtle.getY() - count);
                    break;
                case Constants.LEFT:
                    turtle.setX(turtle.getX() - count);
                    break;
                case Constants.RIGHT:
                    turtle.setX(turtle.getX() + count);
            }
            //move on board
            if (board.isPenState()) {
                switch (direction) {
                    case Constants.Down:
                        for (int i = currY; i <= turtle.getY(); i++) {
                            board.setBoard(i, currX, 1);
                        }
                        break;
                    case Constants.UP:
                        for (int i = currY; i >= turtle.getY(); i--) {
                            board.setBoard(i, currX, 1);
                        }
                        break;
                    case Constants.LEFT:
                        for (int i = currX; i >= turtle.getX(); i--) {
                            board.setBoard(currY, i, 1);
                        }
                        break;
                    case Constants.RIGHT:
                        for (int i = currX; i <= turtle.getX(); i++) {
                            board.setBoard(currY, i, 1);
                        }
                        break;
                }
            } else {
                board.setBoard(turtle.getX(), turtle.getY(), 0);
            }

        } else {
            throw new CustomException("turtle is out of the board");
        }

    }

    /**
     * the method check if turtle movement on the board is allowed or not
     *
     * @param count
     * @param direction
     * @return
     */
    private boolean isOnBoard(int count, String direction, int currX, int currY) {
        int x = currX;
        int y = currY;
        switch (direction) {
            case Constants.Down:
                y += count;
                break;
            case Constants.UP:
                y -= count;
                break;
            case Constants.LEFT:
                x -= count;
                break;
            case Constants.RIGHT:
                x += count;
                break;
        }
        return (x >= 0 && x < Board.getLENGTH() & y >= 0 && y < Board.getHEIGHT());
    }

    /**
     * the method prints board current state
     *
     * @throws CustomException
     */
    public void printBoard() throws CustomException {
        try {
            for (int i = 0; i < Board.getLENGTH(); i++) {
                for (int j = 0; j < Board.getHEIGHT(); j++) {
                    System.out.print(board.getBoard()[i][j]);
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            throw new CustomException("Unable get the board");
        }
    }

    /**
     * prints current state on board
     */
    public void getCurrentState(){
        String penState = "up";
        if(board.isPenState()){
            penState = "down";
        }
        System.out.println("The turtle is in [" + turtle.getX() + ", " + turtle.getY() + "] state and the pen is " + penState + "\n");
    }

}
