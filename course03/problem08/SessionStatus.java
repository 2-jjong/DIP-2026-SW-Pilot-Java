package course03.problem08;

public enum SessionStatus {
    OPEN("개설"),
    CANCELLED("취소");

    private final String statusName;

    SessionStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
