package sibenice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Slovnik {
    //Vlastnosti
    private sibenice.Platno platno2;
        ArrayList<String> slova = new ArrayList();
    File adresar;
    Random rand = new Random();
    int rCislo;
    
    //Konstruktor
    public Slovnik(String cesta){
        adresar = new File(cesta);
        try {
            FileReader fr = new FileReader(adresar);
            BufferedReader br =  new BufferedReader(fr);
            String retezec;
            while((retezec = br.readLine()) != null){
                slova.add(retezec);
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slovnik.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Slovnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Pomocne metody
    public void tiskPole(){
        for (int i = 0; i < slova.size(); i++) {
            System.out.println(slova.get(i));
        }
    }
    
    //Metody rozhraní
    public void vlozSlovo(String slovo){
        boolean pomoc = false;
        for(int i=0; i<slova.size();i++){
                if(slova.get(i).equals(slovo)){
                    pomoc = true;
                }
            }
        try {
            FileWriter fw = new FileWriter(adresar, true);
            BufferedWriter bw =  new BufferedWriter(fw);
            
            if(pomoc == false){
                slova.add(slovo.toLowerCase());
                bw.write(slovo.toLowerCase()+"\n");
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String vyberSlovo(){  
        String slovo = null;
        try {
            rCislo = rand.nextInt(slova.size());
            FileReader fr = new FileReader(adresar);
            slovo = slova.get(rCislo);  
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Slovnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slovo;
    }
}
