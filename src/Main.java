import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String source = "/Users/aakriti.thapa/Desktop/cmps 390/number.txt";
        try {
            // Read data from the file
            List<Integer> numbers = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(source));
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
            br.close();

            // Tree Sort
            List<Integer> treeSortedNumbers = TreeSort.treeSort(new ArrayList<>(numbers));
            BufferedWriter treeWriter = new BufferedWriter(new FileWriter("tree_sorted.txt"));
            for (int number : treeSortedNumbers) {
                treeWriter.write(number + "\n");
            }
            treeWriter.close();

            // Bubble Sort
            List<Integer> bubbleSortedNumbers = BubbleSort.bubbleSort(new ArrayList<>(numbers));
            BufferedWriter bubbleWriter = new BufferedWriter(new FileWriter("bubble_sorted.txt"));
            for (int number : bubbleSortedNumbers) {
                bubbleWriter.write(number + "\n");
            }
            bubbleWriter.close();

            System.out.println("Tree Sort Compares: " + (numbers.size() - 1)); // Assumes each insertion requires one compare
            System.out.println("Bubble Sort Compares: " + ((numbers.size() - 1) * (numbers.size() - 1) / 2)); // Bubble sort worst-case compares

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
