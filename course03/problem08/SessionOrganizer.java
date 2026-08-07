package course03.problem08;

import java.time.LocalDateTime;

public interface SessionOrganizer {
    Session openSession(Club club, LocalDateTime date, String location);
}
