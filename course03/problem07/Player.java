package course03.problem07;

public class Player {
    private Song currentSong;
    private int volume = 1;

    public Player() {
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        int maxVolume = (currentSong instanceof AnimalSong) ? 5 : 50;

        if (volume < 0 || volume > maxVolume) {
            System.out.println("허용된 볼륨 범위를 벗어났습니다. (설정 가능한 최대 볼륨: " + maxVolume + ")");
            return;
        }

        this.volume = volume;
        System.out.println("볼륨을 " + volume + "으로 설정합니다.");
    }

    public void play(Song song) {
        if (song == null) {
            System.out.println("재생할 수 없습니다.");
            return;
        }

        this.currentSong = song;

        if (song instanceof AnimalSong && volume > 5) {
            this.volume = 5;
            System.out.println("볼륨을 5로 설정합니다.");
        }

        System.out.println("\"" + song.getInfo() + "\" 재생합니다.");
    }
}
