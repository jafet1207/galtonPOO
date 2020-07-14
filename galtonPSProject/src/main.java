
import UI.mainWindow;
import processing.core.*;

public class main extends PApplet {
    
    public static void main(String[] args) {
        //PApplet.main("galtonPSProject");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true); //HACE VISIBLE EL FORM PRINCIPAL
            }
        });
    }
}
