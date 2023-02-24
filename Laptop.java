import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;


public class Laptop {

    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> new_data = new ArrayList<String>();
    private static File file = new File("\\data.txt");
    private Scanner scan_new = new Scanner(System.in);
    private Scanner scan_flow = new Scanner(System.in);

    private static ArrayList<String> get_data()
    {
        String foo = "";
        ArrayList<String> bar = new ArrayList<String>();
        try (Scanner sc = new Scanner(file)) {
                sc.useDelimiter(";");
                foo = sc.next();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(foo);
        Collections.addAll(bar, foo);
        return bar;
    }
    
    private static void store_data()
    {

    }

    private void get_new_data()
    {

    }

    private void search(ArrayList<String> dt, int col)
    {
        
    }

    public static void main(String[] args) {
        String foo = "";
        Laptop lp = new Laptop();
        lp.data = Laptop.get_data();
        System.out.println(lp.data);
    }
}
