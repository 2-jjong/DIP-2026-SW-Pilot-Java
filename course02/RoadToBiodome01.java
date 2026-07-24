package course02;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome01 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
            return;
        }

        String fullInput = String.join(" ", args)
                .replace("[", "")
                .replace("]", "")
                .replace(",", " ");

        String[] numberStrs = fullInput.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String numberStr : numberStrs) {
            if (numberStr.isEmpty())
                continue;

            try {
                int num = Integer.parseInt(numberStr);
                if (num < 0 || num > 1000) {
                    System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                    return;
                }

                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                return;
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
            return;
        }

        int singleNumber = -1;

        for (int num : numbers) {
            if (countFrequency(numbers, num) == 1) {
                singleNumber = num;
                break;
            }
        }

        if (singleNumber != -1) {
            System.out.println(singleNumber);
        } else {
            System.out.println("한 번만 등장하는 숫자가 없습니다.");
        }
    }

    public static int countFrequency(List<Integer> list, int target) {
        int count = 0;

        for (int num : list) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }
}
