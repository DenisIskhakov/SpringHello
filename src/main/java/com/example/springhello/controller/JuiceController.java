package com.example.springhello.controller;

import com.example.springhello.model.Juice;
import com.example.springhello.service.JuiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("/juice")
public class JuiceController {
    JuiceService juiceService;

    @GetMapping
    public List<Juice> getJuice(){
        return juiceService.getJuice();
    }
    @GetMapping("/{id}")
    public Juice getId(@PathVariable int id){
        return juiceService.getId(id);
    }

    @PostMapping
    public Juice post(@RequestBody Juice juice){
        return juiceService.addJuice(juice);
    }
    @PutMapping
    public Juice put(@PathVariable int id, @RequestBody Juice juice){
        return juiceService.put(id,juice);
    }
}
