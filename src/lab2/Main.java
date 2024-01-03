import java.util.*;

// Interface for sorting algorithms
interface Sorter {
    ArrayList<Integer> sort(ArrayList<Integer> input);
}

// BubbleSorter class implementing the Sorter interface
class BubbleSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();
        long startTime = System.currentTimeMillis();

        // Bubble sort algorithm
        for (int i = 0; i < n - 1; i++) {
            // Check if the execution time exceeds 40000 ms
            if (System.currentTimeMillis() - startTime > 40000){
                break;
            }

            for (int j = 0; j < n - i - 1; j++) {
                // Swap elements if they are in the wrong order
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

        return input;
    }
}

// ShellSorter class implementing the Sorter interface
class ShellSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();

        // Shell sort algorithm
        for (int gap = n / 2; 0 < gap; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = input.get(i);
                int j;
                for (j = i; j >= gap && input.get(j - gap) > temp; j -= gap) {
                    input.set(j, input.get(j - gap));
                }
                input.set(j, temp);
            }
        }

        return input;
    }
}

// MergeSorter class implementing the Sorter interface
class MergeSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();

        // Merge sort algorithm
        if (n < 2){
            return input;
        }

        int mid = n / 2;
        ArrayList<Integer> left = new ArrayList<>(input.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(input.subList(mid, n));

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    // Helper method to merge two sorted arrays
    private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }
}

// QuickSorter class implementing the Sorter interface
class QuickSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        quickSort(input, 0, input.size() - 1);
        return input;
    }

    // Quick sort algorithm
    private void quickSort(ArrayList<Integer> input, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(input, low, high);
            quickSort(input, low, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, high);
        }
    }

    // Helper method to partition the array
    private int partition(ArrayList<Integer> input, int low, int high) {
        int pivot = input.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input.get(j) < pivot) {
                i++;
                int temp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, temp);
            }
        }

        int temp = input.get(i + 1);
        input.set(i + 1, input.get(high));
        input.set(high, temp);

        return i + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Generate random arrays and perform sorting for different sizes
        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println("Number of elements: " + count);
            ArrayList<Integer> input = generateRandomArray(count);

            // Perform sorting for different sorting types
            for (SortingType type : SortingType.values()) {
                System.out.println("Sorting type: " + type);
                Sorter sorter = getSorter(type);

                // Measure the execution time of the sorting algorithm
                ArrayList<Integer> sorted = sorterTime(input, sorter);

                // Print the sorted array if the size is small
                if (count <= 50) {
                    System.out.println("Sorted array: " + sorted);
                }
                else {
                    System.out.println("Sorted array: " + sorted.subList(0, 50));
                }
            }
        }
    }

    // Generate a random array of given size
    private static ArrayList<Integer> generateRandomArray(int count) {
        ArrayList<Integer> array = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            array.add(rand.nextInt(count));
        }
        return array;
    }

    // Get the sorter based on the sorting type
    private static Sorter getSorter(SortingType type) {
        return switch (type) {
            case BUBBLE -> new BubbleSorter();
            case SHELL -> new ShellSorter();
            case MERGE -> new MergeSorter();
            case QUICK -> new QuickSorter();
            default -> throw new IllegalArgumentException("Unknown sorting type");
        };
    }

    // Measure the execution time of the sorting algorithm
    private static ArrayList<Integer> sorterTime(ArrayList<Integer> input, Sorter sorter){
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sorted = sorter.sort(new ArrayList<>(input));
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        if (executionTime < 40000) {
            System.out.println("Execution time: " + executionTime + " ms");
        } else {
            System.out.println("The method was interrupted, execution took more than 40000 ms");
        }
        return sorted;
    }

    // Enum for different sorting types
    enum SortingType {
        BUBBLE, SHELL, MERGE, QUICK
    }
}