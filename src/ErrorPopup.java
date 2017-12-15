/**
 * Created by brendan on 12/6/2017.
 */

import javax.swing.JOptionPane;

public class ErrorPopup
{

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}

