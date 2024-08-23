package com.avanish.journalApp.services;

import com.avanish.journalApp.entity.JournalEntry;
import com.avanish.journalApp.repository.JournalEntryServiceRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryServiceRepository journalEntryServiceRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryServiceRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryServiceRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryServiceRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryServiceRepository.deleteById(id);
    }
}
