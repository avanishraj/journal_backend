package com.avanish.journalApp.controller;
import com.avanish.journalApp.entity.JournalEntry;
import com.avanish.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/avanish")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    private List<JournalEntry> getAll() {
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping
    private JournalEntry createEntry(@RequestBody JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry);
        System.out.println("Title: " + journalEntry.getTitle() + ", " + "Content: " + journalEntry.getContent());
        return journalEntry;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    private String deleteJournalById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return "journal entry deleted successfully";
    }

    @PutMapping("/id/{id}")
    private JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
        JournalEntry oldEntries  = journalEntryService.findById(id).orElse(null);
        if(oldEntries != null){
            oldEntries.setContent(newEntry.getContent());
            oldEntries.setTitle(newEntry.getTitle());
        }
        journalEntryService.saveEntry(oldEntries);
        return oldEntries;
    }
}
