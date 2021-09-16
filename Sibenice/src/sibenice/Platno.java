package sibenice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Platno extends JPanel{
    //Vlastnosti
    ArrayList<BufferedImage> obrazky;
    int aktualniObrazek;
    private int narocnost;
    //Konstruktor
    public Platno() {
        setSize(400,400);
        this.narocnost = 2;
        this.obrazky = new ArrayList<>();
        for(int i=0;i<9;i++){
            File f = new File("src/obrazky/sib"+i+".png");
            try {
                BufferedImage im = ImageIO.read(f);
                this.obrazky.add(im);
            } catch (IOException ex) {
                Logger.getLogger(Platno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.aktualniObrazek = 0;
        
    }
    
    //Pomocne metody
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 400, 400);
        try {
            g.drawImage(obrazky.get(aktualniObrazek), 0, 0, this);
        } catch (Exception e) {
        }
    }
    
    //Metody rozhraní
    public void novaHra(){
        aktualniObrazek = 0;
        repaint();
    }
    public void vykresliDalsiObrazek(){
        if(aktualniObrazek < obrazky.size()-1){
            aktualniObrazek++;
            if(aktualniObrazek == obrazky.size()){
                System.out.println("Konec hry");
            }else{
                repaint();
            }
        }
       }
    public void konec(Graphics g){
        

    }
    public void setObtiznost(int Narocnost){
        this.narocnost = Narocnost;
    }
    public int getObtiznost(){
        return narocnost;
    }    
}
