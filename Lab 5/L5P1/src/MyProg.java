/**
 * @author Stuart Walters
 * @author Robert Myer
 * @author Dominick Carlucci
 *
 * Lab 5 Part 1
 * SWENG 431
 * Due Date: 2/12/23 11:59 pm
 */

import java.io.*;
import java.util.Random;

public class MyProg
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("src/Eq.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str = "";


        while ((str = br.readLine()) != null)
        {

            String[] equiv = str.split("\n");
            Random rand = new Random();

            FileWriter fw = new FileWriter("src/test.txt");

            for (int i = 0; i < 100; i ++)
            {
                int sum = 0;

                for (int j = 0; j < equiv.length; j++)
                {
                    String[] tokens = equiv[j].replace(" ", "").split(";");
                    int index = rand.nextInt(tokens.length);

                    String[] vals = tokens[index].replace(" ", "").split(",");

                    int lowVal = Integer.parseInt(vals[0]);
                    int highVal = Integer.parseInt(vals[1]);

                    int val = rand.nextInt((highVal - lowVal) + 1) + lowVal;
                    sum += check(val, tokens[j]);

                    System.out.println(sum + "\n");
                }
            }
        }
    }

    private static int check(int val, String equiv)
    {
        String[] tokens = equiv.replace(" ", "").split(";");

        for (int i = 0; i < tokens.length; i++)
        {
            String[] vals = tokens[i].replace(" ", "").split(",");

            int lowVal = Integer.parseInt(vals[0]);
            int highVal = Integer.parseInt(vals[1]);

            if (val >= lowVal && val <= highVal)
            {
                return i + 1;
            }
        }

        return -1;
    }
}
