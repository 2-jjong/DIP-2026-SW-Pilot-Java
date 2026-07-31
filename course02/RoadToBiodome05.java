package course02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadToBiodome05 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        String fullInput = String.join(" ", args);
        int[] combined = parseAndCombine(fullInput);

        if (combined == null || combined.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        quickSort(combined, 0, combined.length - 1);

        System.out.println(Arrays.toString(combined));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static int[] parseAndCombine(String input) {
        String cleanInput = input.replace("[", " ").replace("]", " ").replace(",", " ").trim();
        String[] numberStrs = cleanInput.split(" ");

        List<Integer> list = new ArrayList<>();
        for (String numberStr : numberStrs) {
            if (numberStr.isEmpty()) {
                continue;
            }

            try {
                int val = Integer.parseInt(numberStr);
                if (val < 0) {
                    return null;
                }

                list.add(val);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        if (list.isEmpty()) {
            return null;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
