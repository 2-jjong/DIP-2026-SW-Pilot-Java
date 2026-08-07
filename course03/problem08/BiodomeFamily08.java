package course03.problem08;

import java.time.LocalDateTime;

public class BiodomeFamily08 {
    public static void main(String[] args) {
        Club club = new Club();

        // 새로운 멤버 생성 (운영진 1명, 일반 멤버 2명, 신규 멤버 2명)
        LocalDateTime now = LocalDateTime.of(2130, 1, 1, 0, 0);

        ExecutiveMember john = new ExecutiveMember("John", now, "상급");
        System.out.println("John이 운영진으로 가입되었습니다.");

        RegularMember jane = new RegularMember("Jane", now, "중급");
        RegularMember doe = new RegularMember("Doe", now, "중급");
        System.out.println("Jane과 Doe가 일반 멤버로 가입되었습니다.");

        NewMember amy = new NewMember("Amy", now);
        NewMember leo = new NewMember("Leo", now);
        System.out.println("Amy와 Leo가 신규 멤버로 가입되었습니다.");

        club.addMember(john);
        club.addMember(jane);
        club.addMember(doe);
        club.addMember(amy);
        club.addMember(leo);

        System.out.println();

        // 운영진이 연습 세션 개설
        LocalDateTime initialDate = LocalDateTime.of(2130, 9, 12, 0, 0);
        Session session = john.openSession(club, initialDate, "도메 스타디움");

        System.out.println();

        // 일반 멤버 1명과 신규 멤버 1명이 연습 참가
        session.addAttendee(jane);
        session.addAttendee(amy);
        System.out.println("Jane과 Amy가 연습 세션에 참가합니다.");

        System.out.println();

        // 개설 상태인 연습 정보 출력
        session.displayInfo();

        System.out.println();

        // 연습 날짜를 일주일 뒤로 연기
        LocalDateTime newDate = initialDate.plusWeeks(1);
        john.postponeSession(club, initialDate, "도메 스타디움", newDate);

        System.out.println();

        // 운영진이 개설된 연습을 취소
        john.cancelSession(club, newDate, "도메 스타디움");
    }
}
