package com.avanish.journalApp.services;
import com.avanish.journalApp.entity.JournalEntry;
import com.avanish.journalApp.entity.User;
import com.avanish.journalApp.repository.JournalEntryServiceRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryServiceRepository journalEntryServiceRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userService.findByUserName(userName);
            JournalEntry saved =  journalEntryServiceRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry: ", e);
        }
    }
    public void saveEntry(JournalEntry journalEntry){
        journalEntryServiceRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryServiceRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryServiceRepository.findById(id);
    }
    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryServiceRepository.deleteById(id);
    }
}
