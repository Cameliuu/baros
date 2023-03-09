package prb2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    String path = "D:\\lucru_java_intellij\\baros\\src\\prb2\\produse.csv";
    try {
        List<Produs> produse = new ArrayList<Produs>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready())
        {
            String linie = br.readLine();
            String[] array = linie.split(",");
            produse.add(new Produs(array[0],Double.parseDouble(array[1].trim()),Integer.parseInt(array[2].trim()), LocalDate.parse(array[3].trim())));
        }
        System.out.println(Produs.Expirate(produse));
        System.out.println("*******************************");
        System.out.println(Produs.getMinimumPricedProducts(produse));
        System.out.println("*******************************");

    }
    catch(Exception e )
    {
        System.out.println(e);
    }
    }
}
