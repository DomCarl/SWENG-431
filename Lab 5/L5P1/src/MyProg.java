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
    public static int region, high, low, guess, sum;
    public static void main(String[] args) throws Exception
    {
//        File file = new File("src/Eq.txt");
//        File output = new File("src/test.txt");
//
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedWriter buffR = new BufferedWriter(new FileWriter(output));
//
//        String str = "";
//        Random rand = new Random(System.currentTimeMillis());
//        sum = 0;
//        guess = rand.nextInt(30)+1;
//
//        while ((str = br.readLine()) != null)
//        {
//            String[] equiv = str.split("\n");
//            for(String z : equiv){
//                String[] line = z.replace(" ", "").split("[;,]");
//                int[] test = new int[line.length];
//                for(int i = 0; i < line.length; i++){
//                    test[i] = Integer.parseInt(line[i]);
//                }
//                foo(test);
//            }
//        }
//        br.close();
//        buffR.close();
        TestCaseGenerator tcg = new TestCaseGenerator();
        tcg.readEquivalenceClasses("/Users/robbiemyers/Local Projects/SWENG-431/Lab 5/L5P1/src/Eq.txt");
        tcg.generateTestCases("/Users/robbiemyers/Local Projects/SWENG-431/Lab 5/L5P1/src/test.txt");
    }

    private static int check(int val) // per line total
    {
            if (val >= low && val <= high)
            {
                return region;
            }

           else
            {
                return 0;
            }
    }

    private static int foo(int... args){ // line level
        for(int i = 0; i < args.length; i+=2){
            region = (i/2) + 1;
            System.out.println("Region: " + ((i / 2) + 1));
            low = args[i];
            high = args[i+1];
            sum += check(guess);
            System.out.println("low: " + low);
            System.out.println("high: " + high);
            System.out.println("guess: " + guess);
        }
        System.out.println("sum: " + sum);

        return sum;
    }
}
