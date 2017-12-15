import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;
import javax.swing.event.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
/*
 * Created by JFormDesigner on Sun Nov 26 18:08:33 PST 2017
 */



/**
 * @author Brendan Copp
 */
public class PlayerGui extends JPanel {
    public PlayerGui() {
        initComponents();
    }

    public void initData() {
        FantasyModel fm = FantasyModel.getFantasyModel();

        //Populate ComboBoxs
        for (String name : fm.getAllRosterNames()) {
            rosterComboBox.addItem(name);
        }
        for (int i = 0; i < DB.POSITIONS.length; i++) {
            playerComboBox.addItem(DB.POSITIONS[i]);
        }
    }

    //Sets data to current comboBox Selection
    private void rosterComboBoxItemStateChanged(ItemEvent e) {
        String rosterName = (String) e.getItem();
        setRosterList(rosterName);
    }

    private void playerComboBoxItemStateChanged(ItemEvent e) {
        String positionName = (String) e.getItem();
        setPlayerList(positionName);
    }


    private void rosterListMyRosterValueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()){
            int selectedIndex = ((JList<String>) e.getSource()).getSelectedIndex();
            System.out.println("Selected Index is : " + selectedIndex);
        }
    }



    //Button Listeners
    private void rosterAddPlayerActionPerformed(ActionEvent e) {
        int selectedIndex = rosterListPlayer.getSelectedIndex();
        if(selectedIndex != -1){
            Player player = rosterListPlayer.getModel().getElementAt(selectedIndex );

            if(isPlayerDuplicate(selectedIndex, player)){
                ErrorPopup.infoBox("You can only have one player per position", "Player Duplicate");
            }

            FantasyModel fm = FantasyModel.getFantasyModel();
            String rosterName = (String) rosterComboBox.getSelectedItem();
            fm.setRosterPlayer( rosterName , player);
            setRosterList(rosterName);
        }
        else
            ErrorPopup.infoBox("To add a player to your roster you must first select one from Players", "Player Not Selected");

    }

    //Should be replaced by SQL Query
    private boolean isPlayerDuplicate(int selectedIndex, Player player){
        int rosterSize = rosterListMyRoster.getModel().getSize();
        for(int i = 0; i < rosterSize; i++){
            if(i != selectedIndex){
                if(rosterListMyRoster.getModel().getElementAt(i).equals(player)){
                    return true;
                }
            }
        }
        return false;
    }

    private void modifyRosterActionPerformed(ActionEvent e) {
        SwingMain sm = SwingMain.getSwingMain();
        sm.openModifyRoster();
    }

    private void customSearchActionPerformed(ActionEvent e) {
        SwingMain sm = SwingMain.getSwingMain();
        sm.openCustomSearch();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Brendan Copp
        tabbedPane1 = new JTabbedPane();
        rosterPanel = new JPanel();
        rosterRosterLabel = new JLabel();
        rosterPlayerLabel = new JLabel();
        rosterAddPlayer = new JButton();
        playerComboBox = new JComboBox<>();
        scrollPane4 = new JScrollPane();
        rosterListMyRoster = new JList<>();
        scrollPane3 = new JScrollPane();
        rosterListPlayer = new JList<>();
        rosterComboBox = new JComboBox<>();
        modifyRoster = new JButton();
        customSearch = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(800, 600));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //======== tabbedPane1 ========
        {

            //======== rosterPanel ========
            {

                //---- rosterRosterLabel ----
                rosterRosterLabel.setText("Roster :");

                //---- rosterPlayerLabel ----
                rosterPlayerLabel.setText("Position :");

                //---- rosterAddPlayer ----
                rosterAddPlayer.setText("Add Player");
                rosterAddPlayer.addActionListener(e -> rosterAddPlayerActionPerformed(e));

                //---- playerComboBox ----
                playerComboBox.addItemListener(e -> playerComboBoxItemStateChanged(e));

                //======== scrollPane4 ========
                {

                    //---- rosterListMyRoster ----
                    rosterListMyRoster.setFont(rosterListMyRoster.getFont().deriveFont(rosterListMyRoster.getFont().getSize() + 2f));
                    scrollPane4.setViewportView(rosterListMyRoster);
                }

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(rosterListPlayer);
                }

                //---- rosterComboBox ----
                rosterComboBox.setName("Hallo");
                rosterComboBox.addItemListener(e -> rosterComboBoxItemStateChanged(e));

                //---- modifyRoster ----
                modifyRoster.setText("Modify Rosters");
                modifyRoster.addActionListener(e -> modifyRosterActionPerformed(e));

                //---- customSearch ----
                customSearch.setText("Custom Search");
                customSearch.addActionListener(e -> customSearchActionPerformed(e));

                GroupLayout rosterPanelLayout = new GroupLayout(rosterPanel);
                rosterPanel.setLayout(rosterPanelLayout);
                rosterPanelLayout.setHorizontalGroup(
                    rosterPanelLayout.createParallelGroup()
                        .addGroup(rosterPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(rosterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(rosterAddPlayer, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.LEADING, rosterPanelLayout.createSequentialGroup()
                                    .addComponent(rosterRosterLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rosterComboBox))
                                .addComponent(modifyRoster, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addComponent(rosterPlayerLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(playerComboBox, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(customSearch, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                rosterPanelLayout.setVerticalGroup(
                    rosterPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, rosterPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addComponent(rosterRosterLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rosterPlayerLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, rosterPanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(rosterComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(playerComboBox))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(rosterAddPlayer)
                                    .addGap(18, 18, 18)
                                    .addComponent(modifyRoster)
                                    .addGap(90, 90, 90))
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addGroup(rosterPanelLayout.createParallelGroup()
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customSearch))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
            }
            tabbedPane1.addTab("Roster", rosterPanel);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addComponent(tabbedPane1)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Brendan Copp
    private JTabbedPane tabbedPane1;
    private JPanel rosterPanel;
    private JLabel rosterRosterLabel;
    private JLabel rosterPlayerLabel;
    private JButton rosterAddPlayer;
    private JComboBox<String> playerComboBox;
    private JScrollPane scrollPane4;
    private JList<Player> rosterListMyRoster;
    private JScrollPane scrollPane3;
    private JList<Player> rosterListPlayer;
    private JComboBox<String> rosterComboBox;
    private JButton modifyRoster;
    private JButton customSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables



    //LIST HANDELERS
    public void setRosterList(String rosterName) {

        FantasyModel fm = FantasyModel.getFantasyModel();
        ArrayList<Player> rosterArrayList = fm.getRosterPlayers(rosterName);

        DefaultListModel<Player> listModel = new DefaultListModel<>();
        for (Player player : rosterArrayList) {
            listModel.addElement(player);
        }

        rosterListMyRoster.setModel(listModel);
    }

    public void setPlayerList(String playerPosition) {
        QueryInterface qi = QueryInterface.getQueryInterface();

        ArrayList<Player> playerList = qi.getFakePlayers();

        DefaultListModel<Player> listModel = new DefaultListModel<>();
        for (Player player : playerList) {
            listModel.addElement(player);
        }

        rosterListPlayer.setModel(listModel);
    }




/*        rosterListMyRoster.setModel(new AbstractListModel<String>() {
            String[] values = rosterArrayList.toArray( new String[rosterArrayList.size()] );

            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
        }*/

/*
    public void setPlayerList(String positionName){
        QueryInterface qi = QueryInterface.getQueryInterface();
        qi.getFakeRoster();
        for

        rosterListMyRoster.setModel(new AbstractListModel<String>() {
            String[] values = playerArrayList.toArray( new String[playerArrayList.size()] );

            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
        });
    }*/


}
