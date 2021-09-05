package com.example.springhello.controller;

import com.example.springhello.model.Dog;
import com.example.springhello.model.Phone;
import com.example.springhello.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@AllArgsConstructor
@RequestMapping("/phone")
public class PhoneController {
    PhoneService phoneService;

    @GetMapping
    public CompletableFuture<List<Phone>> getPhone(){
        System.out.println("_______ " + Thread.currentThread().getName());
        phoneService.getPhone();
        phoneService.getPhone();
        phoneService.getPhone();
        phoneService.getPhone();
        return phoneService.getPhone();
    }
    @PostMapping
    public Phone post(@RequestBody Phone phone){
        return phoneService.addPhone(phone);
    }
    @PutMapping("/{id}")
    public Phone put(@PathVariable int id, @RequestBody Phone phone){
        return phoneService.update(id,phone);
    }
    @GetMapping("/{id}")
    public Phone getId(int id){
        return phoneService.getId(id);
    }
    @DeleteMapping("/{id}")
    public String removePhoneId(int id){
        phoneService.removePhoneId(id);
        return "Phone remove id = " + id;
    }
    @DeleteMapping
    public String removeAll(){
        phoneService.removeAll();
        return "Phone remove all";
    }


}
