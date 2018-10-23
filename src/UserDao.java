import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import java.util.*;

public class UserDao {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection<Document> col = db.getCollection("users");
    /*
    public boolean checkUserExists(String username){
        Document findUser = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findUser).iterator();
        if(cursor.hasNext()) {
            User user = new User(cursor.next().get("username").toString());
            return true;
        }
        return false;
    }
    */
    /*
    public boolean checkPassCorrect(String username,String password){
        Document findUserPass = new Document("user",username).append("pass",password);
        MongoCursor<Document> cursor = col.find(findUserPass).iterator();
        if(cursor.hasNext()){
            User user = new User(cursor.next().get("username").toString(), cursor.next().get("password").toString());
            return true;
        }
        else
            return false;
    }*/
    /*
    public boolean getNickname(String username){
        Document findNickname = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findNickname).iterator();
        if(cursor.hasNext()) {
            return true;
        }
        return false;
    }
    */
    public ArrayList<User> getUsers(){
        MongoCursor<Document> cursor = col.find().iterator();
        ArrayList<User> user = null;
        while(cursor.hasNext()){
            user.add(new User(cursor.next().get("_id").toString(), cursor.next().get("username").toString(),
                    cursor.next().get("password").toString(), cursor.next().get("nickname").toString(),
                    (int)cursor.next().get("scoreWin"),(int)cursor.next().get("scoreDraw"),(int)cursor.next().get("scoreLose")));
        }
        return user;
    }

    public User getuUser(String username){
        Document findUser = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findUser).iterator();
        User user = null;
        if (cursor.hasNext()){
            user = new User(cursor.next().get("_id").toString(), cursor.next().get("username").toString(),
                    cursor.next().get("password").toString(), cursor.next().get("nickname").toString(),
                    (int)cursor.next().get("scoreWin"),(int)cursor.next().get("scoreDraw"),(int)cursor.next().get("scoreLose"));
        }
        return user;
    }

    public void addUser(User user){
        col.insertOne(new Document("user",user.getUsername()).append("pass",user.getPassword()).append("nickname",user.getNickname())
                .append("scoreWin",user.getScoreWin()).append("scoreLose",user.getScoreDraw()).append("scoreDraw",user.getScoreLose()));
    }

}
