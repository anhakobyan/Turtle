/**
 * Created by ahakobya on 9/9/2016.
 */
public class Turtle {


    private int x;
    private int y;
    private String headDirection;

    public Turtle(){

        this.x = 0;
        this.y = 0;
        this.headDirection = Constants.RIGHT;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getHeadDirection() {
        return headDirection;
    }

    public void setHeadDirection(String headDirection) {
        this.headDirection = headDirection;
    }
}
