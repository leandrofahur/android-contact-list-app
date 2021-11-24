package com.example.contactlistdemo.dao;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.contactlistdemo.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    /*
     * A DAO is an extensible interface where we implement the CRUD. Keep the method names simple and explicit for a clean and intuitive interface!!!
     */

    // Insertion

    @Insert(onConflict = IGNORE)
    void insertContact(Contact contact);

    @Insert(onConflict = IGNORE)
    void insertAllContacts(List<Contact> contactList);

    // Deletion

    @Delete
    void deleteContact(Contact contact);

    // in the ui there will be a delete contact list btn
    @Query("DELETE FROM contacts")
    void deleteAllContacts();

    // Selection:

    // in the ui there will be a show all btn
    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getAllContacts();

    // in the ui there will be a search btn that will search by name
    @Query("SELECT * FROM contacts WHERE first_name=:firstName")
    List<Contact> getContactByName(String firstName);


}
