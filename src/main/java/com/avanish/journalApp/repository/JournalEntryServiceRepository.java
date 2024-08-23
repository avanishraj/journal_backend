package com.avanish.journalApp.repository;

import com.avanish.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryServiceRepository extends MongoRepository<JournalEntry, ObjectId> {
}
    