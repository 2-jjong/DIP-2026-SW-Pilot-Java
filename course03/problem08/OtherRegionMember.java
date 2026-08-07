package course03.problem08;

import java.time.LocalDateTime;

public class OtherRegionMember extends Member {
    public OtherRegionMember(String name, LocalDateTime joinDate, String skillLevel, String region) {
        super(name, joinDate, skillLevel, region);
    }

    public void requestApproval(Session session) {
        System.out.println("타지역 회원 " + getName() + "이(가) 연습 세션 참가를 승인 신청했습니다.");
    }
}
