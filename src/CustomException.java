/**
 * Created by ahakobya on 9/11/2016.
 */

public class CustomException extends Exception {

    public CustomException(){ super();}

    public CustomException(String message){ super(message); }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

}
