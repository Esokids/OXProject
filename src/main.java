public class main {
    static RegisterDB db = new RegisterDB();

    public static void main(String[] args) {
        if (db.checkUserExists("test123")==true) {
            System.out.println("This username exists !!");
        } else {
            System.out.println("You can use this Username");
        }
    }
}
