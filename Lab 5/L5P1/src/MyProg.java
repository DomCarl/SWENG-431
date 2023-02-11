/**
 * @author Stuart Walters
 * @author Robert Myer
 * @author Dominick Carlucci
 *
 * Lab 5 Part 1
 * SWENG 431
 * Due Date: 2/12/23 11:59 pm
 */


public class MyProg
{
    public static void main(String[] args) throws Exception {
        TestCaseGenerator tcg = new TestCaseGenerator();
        tcg.readEquivalenceClasses("/Users/robbiemyers/Local Projects/SWENG-431/Lab 5/L5P1/src/Eq.txt");
        tcg.generateTestCases("/Users/robbiemyers/Local Projects/SWENG-431/Lab 5/L5P1/src/test.txt");
    }
}
