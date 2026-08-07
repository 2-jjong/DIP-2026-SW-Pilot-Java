package course03.problem08;

import java.time.LocalDateTime;

public class RegularMember extends Member implements SessionOrganizer {
    public RegularMember(String name, LocalDateTime joinDate) {
        super(name, joinDate);
    }

    public RegularMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
    }

    public RegularMember(String name, LocalDateTime joinDate, String skillLevel, String region) {
        super(name, joinDate, skillLevel, region);
    }

    @Override
    public Session openSession(Club club, LocalDateTime date, String location) {
        Session session = new Session(date, location, this);
        club.addSession(session);
        System.out.println(getName() + "이 " + session.getFormattedDate() + ", " + location + "에 연습 세션을 오픈했습니다.");
        return session;
    }
}
