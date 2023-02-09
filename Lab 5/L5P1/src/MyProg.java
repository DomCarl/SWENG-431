import java.io.*;

public class MyProg
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("src/Eq.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str = br.readLine();
        String[] tokens = new String[0];

        while ((str = br.readLine()) != null)
        {
            tokens = str.split(",|;");
        }

        for (int i = 0; i < tokens.length; i++)
        {
            System.out.println(tokens[i]);
        }
    }

}
