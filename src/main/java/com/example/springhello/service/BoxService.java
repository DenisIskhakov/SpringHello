package com.example.springhello.service;

import com.example.springhello.model.Box;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoxService {
    public List<Box> boxs = new ArrayList<>();

    public BoxService(){
        boxs.add(new Box("Box 1", "10kg"));
        boxs.add(new Box("Box 2","20kg"));
        boxs.add(new Box("Box 3","30kg"));
    }

    public List<Box> getBox() {
        return boxs;
    }
    public Box getAdd(Box box){
        boxs.add(box);
        return box;
    }
    public Box getId(int id){
        return boxs.get(id);

    }
    public String removeId(int id){
        boxs.remove(id);
        return "Remove id = " + id;
    }
    public String removeAll(){
        boxs.removeAll(boxs);
        return "Remove all";
    }
}
