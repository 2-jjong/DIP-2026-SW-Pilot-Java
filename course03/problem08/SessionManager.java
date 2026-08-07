package course03.problem08;

import java.time.LocalDateTime;

public interface SessionManager {
    void cancelSession(Club club, LocalDateTime date, String location);

    void postponeSession(Club club, LocalDateTime oldDate, String location, LocalDateTime newDate);

    void approveMember(OtherRegionMember member, Session session);
}
