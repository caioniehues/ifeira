package fag.ifeira.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class RegistroController
{

    @GetMapping()
    public String fodase(){
        return "chupa meu cu";
    }

}
