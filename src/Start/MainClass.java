package Start;

import BLL.ClientBLL;
import GUI.GUI;
import Model.Client;

import java.util.List;

/**
 * Clasa MainClass creeaza fereastra principala si o face vizibila.
 */
public class MainClass {
    public static void main(String[] args)
    {
        GUI gui = new GUI();
        gui.getFrame().setVisible(true);

    }
}
