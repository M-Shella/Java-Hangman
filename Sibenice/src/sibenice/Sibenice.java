package sibenice;

import javax.swing.SwingUtilities;

public class Sibenice {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                View okno = new View();
                View2 okno2 = new View2();
                okno.setVisible(true);
                okno2.setVisible(false);
                Slovnik slovnik = new Slovnik("src/slova.txt");
                slovnik.tiskPole();
            }
        });
    }
    
}
