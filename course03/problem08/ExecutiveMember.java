package course03.problem08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExecutiveMember extends Member implements SessionOrganizer, SessionManager {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy년 M월 d일");

    public ExecutiveMember(String name, LocalDateTime joinDate) {
        super(name, joinDate);
    }

    public ExecutiveMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
    }

    public ExecutiveMember(String name, LocalDateTime joinDate, String skillLevel, String region) {
        super(name, joinDate, skillLevel, region);
    }

    @Override
    public Session openSession(Club club, LocalDateTime date, String location) {
        Session session = new Session(date, location, this);
        club.addSession(session);
        System.out.println(getName() + "이 " + session.getFormattedDate() + ", " + location + "에 연습 세션을 오픈했습니다.");
        return session;
    }

    @Override
    public void postponeSession(Club club, LocalDateTime oldDate, String location, LocalDateTime newDate) {
        Session session = club.findSession(oldDate, location);
        if (session != null) {
            session.setSessionDate(newDate);
            System.out.println(getName() + "이 " + newDate.format(FORMATTER) + ", " + location + "에 연습 세션을 연기했습니다.");
        }
    }

    @Override
    public void cancelSession(Club club, LocalDateTime date, String location) {
        Session session = club.findSession(date, location);
        if (session != null) {
            session.setStatus(SessionStatus.CANCELLED);
            System.out.println(date.format(FORMATTER) + ", " + location + " 연습 세션이 취소되었습니다.");
        }
    }

    @Override
    public void approveMember(OtherRegionMember member, Session session) {
        session.addAttendee(member);
        System.out.println(getName() + " 운영진이 " + member.getName() + " (타지역) 회원의 연습 참가를 승인했습니다.");
    }
}
