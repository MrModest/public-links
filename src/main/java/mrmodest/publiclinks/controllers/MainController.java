package mrmodest.publiclinks.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class MainController {

    @GetMapping("")
    public String test(){
        return "I'm alive!";
    }

}
