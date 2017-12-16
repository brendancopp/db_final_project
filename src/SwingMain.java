/**
 * Created by brendan on 11/26/2017.
 */
import java.awt.*;
import javax.swing.*;


public class SwingMain implements Runnable {

    private static SwingMain mSM;
    private static PlayerGui mPlayerGui;

    //Singleton Query
    public static SwingMain getSwingMain(){
        if (mSM == null){
            //mQI = new QueryInterface("user", "pwd");
            mSM = new SwingMain();     //Fake DB
            return mSM;
        }
        else
            return mSM;
    }

    public static PlayerGui getPlayerGui(){
        if (mPlayerGui == null){
            mPlayerGui = new PlayerGui();
            return mPlayerGui;
        }
        else
            return mPlayerGui;
    }

    @Override
    public void run() {
        // Create the window
        JFrame mainFrame = new JFrame("Fantasy Football Drafter - By Brendan Copp & Ben Seeley");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a layout manager so that the button is not placed on top of the label
        mainFrame.setLayout(new FlowLayout());

        mPlayerGui = new PlayerGui();

        // Add a label and a button
        mainFrame.add(mPlayerGui);

        // Arrange the components inside the window
        mainFrame.pack();

        //mPlayerGui.setRosterListPlayer("Default");
        mPlayerGui.initData();

        // By default, the window is not visible. Make it visible.
        mainFrame.setVisible(true);

    }

    public void openModifyRoster(){
        //1. Create the frame.
        JFrame newRosterFrame = new JFrame("Modify Roster");
        //modifyRoster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        newRosterFrame.setLayout(new FlowLayout());

        NewRoster newRosterComponent = new NewRoster();
        newRosterFrame.add(newRosterComponent);

        //4. Size the frame.
        newRosterFrame.pack();

        //5. Show it.
        newRosterFrame.setVisible(true);
    }

    public void openCustomSearch(){
        //1. Create the frame.
        JFrame customSearchFrame = new JFrame("Custom Search");
        //modifyRoster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        customSearchFrame.setLayout(new FlowLayout());

        CustomSearch customSearchComponent = new CustomSearch();
        customSearchFrame.add(customSearchComponent);

        //4. Size the frame.
        customSearchFrame.pack();

        //5. Show it.
        customSearchFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingMain se = getSwingMain();
        // Schedules the application to be run at the correct time in the event queue.
        SwingUtilities.invokeLater(se);
    }

}