package course03.problem08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private LocalDateTime sessionDate;
    private String location;
    private List<Member> attendees;
    private Member organizer;
    private SessionStatus status;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy년 M월 d일");

    public Session(LocalDateTime sessionDate, String location, Member organizer) {
        this.sessionDate = sessionDate;
        this.location = location;
        this.organizer = organizer;
        this.attendees = new ArrayList<>();
        this.status = SessionStatus.OPEN;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getAttendees() {
        return attendees;
    }

    public Member getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Member organizer) {
        this.organizer = organizer;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    public void addAttendee(Member member) {
        if (!attendees.contains(member)) {
            attendees.add(member);
        }
    }

    public String getFormattedDate() {
        return sessionDate.format(FORMATTER);
    }

    public void displayInfo() {
        System.out.println(getFormattedDate() + ", " + location + ", " + attendees + ", " + organizer.getName() + ", "
                + status.getStatusName());
    }

    @Override
    public String toString() {
        return getFormattedDate() + ", " + location + ", " + attendees + ", " + organizer.getName() + ", "
                + status.getStatusName();
    }
}
