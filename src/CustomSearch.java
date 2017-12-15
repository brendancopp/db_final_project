import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Mon Dec 11 15:27:57 PST 2017
 */



/**
 * @author Brendan Copp
 */
public class CustomSearch extends JPanel {
    public CustomSearch() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Brendan Copp
        position = new JComboBox<>();
        textFieldName = new JTextField();
        buttonSearch = new JButton();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textFieldTeam = new JTextField();
        radioButtonIsInjured = new JRadioButton();
        label6 = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- position ----
        position.setModel(new DefaultComboBoxModel<>(new String[] {
            "All"
        }));

        //---- buttonSearch ----
        buttonSearch.setText("Search");

        //---- label1 ----
        label1.setText("Position: ");

        //---- label4 ----
        label4.setText("Name:");

        //---- label5 ----
        label5.setText("Team: ");

        //---- radioButtonIsInjured ----
        radioButtonIsInjured.setText("Injured?");

        //---- label6 ----
        label6.setText("Custom Search");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(position, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFieldTeam, GroupLayout.Alignment.LEADING)
                                            .addComponent(textFieldName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(52, 52, 52)
                                    .addComponent(radioButtonIsInjured))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(154, 154, 154)
                                    .addComponent(buttonSearch, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addComponent(label6)))
                    .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label6)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(radioButtonIsInjured))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textFieldTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(70, 70, 70)
                    .addComponent(buttonSearch)
                    .addGap(46, 46, 46))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    void submitSearch(){
        String name = textFieldName.getText();
        String team = textFieldTeam.getText();
        boolean isInjured = radioButtonIsInjured.isSelected();

        //Call resulting stored procedure
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Brendan Copp
    private JComboBox<String> position;
    private JTextField textFieldName;
    private JButton buttonSearch;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JTextField textFieldTeam;
    private JRadioButton radioButtonIsInjured;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
