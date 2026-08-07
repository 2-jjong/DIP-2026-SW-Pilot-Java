package course03.problem08;

import java.time.LocalDateTime;

public class NewMember extends Member {
    public NewMember(String name, LocalDateTime joinDate) {
        super(name, joinDate);
    }

    public NewMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
    }

    public NewMember(String name, LocalDateTime joinDate, String skillLevel, String region) {
        super(name, joinDate, skillLevel, region);
    }
}
