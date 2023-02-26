import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class Laptop {

    private static File file = new File("data.txt");
    private static List<String> columnList = Arrays.asList("NAME","CPU","GPU","RAM","Storage","Screen size","Color","Weight","Price (Rub)");
    private static int mod = 9;
    // data.txt file has 9 columns
    // mod(9)

    private static ArrayList<String> get_data()
    {
        String foo = "";
        int i = 0;
        ArrayList<String> bar = new ArrayList<String>();
        try (FileReader fr = new FileReader(file)) {
            while((i = fr.read()) != -1)
                foo += (char)i;
        } catch (Exception e) {
            System.out.println("ERROR ON READING DARA");
        }
        Collections.addAll(bar, foo.split(";"));
        return bar;
    }
    
    private static void store_data(ArrayList<String> dt) 
    {
        String foo = String.join(";", dt);
        try (FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.println(foo);
        }
        catch (Exception e) {
            System.out.println("ERROR ON WRITING TO FILE!");
        }
    }

    private static ArrayList<String> get_new_data(ArrayList<String> dt)
    {
        String foo = "";
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter a new entry to the data.");
            for(int i = 0; i < mod; i++)
            {
                System.out.println("Enter " + columnList.get(i));
                dt.add(scan.nextLine());
            }
            System.out.println("New entry is:\n" + dt + "\nCorrect Y/N ?");
            foo = scan.nextLine();
            if(foo.equals("Y") || foo.equals("y"))
                break;
        }
        scan.close();
        return dt;
    }

    private static void search (ArrayList<String> dt)
    {
        String foo = "";
        Scanner scan = new Scanner(System.in);
        int ch = 0;
        int line = 0;
        System.out.println(dt);
        while (true)
        {
            ch = 0;
            System.out.println("Possible search qualities.\n" + columnList);
            foo = scan.nextLine();
            for(int i = 0; i < columnList.size(); i++)
                if(foo.equals(columnList.get(i)))
                {
                    ch++;
                    line = i;
                }
            if(ch != 0)
            {
                System.out.println("Enter valid search word");
                foo = scan.nextLine();
                for(int i = mod; i < dt.size(); i += mod)
                {
                    if(foo.equals(dt.get(i + (line - mod))))
                    {
                        System.out.println(foo);
                        for(int j = i - mod; j < i + mod; j++)
                        {
                            System.out.print(dt.get(j) + ";");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String foo = "";
        Laptop.search(get_data());
    }
}
