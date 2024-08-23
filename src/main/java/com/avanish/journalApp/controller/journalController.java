//package com.avanish.journalApp.controller;
//
//import com.avanish.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////@RestController
////@RequestMapping("/avanish")
//public class journalController {
//    private final Map<Long, JournalEntry> journalEntryMap = new HashMap<>();
//
//    @GetMapping
//    private List<JournalEntry> getAll() {
//        return new ArrayList<>(journalEntryMap.values());
//    }
//
//    @PostMapping
//    private String createEntry(@RequestBody JournalEntry journalEntry){
//        journalEntryMap.put(Long.valueOf(journalEntry.getId()), journalEntry);
//        return "journal entry added successfully";
//    }
//
//    @GetMapping("/id/{myId}")
//    private JournalEntry getJournalById(@PathVariable Long myId){
//        return journalEntryMap.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    private JournalEntry deleteJournalById(@PathVariable Long myId){
//        return journalEntryMap.remove(myId);
//    }
//
//    @PutMapping("/id/{id}")
//    private JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry journalEntry){
//        return journalEntryMap.put(id, journalEntry);
//    }
//}
