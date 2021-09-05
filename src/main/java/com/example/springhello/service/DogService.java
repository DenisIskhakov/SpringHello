package com.example.springhello.service;


import com.example.springhello.model.Dog;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DogService {
    private List<Dog> dogs = new ArrayList<>();

    public DogService(){
       dogs.add(new Dog("Bobik",2));
       dogs.add(new Dog("Reks",5));
       dogs.add(new Dog("Garry",7));
       dogs.add(new Dog("Teylor",10));
    }
    @Async("Executor 2") // работает в фоном потоке(переопр. с помощью executor)
    public CompletableFuture<List<Dog>> getDog(){
        System.out.println(Thread.currentThread().getName());
        return CompletableFuture.completedFuture(dogs);
    }

    public Dog addDog(Dog dog){
        dogs.add(dog);
        return dog;
    }
    public Dog update(int id,Dog dog){
        return dogs.set(id,dog);
    }
    public Dog getId(int id){
        return dogs.get(id);
    }
    public String removeDogId(int id){
        dogs.remove(dogs.get(id));
        return "remove Dog-id ";
    }
    public String removeAll(){
        dogs.removeAll(dogs);
        return "remove all dogs ";
    }
}
