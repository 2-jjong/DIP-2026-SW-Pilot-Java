package course05.problem04;

import java.util.Scanner;

public class BiodomeForever04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnvironmentManager manager = new EnvironmentManager();

        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");
        System.out.println();

        while (true) {
            System.out.println("1. 새로운 환경 데이터 입력");
            System.out.println();
            System.out.println("2. 모든 환경 데이터 조회");
            System.out.println();
            System.out.println("3. 날짜별 산소 수치만 조회");
            System.out.println();
            System.out.println("4. 프로그램 종료");
            System.out.print("선택: ");

            String choiceInput = scanner.nextLine().trim();
            int choice = 0;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("잘못된 메뉴 선택입니다. 1~4 사이의 숫자를 입력해주세요.");
                System.out.println();
                continue;
            }

            if (choice == 1) {
                System.out.println();
                System.out.print("온도를 입력하세요: ");
                String tempStr = scanner.nextLine().trim();
                double temp;
                try {
                    temp = Double.parseDouble(tempStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값입니다. 온도는 숫자로 입력해주세요.");
                    System.out.println();
                    continue;
                }

                System.out.print("습도를 입력하세요: ");
                String humStr = scanner.nextLine().trim();
                double hum;
                try {
                    hum = Double.parseDouble(humStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값입니다. 습도는 숫자로 입력해주세요.");
                    System.out.println();
                    continue;
                }

                System.out.print("산소 농도를 입력하세요: ");
                String oxyStr = scanner.nextLine().trim();
                double oxy;
                try {
                    oxy = Double.parseDouble(oxyStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값입니다. 산소 농도는 숫자로 입력해주세요.");
                    System.out.println();
                    continue;
                }

                System.out.print("측정 장소를 입력하세요: ");
                String location = scanner.nextLine().trim();

                EnvironmentData data = new EnvironmentData(temp, hum, oxy, location);
                manager.saveEnvironmentData(data);
                System.out.println();

            } else if (choice == 2) {
                manager.displayAllData();
                System.out.println();

            } else if (choice == 3) {
                manager.displayOxygenData();
                System.out.println();

            } else if (choice == 4) {
                System.out.println();
                System.out.println("프로그램을 종료합니다. 감사합니다.");
                break;
            } else {
                System.out.println();
                System.out.println("잘못된 메뉴 선택입니다. 1~4 사이의 숫자를 입력해주세요.");
                System.out.println();
            }
        }

        scanner.close();
    }
}
