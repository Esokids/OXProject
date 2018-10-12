import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import org.bson.types.ObjectId;

public class LobbyDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection<Document> col = db.getCollection("rooms");

    public void createRoom(String name) {
        col.insertOne(new Document("name",name).append("unit",1));
    }

    public void showRoom(){
        MongoCursor<Document> cursor = col.find().iterator();
        while(cursor.hasNext()){
            Document rooms = cursor.next();
            System.out.println("Room name: " + rooms.get("name")+", Units: "+rooms.get("units"));
        }
    }
    /* Not Finish !!
    public boolean joinRoom(ObjectId id){
        Document findRoom = new Document("/_id",id);
        MongoCursor<Document> cursor = col.find(findRoom).iterator();
        System.out.println(findRoom.get("_id"));
        if(cursor.hasNext()){
            if((int)findRoom.get("units")==2)
                return false;
            else{
                col.updateOne(findRoom, new Document("$set",new Document("units",2)));
                return true;
            }
        }
        System.out.println(findRoom);
        return false;
    }
    */
}