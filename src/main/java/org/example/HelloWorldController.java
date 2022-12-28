package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class HelloWorldController {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    HelloWorldRepository helloWorldRepository;
    //create a customer
    @PostMapping("/savehelloworld")
    public  String saveHelloWorldMessage(@RequestBody HelloWorld helloWorld){
        helloWorldRepository.save(helloWorld);
        return "helloworld message saved";
    }


    //gethelloworld
    @GetMapping("/gethelloworld")
    public List<HelloWorld> getHelloWorldMessages(){
        List<HelloWorld> helloWorldList = new LinkedList<>();

        Iterable<HelloWorld> iterable = helloWorldRepository.findAll();
        iterable.forEach(helloWorldList::add);

        return helloWorldList;
    }

}
