package personal_dashboard.backend.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TopicController {

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        System.out.println("*********************************");
        System.out.println("getAllTopics() method has been executed.");
        System.out.println("*********************************");
        return Arrays.asList(
        new Topic("Spring", "Spring Framework", "Spring Framework Description"),
        new Topic("Java", "Core Java", "Core Java Description"),
        new Topic("JavaScript", "JavaScript", "JavaScript Description")
        );
    }
}
