package course03.problem03;

public class BiodomeFamily03 {
    public static void main(String[] args) {
        LifeNest nest = new LifeNest();

        // 2가지 동물 객체와 2가지 식물 객체 생성
        Animal penguin = new Animal("펭귄", "동물", "남극", "육식", "물고기");
        Animal koala = new Animal("코알라", "동물", "호주", "초식", "유칼립투스");
        Plant cactus = new Plant("선인장", "식물", "사막", "11월", "열매 있음");
        Plant peppermint = new Plant("페퍼민트", "식물", "정원", "7월", "열매 없음");

        // 생성된 동식물을 저장소 목록에 저장
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);

        // 모든 동식물 출력
        nest.displayAll();

        // 1가지 동물과 1가지 식물 삭제
        nest.removeOrganism(koala);
        nest.removeOrganism(cactus);

        // 모든 동식물 출력
        nest.displayAll();
    }
}
