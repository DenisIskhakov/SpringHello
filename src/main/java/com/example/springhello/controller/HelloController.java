package com.example.springhello.controller;

import com.example.springhello.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@RestController // rest controller -обрабатывает http -запросы
public class HelloController {
    ArrayList<User> users = new ArrayList();

    public HelloController() {
        users.add(new User("name1", "blog1"));
        users.add(new User("name2", "blog2"));
        users.add(new User("name3", "blog3"));
    }
    @GetMapping ("/hello") // http запрос методом get-заставит отработать метод hello()
    // http://localhost:8080/ - это http запрос методом get()

    public String heloo(){
        return "hello";
    }
    @GetMapping("/world")
    public String hello1(){
        return "world";
    }
    @GetMapping("/juice")
    public String apple(){
        return "apple";
    }
    @GetMapping("/users")
    // http://localhost:8080/user  (это запрос)
    public List<User> getUsers(){
        return List.copyOf(users);// создали новую immutabl. коллекции на основе обычной коллекции(mutable)
        // [{"name":"name1","blog":"blog1"},{"name":"name2","blog":"blog2"},{"name":"name3","blog":"blog3"}]
    }
    @Async
    @GetMapping("/users/{id}")
    public CompletableFuture<User> getUser(@PathVariable int id){
        return  CompletableFuture.completedFuture( users.get(id));

    }

    @GetMapping("{firstname}/{lastname}")
    public String greeting(@PathVariable String firstname, @PathVariable String lastname) {
        return "Hello, " + firstname + " " + lastname + "!";
    }
    @GetMapping("/map/{firstname}/{lastname}")
    public String greeting(@PathVariable Map<String, String> pathVars) {
        return "Hello, " + pathVars.get("firstname") + " " + pathVars.get("lastname") + "!";
    }
//    POST http://localhost:8080/users / Url
//    Content-Type: application/json  / header
//    {"name":"name1","blog":"blog1"} / body
    @PostMapping("/users")
    public User postG(@RequestBody User user){
        users.add(user);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public String delUser(@PathVariable Integer id){
        users.remove(users.get(id));
        return "Users with id " + id + " removed";
    }
    @DeleteMapping("/users")
    public String delAll(){
        users.removeAll(users);
        return "All user remove";
    }






}
