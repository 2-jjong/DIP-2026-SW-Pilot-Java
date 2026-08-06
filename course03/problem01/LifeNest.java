package course03.problem01;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    private List<Organism> organismList;

    public LifeNest() {
        this.organismList = new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이(가) 추가되었습니다.");
    }

    public void removeOrganism(Organism organism) {
        if (organismList.remove(organism)) {
            System.out.println("[LifeNest] " + organism.getName() + "이(가) 삭제되었습니다.");
        }
    }

    public void displayAllOrganisms() {
        System.out.println("\n전체 동식물 목록 출력:");
        for (int i = 0; i < organismList.size(); i++) {
            System.out.print((i + 1) + ". ");
            organismList.get(i).displayInfo();
        }
        System.out.println();
    }

    public void searchOrganismByName(String name) {
        boolean found = false;
        for (Organism o : organismList) {
            if (o.getName().equals(name)) {
                System.out.print("[검색 결과] ");
                o.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("[검색 결과] '" + name + "' 정보를 찾을 수 없습니다.");
        }
    }
}
