import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        

       getParabole();
    }
    public static List<Parabola> getParabole()
    {
        List<Parabola> parabole = new ArrayList<Parabola>();
        String path = "D:\\lucru_java_intellij\\baros\\in.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready())
            {
                String textParabola = br.readLine();
                int a = Integer.parseInt(textParabola.split(",")[0]);
                int b = Integer.parseInt(textParabola.split(",")[1]);
                int c = Integer.parseInt(textParabola.split(",")[2]);
                parabole.add(new Parabola(a,b,c));
            }
            for(Parabola p: parabole)
                System.out.println(p);
        }
        catch(Exception e)
        {
            System.out.println(e);
            }
        return parabole;
        }

    }

