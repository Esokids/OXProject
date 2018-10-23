public class User {
    private String id;
    private String username;
    private String pass;
    private String nickname;
    private int scoreWin;
    private int scoreDraw;
    private int scoreLose;

    User(String id, String username, String password,String nickname, int scoreWin, int scoreDraw, int scoreLose){
        this.id = id;
        this.username = username;
        this.pass = password;
        this.nickname = nickname;
        this.scoreWin = scoreWin;
        this.scoreDraw = scoreDraw;
        this.scoreLose = scoreLose;
    }

    User(String username, String password){
        this.username = username;
        this.pass = password;
    }

    User(String username){
        this.username = username;
    }

    User(String username, String password, String nickname){
        this.username = username;
        this.pass = password;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScoreWin() {
        return scoreWin;
    }

    public void setScoreWin(int scoreWin) {
        this.scoreWin = scoreWin;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }

    public void setScoreDraw(int scoreDraw) {
        this.scoreDraw = scoreDraw;
    }

    public int getScoreLose() {
        return scoreLose;
    }

    public void setScoreLose(int scoreLose) {
        this.scoreLose = scoreLose;
    }
}
