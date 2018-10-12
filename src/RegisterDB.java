import javax.swing.JOptionPane;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import java.util.*;
public class RegisterDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    BasicDBObject query = new BasicDBObject();
    MongoCollection<Document> col = db.getCollection("users");
    ArrayList<String> arr = new ArrayList<>();
    public boolean checkUserExists(String username){
        Document findQuery = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findQuery).iterator();
            if(col.countDocuments()==1)
                return true;
            else
                return false;
    }

}