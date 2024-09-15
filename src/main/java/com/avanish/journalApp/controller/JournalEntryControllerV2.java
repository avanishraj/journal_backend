package com.avanish.journalApp.controller;
import com.avanish.journalApp.entity.JournalEntry;
import com.avanish.journalApp.entity.User;
import com.avanish.journalApp.services.JournalEntryService;
import com.avanish.journalApp.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/avanish")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    private ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> journalEntries = user.getJournalEntries();
        if(journalEntries != null && !journalEntries.isEmpty()){
            return new ResponseEntity<>(journalEntries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{userName}")
    private JournalEntry createEntry(@RequestBody JournalEntry journalEntry, @PathVariable String userName){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry, userName);
        System.out.println("Title: " + journalEntry.getTitle() + ", " + "Content: " + journalEntry.getContent());
        return journalEntry;
    }



    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{userName}/{myId}")
    private String deleteJournalById(@PathVariable ObjectId myId, @PathVariable String userName){
        journalEntryService.deleteById(myId, userName);
        return "journal entry deleted successfully";
    }

    @PutMapping("/id/{userName}/{id}")
    private JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry, @PathVariable String userName){
        JournalEntry oldEntries  = journalEntryService.findById(id).orElse(null);
        if(oldEntries != null){
            oldEntries.setContent(newEntry.getContent());
            oldEntries.setTitle(newEntry.getTitle());
        }
        journalEntryService.saveEntry(oldEntries);
        return oldEntries;
    }
}
