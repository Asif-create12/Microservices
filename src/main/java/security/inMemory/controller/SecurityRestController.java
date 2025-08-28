package security.inMemory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityRestController {
    @GetMapping("/message")
    public String getMessage(){
        return "hi";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/chameli")
    public String chamely(){
        return "chamely";
    }
}
