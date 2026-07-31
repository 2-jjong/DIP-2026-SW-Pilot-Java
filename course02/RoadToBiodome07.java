package course02;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome07 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        String fullInput = String.join(" ", args);
        String cleanInput = fullInput.replace("[", " ")
                .replace("]", " ")
                .replace("\"", " ")
                .replace(",", " ")
                .trim();

        if (cleanInput.isEmpty()) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        String[] tokens = cleanInput.split("\\s+");

        for (String token : tokens) {
            if (containsNumber(token)) {
                System.out.println("입력 데이터에 숫자가 존재합니다. 동물 이름만 입력해주세요.");
                return;
            }
        }

        List<String> uniqueNameList = new ArrayList<>();
        List<Integer> frequencyList = new ArrayList<>();

        for (String token : tokens) {
            if (token.isEmpty())
                continue;

            int index = uniqueNameList.indexOf(token);
            if (index == -1) {
                uniqueNameList.add(token);
                frequencyList.add(1);
            } else {
                frequencyList.set(index, frequencyList.get(index) + 1);
            }
        }

        int n = uniqueNameList.size();
        if (n == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        String[] names = uniqueNameList.toArray(new String[0]);
        int[] freqs = new int[n];
        for (int i = 0; i < n; i++) {
            freqs[i] = frequencyList.get(i);
        }

        selectionSort(names, freqs);

        System.out.println(String.join(", ", names));
    }

    private static boolean containsNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static void selectionSort(String[] names, int[] freqs) {
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            int bestIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shouldSwap(names[bestIdx], freqs[bestIdx], names[j], freqs[j])) {
                    bestIdx = j;
                }
            }

            String tempName = names[i];
            names[i] = names[bestIdx];
            names[bestIdx] = tempName;

            int tempFreq = freqs[i];
            freqs[i] = freqs[bestIdx];
            freqs[bestIdx] = tempFreq;
        }
    }

    private static boolean shouldSwap(String name1, int freq1, String name2, int freq2) {
        if (freq2 > freq1) {
            return true;
        } else if (freq2 == freq1) {
            return name2.compareTo(name1) < 0;
        }

        return false;
    }
}
