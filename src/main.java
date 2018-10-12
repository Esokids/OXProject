public class main {
    static RegisterDB db = new RegisterDB();

    public static void main(String[] args) {
        
        //Check Username Exists ?
        if (db.checkUserExists("test123")) {
            System.out.println("This username exists !!");
        } else {
            System.out.println("You can use this Username");
        }

        //Add User To mlab
        //db.addUser("test12345","123456","test");
    }
}
