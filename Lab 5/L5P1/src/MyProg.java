import java.io.*;

public class MyProg
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("src/Eq.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        String[] tokens;
        String[] equiv = new String[0];

        while ((str = br.readLine()) != null)
        {
            tokens = str.replace(",", "").split("[;]");

            for (String s : tokens)
            {
                System.out.println(s.trim());
            }
        }
    }
}
