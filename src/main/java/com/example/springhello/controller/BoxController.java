package com.example.springhello.controller;

import com.example.springhello.model.Box;
import com.example.springhello.service.BoxService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/box")
public class BoxController {
    BoxService boxService;

    @GetMapping
    public List<Box> getBox(){
        return boxService.getBox();
    }
    @PostMapping
    public Box post(@RequestBody Box box){
        return boxService.getAdd(box);
    }

    @GetMapping("/{id}")
    public Box getId(@PathVariable int id) {
        return boxService.getId(id);
    }

    @DeleteMapping("/{id}")
    public String removeDogId(@PathVariable int id) {
        boxService.removeId(id);
        return "Remove id = " + id;
    }

    @DeleteMapping
    public String removeAll() {
        boxService.removeAll();
        return "Remove all";
    }
}
