package devops.exam.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
public class TestController {

    @GetMapping
    public ResponseEntity<?> teste(){
        return ResponseEntity.ok("Ok");
    }
}
