import java.util.Collections;
import java.util.List;

public class BubbleSort {
    public static List<Integer> bubbleSort(List<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    Collections.swap(numbers, j, j + 1);
                }
            }
        }
        return numbers;
    }
}

