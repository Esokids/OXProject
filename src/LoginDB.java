import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class LoginDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    BasicDBObject query = new BasicDBObject();
    MongoCollection<Document> col = db.getCollection("users");

    public boolean checkUserExists(String username){
        Document findQuery = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findQuery).iterator();
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

}
