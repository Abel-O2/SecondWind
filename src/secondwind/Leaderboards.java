package secondwind;

public class Leaderboards {
    String name;
    int score;

    public Leaderboards(String name, int score){
        this.name=name;
        this.score=score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
  
}
