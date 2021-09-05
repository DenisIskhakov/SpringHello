package com.example.springhello.service;

import com.example.springhello.model.Dog;
import com.example.springhello.model.Phone;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PhoneService {
    private List<Phone> phones = new ArrayList<>();

    public PhoneService(){
        phones.add(new Phone("Samsung","S10"));
        phones.add(new Phone("Nokia","3310"));
        phones.add(new Phone("Siemens","i310"));
        phones.add(new Phone("Motorolla","RV3"));
    }
    @Async("Executor = 1")
    public CompletableFuture<List <Phone>> getPhone(){
        System.out.println(Thread.currentThread().getName());
        return CompletableFuture.completedFuture(phones);
    }

    public Phone update(int id, Phone phone){
        return phones.set(id,phone);
    }
    public Phone addPhone(Phone phone){
        phones.add(phone);
        return phone;
    }
    public Phone getId(int id){
        return phones.get(id);

    }
    public String removePhoneId(int id){
        phones.remove(getId(id));
        return "remove Phone - id = " + id;
    }
    public String removeAll(){
        phones.removeAll(phones);
        return "Phones remove all";
    }
}
