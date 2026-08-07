package course03.problem08;

import java.time.LocalDateTime;

public class Member {
    private String name;
    private LocalDateTime joinDate;
    private String skillLevel;
    private String region;

    public Member(String name, LocalDateTime joinDate) {
        this(name, joinDate, "초급", "본부");
    }

    public Member(String name, LocalDateTime joinDate, String skillLevel) {
        this(name, joinDate, skillLevel, "본부");
    }

    public Member(String name, LocalDateTime joinDate, String skillLevel, String region) {
        this.name = name;
        this.joinDate = joinDate;
        this.skillLevel = skillLevel;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return name;
    }
}
