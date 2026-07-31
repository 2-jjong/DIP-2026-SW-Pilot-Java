package course02;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome04 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        String fullInput = String.join(" ", args);
        List<int[]> arrayList = parseInputArrays(fullInput);

        if (arrayList.isEmpty()) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        if (arrayList.size() > 1) {
            List<String> medians = new ArrayList<>();
            for (int[] arr : arrayList) {
                selectionSort(arr);
                double median = calculateMedian(arr);
                medians.add(formatNumber(median));
            }

            System.out.println(String.join(", ", medians));
        } else {
            int[] arr = arrayList.get(0);
            selectionSort(arr);

            double average = calculateAverage(arr);
            double median = calculateMedian(arr);

            System.out.println("평균값 : " + formatNumber(average) + ", 중앙값 : " + formatNumber(median));
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static double calculateAverage(int[] arr) {
        if (arr.length == 0)
            return 0;

        double sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return sum / arr.length;
    }

    public static double calculateMedian(int[] arr) {
        if (arr.length == 0)
            return 0;

        int n = arr.length;
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }

    public static String formatNumber(double val) {
        if (val == (long) val) {
            return String.valueOf((long) val);
        } else {
            return String.valueOf(val);
        }
    }

    private static List<int[]> parseInputArrays(String input) {
        List<int[]> list = new ArrayList<>();
        int start = 0;

        while ((start = input.indexOf("[", start)) != -1) {
            int end = input.indexOf("]", start);
            if (end == -1)
                break;

            String content = input.substring(start + 1, end);
            int[] parsed = parseSingleArray(content);
            if (parsed.length > 0) {
                list.add(parsed);
            }

            start = end + 1;
        }

        return list;
    }

    private static int[] parseSingleArray(String str) {
        String[] numberStrs = str.replace(",", " ").trim().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String numberStr : numberStrs) {
            if (numberStr.isEmpty()) {
                continue;
            }

            list.add(Integer.parseInt(numberStr));
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
