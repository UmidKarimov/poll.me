package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poll")
public class PollController {

    @GetMapping("")
    public ResponseEntity getSession(){
        try{
           return ResponseEntity.ok().body("1");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Server not working!");
        }
    }

}
