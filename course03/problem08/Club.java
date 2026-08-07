package course03.problem08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members;
    private List<Session> sessions;

    public Club() {
        this.members = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public Session findSession(LocalDateTime date, String location) {
        for (Session s : sessions) {
            if (s.getSessionDate().toLocalDate().equals(date.toLocalDate()) && s.getLocation().equals(location)) {
                return s;
            }
        }
        return null;
    }

    public List<Session> searchSessionsByDate(LocalDateTime date) {
        List<Session> result = new ArrayList<>();
        for (Session s : sessions) {
            if (s.getSessionDate().toLocalDate().equals(date.toLocalDate())) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Session> searchSessionsByStatus(SessionStatus status) {
        List<Session> result = new ArrayList<>();
        for (Session s : sessions) {
            if (s.getStatus() == status) {
                result.add(s);
            }
        }
        return result;
    }
}
