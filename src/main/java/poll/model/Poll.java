package poll.model;

public class Poll {

    private Long sessionId;
    private String username;
    private int point;

    public Poll(Long sessionId, String username, int point) {
        this.sessionId = sessionId;
        this.username = username;
        this.point = point;
    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setSessionId(Long sessionId){
        this.sessionId=sessionId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
