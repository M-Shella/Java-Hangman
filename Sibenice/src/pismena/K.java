package pismena;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class K extends JButton{
    public K() {
        this.setFont(new Font("Tahoma" , 1 , 15));
        this.setBackground(new Color(200,200,200));
        this.setPreferredSize(new Dimension(48, 40));
        this.setText("K");
    } 
}