import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.lang.reflect.Array;
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
        updateRosterComboBox();

        for (int i = 0; i < DB.POSITIONS.length; i++) {
            playerComboBox.addItem(DB.POSITIONS[i]);
        }
    }

    public void updateRosterComboBox(){
        FantasyModel fm = FantasyModel.getFantasyModel();
        rosterComboBox.removeAllItems();

        for (String name : fm.getAllRosterNames()) {
            rosterComboBox.addItem(name);
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


    //Button Listeners
    private void rosterAddPlayerActionPerformed(ActionEvent e) {
        int selectedPlayerIndex = rosterListPlayer.getSelectedIndex();
        int selectedRosterIndex = rosterListMyRoster.getSelectedIndex();
        if(selectedPlayerIndex == -1 || selectedRosterIndex == -1){
            ErrorPopup.infoBox("To add a player to your roster you must first select Players", "Player Not Selected");
        }
        else{
            //Get Selected player
            Player playerPlayer = rosterListPlayer.getSelectedValue();
            Player playerRoster = rosterListMyRoster.getSelectedValue();

            boolean isDuplicate = false;
            for(int i = 0; i < rosterListMyRoster.getModel().getSize(); i++){
                if(rosterListMyRoster.getModel().getElementAt(i).mID == playerPlayer.mID){
                    isDuplicate = true;
                }
            }
            if(isDuplicate){
                ErrorPopup.infoBox("You already have one of these players on your roster", "Player Duplicate");
                return;
            }

            if(isPlayerSamePosition(playerPlayer, playerRoster)){
                ErrorPopup.infoBox("This player is the wrong position, please select again", "Wrong Position");
                return;
            }

            //Success
            FantasyModel fm = FantasyModel.getFantasyModel();
            String rosterName = (String) rosterComboBox.getSelectedItem();
            fm.setRosterPlayer( rosterName , playerPlayer );

            //TODO: Update Database
        }
    }

    private boolean isPlayerDuplicate(Player playerPlayer, Player playerRoster){
        if(playerPlayer.mID == playerRoster.mID)
            return true;
        return false;
    }

    private boolean isPlayerSamePosition(Player playerPlayer, Player playerRoster){
        if(playerPlayer.mPosition == playerRoster.mPosition)
            return true;
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

    private void buttonUpdateActionPerformed(ActionEvent e) {
        updateGui();
    }

    private String getCurrentRoster(){
        return rosterComboBox.getItemAt(comboBoxWeek.getSelectedIndex());
    }

    private String getCurrentPosition(){
        return playerComboBox.getItemAt(comboBoxWeek.getSelectedIndex());
    }

    private int getCurrentWeek(){
        return Integer.parseInt(comboBoxWeek.getItemAt(comboBoxWeek.getSelectedIndex()));
    }

    public void updateGui(){
        int week = getCurrentWeek();
        String position = getCurrentPosition();
        String roster = getCurrentRoster();

        DefaultListModel<Player> rosterModel = createRosterPlayerModel(roster);
        DefaultListModel<Player> playersModel = createPlayersModel(position, week);

        rosterListMyRoster.setModel(rosterModel);
        rosterListPlayer.setModel(playersModel);
    }

    public void updateGui(ArrayList<Player> players){
        int week = getCurrentWeek();
        String position = getCurrentPosition();
        String roster = getCurrentRoster();

        DefaultListModel<Player> rosterModel = createRosterPlayerModel(roster);
        DefaultListModel<Player> playersModel = createPlayersModel(players);

        rosterListMyRoster.setModel(rosterModel);
        rosterListPlayer.setModel(playersModel);
    }

    private void buttonBestRosterActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    //LIST HANDELERS
    public void setRosterList(String rosterName) {
        rosterListMyRoster.setModel(createRosterPlayerModel(rosterName));
    }

    private DefaultListModel<Player> createRosterPlayerModel(String rosterName){

        FantasyModel fm = FantasyModel.getFantasyModel();
        ArrayList<Player> rosterArrayList = fm.getRosterPlayers(rosterName);

        DefaultListModel<Player> listModel = new DefaultListModel<>();
        for (Player player : rosterArrayList) {
            listModel.addElement(player);
        }

        return listModel;
    }

    private DefaultListModel<Player> createPlayersModel(String position, int week){

        FantasyModel fm = FantasyModel.getFantasyModel();
        ArrayList<Player> playersArrayList = fm.mQI.getPlayersByPositionWeek(position, week);

        DefaultListModel<Player> listModel = new DefaultListModel<>();
        for (Player player : playersArrayList) {
            listModel.addElement(player);
        }

        return listModel;
    }

    private DefaultListModel<Player> createPlayersModel(ArrayList<Player> players){

        DefaultListModel<Player> listModel = new DefaultListModel<>();
        for (Player player : players) {
            listModel.addElement(player);
        }

        return listModel;
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

    public void setPlayerList(ArrayList<Player> playerList) {

        DefaultListModel<Player> listModel = new DefaultListModel<>();
        for (Player player : playerList) {
            listModel.addElement(player);
        }

        rosterListPlayer.setModel(listModel);
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
        label1 = new JLabel();
        buttonBestRoster = new JButton();
        comboBoxWeek = new JComboBox<>();
        buttonUpdate = new JButton();

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

                //---- label1 ----
                label1.setText("Week : ");

                //---- buttonBestRoster ----
                buttonBestRoster.setText("Best Roster for Week");
                buttonBestRoster.addActionListener(e -> buttonBestRosterActionPerformed(e));

                //---- comboBoxWeek ----
                comboBoxWeek.setModel(new DefaultComboBoxModel<>(new String[] {
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9",
                    "10"
                }));

                //---- buttonUpdate ----
                buttonUpdate.setText("Update");
                buttonUpdate.addActionListener(e -> buttonUpdateActionPerformed(e));

                GroupLayout rosterPanelLayout = new GroupLayout(rosterPanel);
                rosterPanel.setLayout(rosterPanelLayout);
                rosterPanelLayout.setHorizontalGroup(
                    rosterPanelLayout.createParallelGroup()
                        .addGroup(rosterPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addComponent(rosterAddPlayer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(scrollPane4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addComponent(rosterRosterLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rosterComboBox))
                                .addComponent(modifyRoster, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addComponent(rosterPlayerLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(playerComboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBoxWeek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6)
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addComponent(buttonUpdate, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(customSearch, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(buttonBestRoster, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                rosterPanelLayout.setVerticalGroup(
                    rosterPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, rosterPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addComponent(rosterRosterLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rosterPlayerLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerComboBox)
                                .addGroup(GroupLayout.Alignment.TRAILING, rosterPanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(rosterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboBoxWeek, GroupLayout.Alignment.TRAILING)
                                        .addComponent(rosterComboBox, GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(rosterPanelLayout.createParallelGroup()
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(rosterAddPlayer)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(modifyRoster)
                                    .addGap(88, 88, 88))
                                .addGroup(rosterPanelLayout.createSequentialGroup()
                                    .addGroup(rosterPanelLayout.createParallelGroup()
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(rosterPanelLayout.createSequentialGroup()
                                            .addGap(83, 83, 83)
                                            .addComponent(customSearch)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buttonBestRoster)))
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
    private JLabel label1;
    private JButton buttonBestRoster;
    private JComboBox<String> comboBoxWeek;
    private JButton buttonUpdate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
