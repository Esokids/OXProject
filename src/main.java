import org.bson.Document;
import java.util.*;

public class main {
    public static void main(String[] args) {

        /**********************Register*************************/
        /*
        RegisterDB db = new RegisterDB();
        //Check Username Exists ?
        if (db.checkUserExists("test123")) {
            System.out.println("This username exists !!");
        } else {
            System.out.println("You can use this Username");
        }

        //Add User To mlab
        db.addUser("test123456","123456","test");
        */
        /********************Login**********************/
        /*
        LoginDB db = new LoginDB();
        boolean username = false;
        boolean password = false;

        //Check Username Exists ?
        if(db.checkUserExists("test123"))
            username = true;

        if(username)
            System.out.println("Username Correct !!");
        else
            System.out.println("Username Incorrect !!");

        //If Username Exists so that Password is correct ?
        if(db.checkPassCorrect("test123","123456"))
            password = true;

        if(password)
            System.out.println("Password Correct !!");
        else
            System.out.println("Password Incorrect !!");
        */
        /*
        //Welcome
        LoginDB db = new LoginDB();
        String nickname = db.getNickname("nutty");
        System.out.println(nickname);
        */
        /***********************Lobby*********************/
        /*
        List<Document> list = new ArrayList<>();
        LobbyDB db = new LobbyDB();
        list = db.showRoom();
        //showroom
        for(int i = 0 ; i<list.size() ; i++) {
            System.out.println(list.get(i).get("_id") + " " +list.get(i).get("name") + " " + list.get(i).get("units"));
        }
        */
        /*
        if(db.joinRoom("5bc0487173707c2ce830d044"))
            System.out.println("You can Join this Room");
        else
            System.out.println("Please Join Another Room");
         */
    }
}