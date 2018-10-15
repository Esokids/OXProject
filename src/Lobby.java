import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import org.bson.*;

public class Lobby {
    private JList list1;
    private JList list2;
    private JTable table1;
    private JPanel ShowRoomsPanel;
    private JButton button1;
    LobbyDB db = new LobbyDB();

    public Lobby() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Lobby().getShowRoomsPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void showList(){
        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        List<Document> list = db.showRoom();
        for(int i = 0 ; i<list.size() ; i++){
            model1.addElement(list.get(i).get("name"));
            model2.addElement("("+list.get(i).get("units")+"/2)");
        }
        list1.setModel(model1);
        list2.setModel(model2);
    }
    /*
    public void showTable(){
        DefaultTableModel model = new DefaultTableModel();
        List<Document> list = db.showRoom();
        for(int i = 0 ; i<list.size() ; i++){
            model.
        }
    }
    */
    public JPanel getShowRoomsPanel() {
        return ShowRoomsPanel;
    }
}
