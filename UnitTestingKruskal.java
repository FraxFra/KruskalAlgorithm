import ItalianDistance.*;
import java.io.*;
import java.util.Scanner;

public class UnitTestingKruskal
{
        public static void main(String[] args) throws Exception
        {
                Graph<String,Double> prova = new Graph<String,Double>();
                Graph<String,Double> krusky = new Graph<String,Double>();
                Scanner sc = new Scanner(new File("ItalianDistance/Distanze.csv"));
                sc.useDelimiter(",|\\n");
                while (sc.hasNext())
                {
                        String a = sc.next();
                        String b = sc.next();
                        Double w = Double.parseDouble(sc.next());
                        prova.addEdge(a, b, w);
                }
                krusky = prova.Kruskal();
                System.out.println(krusky.getInfo());
                sc.close();
        }
}
