package com.avanish.journalApp.services;

import com.avanish.journalApp.entity.JournalEntry;
import com.avanish.journalApp.entity.User;
import com.avanish.journalApp.repository.UserServiceRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserService {
    @Autowired
    private UserServiceRepository userServiceRepository;
    public void saveEntry(User user){
        userServiceRepository.save(user);
    }

    public List<User> getAllJournalEntries() {
        return userServiceRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userServiceRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userServiceRepository.deleteById(id);
    }

}
