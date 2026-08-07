package course03.problem06;

import java.util.LinkedList;
import java.util.List;

public class BiodomeFamily06 {
    public static void main(String[] args) {
        // 5가지 동물 객체 생성
        List<Animal> animals = new LinkedList<>();
        animals.add(new Animal("제니", AnimalType.MONKEY, 4));
        animals.add(new Animal("고먀", AnimalType.ELEPHANT, 4));
        animals.add(new Animal("타이", AnimalType.TIGER, 9));
        animals.add(new Animal("로아", AnimalType.RHINO, 5));
        animals.add(new Animal("바비", AnimalType.DEER, 7));

        // 초기 동물 순서 출력
        System.out.println(animals);

        // 안전한 순서로 재배열
        List<Animal> safeOrder = arrangeSafely(animals);

        if (safeOrder != null) {
            System.out.println("→ " + safeOrder);
        } else {
            System.out.println("안전하게 재배열할 수 있는 순서가 존재하지 않습니다.");
        }
    }

    // 동물들의 순서를 안전하게 재배열하는 로직
    public static List<Animal> arrangeSafely(List<Animal> original) {
        List<Animal> result = new LinkedList<>(original);
        if (isSafeOrder(result)) {
            return result;
        }

        if (permuteAndCheck(result, 0)) {
            return result;
        }

        return null;
    }

    // 순열을 생성하며 첫 번째로 발견되는 안전한 배치 탐색
    private static boolean permuteAndCheck(List<Animal> list, int k) {
        for (int i = k; i < list.size(); i++) {
            swap(list, i, k);
            if (isSafeOrder(list)) {
                return true;
            }
            if (permuteAndCheck(list, k + 1)) {
                return true;
            }
            swap(list, i, k);
        }

        return false;
    }

    private static void swap(List<Animal> list, int i, int j) {
        Animal temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // 배열 순서의 안전성 검사
    // 규칙 1: 호랑이는 사슴 뒤에 올 수 없다
    // 규칙 2: 5살 이하 코끼리는 호랑이 앞에 올 수 없다
    public static boolean isSafeOrder(List<Animal> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            Animal current = list.get(i);

            if (current.getType() == AnimalType.TIGER) {
                for (int j = 0; j < i; j++) {
                    if (list.get(j).getType() == AnimalType.DEER) {
                        return false;
                    }
                }
            }

            if (current.getType() == AnimalType.ELEPHANT && current.getAge() <= 5) {
                for (int j = i + 1; j < n; j++) {
                    if (list.get(j).getType() == AnimalType.TIGER) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
