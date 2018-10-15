import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;

public class LoginDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection<Document> col = db.getCollection("users");

    public boolean checkUserExists(String username){
        Document findUser = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findUser).iterator();
        if(cursor.hasNext())
            return true;
        else
            return false;
    }

    public boolean checkPassCorrect(String username,String password){
        Document findUserPass = new Document("user",username).append("pass",password);
        MongoCursor<Document> cursor = col.find(findUserPass).iterator();
        if(cursor.hasNext())
            return true;
        else
            return false;
    }

    public String getNickname(String username){
        Document findNickname = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findNickname).iterator();
        if(cursor.hasNext()) {
            Document nickname = cursor.next();
            return (String)nickname.get("nickname");
        }
        return "?????";
    }
}