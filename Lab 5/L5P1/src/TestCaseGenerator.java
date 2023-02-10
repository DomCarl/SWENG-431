import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class TestCaseGenerator {
    private List<List<Pair<Integer, Integer>>> equivalenceClasses;

    public TestCaseGenerator() {
        equivalenceClasses = new ArrayList<>();
    }

    public int check(int val, int inputNumber) {
        List<Pair<Integer, Integer>> inputEquivalenceClasses = equivalenceClasses.get(inputNumber);
        for (int i = 0; i < inputEquivalenceClasses.size(); i++) {
            Pair<Integer, Integer> equivalenceClass = inputEquivalenceClasses.get(i);
            if (val >= equivalenceClass.getKey() && val <= equivalenceClass.getValue()) {
                return i + 1;
            }
        }
        return -1;
    }

    public int foo(int... inputs) {
        int sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += check(inputs[i], i);
        }
        return sum;
    }

    public void readEquivalenceClasses(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            List<Pair<Integer, Integer>> inputEquivalenceClasses = new ArrayList<>(); // This list represents a line
            String[] equivalenceClassStrings = line.split(";"); // Split each equivalence class line into their pairs
            for (String equivalenceClassString : equivalenceClassStrings) { // Loop through the pairs
                String[] range = equivalenceClassString.trim().split(","); // Split each pair into their two numbers
                int lower = Integer.parseInt(range[0].trim()); // Convert to integer and remove space
                int upper = Integer.parseInt(range[1].trim()); // Convert to integer and remove space
                inputEquivalenceClasses.add(new Pair<>(lower, upper)); // Add pair to line
            }
            equivalenceClasses.add(inputEquivalenceClasses); // Add line to all equivalence classes
        }
        br.close();
    }

    public void generateTestCases(String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)); // Open new FileWriter
        Random rand = new Random(); // Generate random number
        for (int i = 0; i < 100; i++) { // Generates 100 test cases
            int[] inputs = new int[equivalenceClasses.size()]; // Create an array of inputs as large as the number of equivalence classes (5)
            for (int j = 0; j < inputs.length; j++) { // Loop through number of equivalence classes (5 loops)
                List<Pair<Integer, Integer>> inputEquivalenceClasses = equivalenceClasses.get(j); // Get line i
                Pair<Integer, Integer> equivalenceClass = inputEquivalenceClasses.get(rand.nextInt(inputEquivalenceClasses.size())); // Choose a random equivalence class from that line
                inputs[j] = equivalenceClass.getKey() + rand.nextInt(equivalenceClass.getValue() - equivalenceClass.getKey() + 1); // Pick a random number for that equivalence class
            }
            int output = foo(inputs); // Pass in your 5 inputs to foo (which also calls check)
            bw.write(Arrays.toString(inputs).replace("[", "").replace("]", "").replace(" ", "") + "," + output); // write inputs and
            bw.newLine();
        }
        bw.close();
    }
}