package personal_dashboard.backend.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Hello {
    @GetMapping("/hello")
    public String sayHi(){
        System.out.println("*********************************");
        System.out.println("sayHi() method has been executed.");
        System.out.println("*********************************");
        return "Hi.";
    }
}
