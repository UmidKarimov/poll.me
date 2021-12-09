package poll.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import poll.model.Poll;

@Component
public class PollDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PollDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long getSessionNewPoll(){
        return jdbcTemplate.queryForObject("SELECT POLL_SEQ.NEXTVAL FROM DUAL", new Object[]{},Long.class);
    }

    public void save (Poll poll){
        jdbcTemplate.update("INSERT INTO POLL VALUES (?, ?, ?)",poll.getSessionId(),poll.getUsername(),poll.getPoint());
    }

    public double getResult(Long sessionId){
        Long count;
        Long sum;

        count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM POLL WHERE SESSION_ID = ?",new Object[]{sessionId},Long.class);
        sum = jdbcTemplate.queryForObject("SELECT SUM(POINT) FROM POLL WHERE SESSION_ID = ?",new Object[]{sessionId},Long.class);
        return (double)sum/(double)count;
    }
}
