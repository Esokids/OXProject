import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import java.util.*;

public class ProfileDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection<Document> col = db.getCollection("users");

    public List<Document> showLeaderBoard(){
        List<Document> list = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().sort(new BasicDBObject("scoreWin",1).
                append("scoreDraw",1).append("scoreLose",-1)).iterator();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
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

    public int getScoreWin(String username){
        Document findScoreWin = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findScoreWin).iterator();
        if(cursor.hasNext())
            return (int)cursor.next().get("scoreWin");
        else
            return -1;
    }

    public int getScoreDraw(String username){
        Document findScoreWin = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findScoreWin).iterator();
        if(cursor.hasNext())
            return (int)cursor.next().get("scoreDraw");
        else
            return -1;
    }

    public int getScoreLose(String username){
        Document findScoreWin = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findScoreWin).iterator();
        if(cursor.hasNext())
            return (int)cursor.next().get("scoreLose");
        else
            return -1;
    }
}
