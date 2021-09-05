package com.example.springhello.controller;

import com.example.springhello.model.Cat;
import com.example.springhello.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/cat")
public class CatController {
    CatService catService;
    @GetMapping
    public List<Cat> getCat(){
        return catService.getCat();
    }
    @PostMapping
    public Cat post(@RequestBody Cat cat){
        return catService.addCat(cat);
    }
    @PutMapping
    public Cat put(@PathVariable int id,@RequestBody Cat cat){
        return catService.put(id,cat);
    }
    @GetMapping("/{id}")
    public Cat getId(@PathVariable int id){
        return catService.getId(id);
    }
    @DeleteMapping("/{id}")
    public String removeCat(@PathVariable int id){
        catService.removeCat(id);
        return "Remove Cat-id " + id;
    }
    @DeleteMapping
    public String removeAll(){
        catService.removeAll();
        return "Remove All";
    }
}
