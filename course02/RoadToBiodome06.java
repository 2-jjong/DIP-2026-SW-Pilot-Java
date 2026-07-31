package course02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class RoadToBiodome06 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        String fullInput = String.join(" ", args);
        List<int[]> arrays = parseInputArrays(fullInput);

        if (arrays == null || arrays.size() < 2) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        int[] arr1 = arrays.get(0);
        int[] arr2 = arrays.get(1);

        if (!isValid(arr1) || !isValid(arr2)) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        double mean = calculateMean(arr1, arr2);

        double median = findMedianSortedArrays(arr1, arr2);

        String formattedMean = String.format(Locale.US, "%.1f", mean);
        String formattedMedian = String.format(Locale.US, "%.1f", median);

        System.out.println("Mean : " + formattedMean + ", Median : " + formattedMedian);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int low = 0;
        int high = n;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (n + m + 1) / 2 - partitionX;

            double maxLeftX = (partitionX == 0) ? Double.NEGATIVE_INFINITY : nums1[partitionX - 1];
            double minRightX = (partitionX == n) ? Double.POSITIVE_INFINITY : nums1[partitionX];

            double maxLeftY = (partitionY == 0) ? Double.NEGATIVE_INFINITY : nums2[partitionY - 1];
            double minRightY = (partitionY == m) ? Double.POSITIVE_INFINITY : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((n + m) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                } else {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }

    public static double calculateMean(int[] arr1, int[] arr2) {
        double sum = 0;
        for (int num : arr1) {
            sum += num;
        }
        for (int num : arr2) {
            sum += num;
        }

        int totalLen = arr1.length + arr2.length;
        if (totalLen == 0)
            return 0;

        return sum / totalLen;
    }

    private static boolean isValid(int[] arr) {
        for (int val : arr) {
            if (val < 0) {
                return false;
            }
        }

        return true;
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
