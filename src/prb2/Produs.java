package prb2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produs {
    private String nume;
    private double pret;
    private int cantitate;
    private LocalDate localDate;
    public static double incasari;
    public Produs(String nume, double pret, int cantitate, LocalDate localDate)
    {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.localDate = localDate;
    }
    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getNume() {
        return nume;
    }
    public static List<Produs> Expirate(List<Produs> produse)
    {
        List<Produs> expirate = new ArrayList<Produs>();
        for(Produs p: produse)
        {
            if(!Period.between(p.localDate,LocalDate.now()).isNegative())
                expirate.add(p);
        }
        return expirate;
    }


    public static double getMinimumPrice(List<Produs> produse)
    {
        double minimum = 999999;
        for(Produs p: produse)
            if(p.pret < minimum)
                minimum = p.pret;
        return minimum;
    }
    public static void saveProduse(List<Produs> produse)
    {
        System.out.println("Introduceti pretul minim");
        Scanner scan = new Scanner(System.in);
        double min = scan.nextDouble();
        scan.nextLine();
        String out = "out.txt";
        try{
            FileWriter fw = new FileWriter(out);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Produs p: produse)
                if(p.getPret() < min)
                {
                    bw.append(p.toString());
                    bw.flush();
                }
                bw.close();
        }

        catch(Exception e){
            System.out.println(e);
    }
    }
    public static List<Produs> getMinimumPricedProducts(List<Produs> produse)
    {
        List<Produs> pm = new ArrayList<Produs>();
        double minimum = getMinimumPrice(produse);
        for(Produs p: produse)
            if(p.getPret() == minimum)
                pm.add(p);
        return pm;

    }
    public boolean Vinde(List<Produs> produse, int cant)
    {
        if(this.cantitate > cant) {
            this.cantitate-=cant;
            incasari+=this.pret*cant    ;
            if(this.cantitate == 0)
                produse.remove(this);
            return true;
        }
        return false;
    }
    @Override
    public String toString()
    {
        return "Nume: " + this.nume +"\nPret: " + this.pret +"\nCantitate: " + this.cantitate + "\nData expirarii: " + this.localDate+"\n";
    }
}
