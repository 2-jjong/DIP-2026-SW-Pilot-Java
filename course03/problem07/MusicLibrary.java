package course03.problem07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicLibrary {
    private List<Song> songList;

    public MusicLibrary() {
        this.songList = new ArrayList<>();
    }

    public void addSong(Song song) {
        for (Song s : songList) {
            if (s.getTitle().equals(song.getTitle())) {
                System.out.println("이미 존재하는 노래 제목입니다: " + song.getTitle());
                return;
            }
        }
        songList.add(song);
        System.out.println("새로운 노래 \"" + song.getInfo() + "\" 추가되었습니다.");
    }

    public void removeSong(String title) {
        Song target = null;
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
                target = s;
                break;
            }
        }

        if (target == null) {
            System.out.println("삭제하려는 노래를 찾을 수 없습니다: " + title);
            return;
        }

        songList.remove(target);
        System.out.println("노래 \"" + target.getInfo() + "\" 삭제되었습니다.");
    }

    public List<Song> searchForHumans() {
        List<Song> results = new ArrayList<>();
        for (Song s : songList) {
            if (s instanceof ManagerSong) {
                results.add(s);
            }
        }

        if (results.isEmpty()) {
            System.out.println("사람을 위한 음악 검색 결과가 없습니다.");
        }

        return results;
    }

    public List<Song> searchByAnimal(String animal) {
        List<Song> results = new ArrayList<>();
        for (Song s : songList) {
            if (s instanceof AnimalSong) {
                AnimalSong animalSong = (AnimalSong) s;
                if (animalSong.getTargetAnimal().equals(animal)) {
                    results.add(animalSong);
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("'" + animal + "'을(를) 위한 음악 검색 결과가 없습니다.");
        }

        return results;
    }

    public List<Song> searchByGenre(String genre) {
        List<Song> results = new ArrayList<>();
        for (Song s : songList) {
            if (s instanceof ManagerSong) {
                ManagerSong managerSong = (ManagerSong) s;
                if (managerSong.getGenre().equals(genre)) {
                    results.add(managerSong);
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("장르 '" + genre + "' 검색 결과가 없습니다.");
        }

        return results;
    }

    public void shufflePlaylist() {
        Collections.shuffle(songList);
        System.out.println("재생 리스트가 랜덤하게 섞였습니다.");
    }

    public List<Song> getSongList() {
        return songList;
    }
}
