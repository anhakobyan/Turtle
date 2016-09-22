import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ahakobya on 9/11/2016.
 */
public class Viewer {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {
            System.out.println("Short user guide:\nenter commaseparated params by sequence direction,count,pen state\n" +
                    "for direction available values are \"up\"/\"down\"/\"lef\"/\"right\", for count should be stand an integer and" +
                    " pen state should have \"on\" for the value if you want to record the movement\n"+"to close the game just type \"exit\"\n");

            br = new BufferedReader(new InputStreamReader(System.in));
            Handler handler = new Handler();

            while (true) {

                System.out.print("Please enter directions to move turtle : ");
                String directions = br.readLine().trim().toLowerCase();
                if ("exit".equals(directions)){
                    System.out.println("bye :)");
                    break;
                }else {
                    String head = handler.turtle.getHeadDirection();
                    boolean pen = handler.board.isPenState();
                    int count = 0;

                    String[] params = directions.split(",");
                    if (!params[0].isEmpty() && !params[0].equals(null)) {
                        head = params[0];
                    }
                    if (params.length > 2) {
                        if ("on".equals(params[2])) {
                            pen = true;
                        }else if("off".equals(params[2])){
                            pen = false;
                        }
                        handler.board.setPenState(pen);
                    }
                    if (params.length > 1) {
                        try{
                        count = Integer.parseInt(params[1]);
                        }catch(NumberFormatException e){
                            e.getMessage();
                            System.out.println("Count should have an int value");
                            continue;
                        }
                    }
                try {
                    handler.move(count, head);
                    handler.printBoard();
                    handler.getCurrentState();
                }catch (CustomException e){
                    System.out.println(e.getMessage());
                }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
