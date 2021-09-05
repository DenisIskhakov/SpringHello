package com.example.springhello.service;

import com.example.springhello.model.People;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    private List<People> peoples = new ArrayList<>();

    public PeopleService(){
        peoples.add(new People("Alex",10));
        peoples.add(new People("Andrey",20));
        peoples.add(new People("Lora",30));
        peoples.add(new People("Pasha",40));


    }
}
