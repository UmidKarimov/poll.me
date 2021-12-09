package poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poll.DAO.PollDAO;
import poll.model.Poll;

@Controller
@RequestMapping("/poll")
public class PollController {

    private final PollDAO pollDAO;

    @Autowired
    public PollController(PollDAO pollDAO){
        this.pollDAO = pollDAO;
    }


    @GetMapping
    public ResponseEntity index(){
        try{
           return ResponseEntity.ok().body("Welcome to Poll App!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Server not working!");
        }
    }

    @GetMapping("/new")
    public ResponseEntity getNewSessionId(){
        return ResponseEntity.ok().body(pollDAO.getSessionNewPoll().toString());
    }

    @PostMapping("{id}/{user}/{point}")
    public ResponseEntity save(@PathVariable("id") Long id, @PathVariable("user") String user, @PathVariable("point") int point ){
        try{
            pollDAO.save(new Poll(id,user,point));
            return ResponseEntity.ok().body("Thanks for voting!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Sorry, try again later!");
        }
    }

    @GetMapping("result/{id}")
    public ResponseEntity getResult(@PathVariable("id") Long id){
        return ResponseEntity.ok().body("Result of voting session "+(String.format("%.2f",pollDAO.getResult(id))));
    }

}
