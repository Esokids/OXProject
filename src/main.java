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
    }
}