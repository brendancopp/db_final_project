import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Mon Dec 11 15:11:49 PST 2017
 */



/**
 * @author Brendan Copp
 */
public class NewRoster extends JPanel {
    public NewRoster() {
        initComponents();
        setRosterList();

    }

    //LIST HANDELERS
    public void setRosterList() {

        FantasyModel fm = FantasyModel.getFantasyModel();
        ArrayList<Roster> rosters = fm.getAllRosters();

        DefaultListModel<Roster> listModel = new DefaultListModel<>();
        for (Roster roster : rosters) {
            listModel.addElement(roster);
        }

        list1.setModel(listModel);

    }

    public void addRoster(){
        String s = textField1.getText();
        //Call resulting query
    }

    public void deleteRoster(){
        FantasyModel fm = FantasyModel.getFantasyModel();
        list1.getModel().getElementAt(list1.getSelectedIndex());

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Brendan Copp
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        textField1 = new JTextField();
        button2 = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- label1 ----
        label1.setText("Modify Roster");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("Delete Roster");

        //---- button2 ----
        button2.setText("Add Roster");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                    .addGap(212, 212, 212))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(51, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(262, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addGap(12, 12, 12))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Brendan Copp
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
