package course03.problem02;

public class BiodomeFamily02 {
    public static void main(String[] args) {
        LifeNest nest = new LifeNest();

        // 2가지 동물 객체와 2가지 식물 객체 생성
        Organism penguin = new Organism("펭귄", "동물", "남극");
        Organism koala = new Organism("코알라", "동물", "호주");
        Organism cactus = new Organism("선인장", "식물", "사막");
        Organism peppermint = new Organism("페퍼민트", "식물", "정원");

        // 생성된 동식물을 저장소 목록에 저장
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);

        // 모든 동식물 출력
        nest.displayAllOrganisms();

        // 1가지 동물과 1가지 식물 삭제
        nest.removeOrganism(koala);
        nest.removeOrganism(cactus);

        // 동물의 서식지 변경 (펭귄: 남극 -> 해변)
        penguin.setHabitat("해변");

        // 모든 동식물 출력
        nest.displayAllOrganisms();

        // 특징과 수명이 추가된 객체 생성 및 관리
        Organism elephant = new Organism("코끼리", "동물", "습지대", "지능이 높다", "60년");
        Organism lilac = new Organism("라일락", "식물", "온대 지역", "향기가 강하다", "100년");

        nest.addOrganism(elephant);
        nest.addOrganism(lilac);

        nest.displayAllOrganisms();

        // 코끼리의 특징 변경
        elephant.setCharacteristic("코가 길다");

        nest.displayAllOrganisms();
    }
}
