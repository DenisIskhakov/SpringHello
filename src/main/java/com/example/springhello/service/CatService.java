package com.example.springhello.service;

import com.example.springhello.model.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {
    private List<Cat> cats = new ArrayList<>();

    public CatService() {
        cats.add(new Cat("Cat1", 1));
        cats.add(new Cat("Cat2", 2));
        cats.add(new Cat("Cat3", 3));
    }
    public List<Cat> getCat(){

        return cats;
    }
    public Cat addCat(Cat cat){
        cats.add(cat);
        return cat;
    }
    public Cat put(int id, Cat cat){
        return cats.set(id,cat);
    }
    public String removeCat(int id){
        cats.remove(cats.get(id));
        return "Remove Cat";
    }
    public String removeAll(){
        cats.removeAll(cats);
        return "Remove All";
    }
    public Cat getId(int id){
        return cats.get(id);
    }
}
