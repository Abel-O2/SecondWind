package secondwind;

public interface SQL {
    public void addPlayer(String Name/*,int Score*/);
    public void fetch();
    public void alert(String msg);
    public void alert(String msg, String title);
}
