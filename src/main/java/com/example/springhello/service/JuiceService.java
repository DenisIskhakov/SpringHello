package com.example.springhello.service;

import com.example.springhello.model.Juice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service

public class JuiceService {
    public List<Juice> juices = new ArrayList<>();


    public JuiceService(){
        juices.add(new Juice("Apple","Apple jues"));
        juices.add(new Juice("Orange","Orange jues"));
    }
    public List<Juice> getJuice(){
        return juices;
    }
    public Juice addJuice(Juice juice){
        juices.add(juice);
        return juice;
    }
    public Juice getId(int id){
        return juices.get(id);

    }
    public Juice put(int id, Juice juice){
        return juices.set(id,juice);
    }

}
