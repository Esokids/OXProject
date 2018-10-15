import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import org.bson.*;

public class Lobby {
    private JList list1;
    private JList list2;
    private JPanel ShowRoomsPanel;
    private JButton button1;
    private JButton joinButton;
    LobbyDB db = new LobbyDB();

    public Lobby() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Document> list = db.showRoom();
                int i = list1.getSelectedIndex();
                String id = list.get(i).get("_id").toString();
                if(db.joinRoom(id))
                    JOptionPane.showMessageDialog(null,"You can join this room");
                else
                    JOptionPane.showMessageDialog(null,"You can not join this room");
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

    public JPanel getShowRoomsPanel() {
        return ShowRoomsPanel;
    }
}
