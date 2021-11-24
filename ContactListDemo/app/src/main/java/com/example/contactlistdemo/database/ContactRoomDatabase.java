package com.example.contactlistdemo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contactlistdemo.dao.ContactDao;
import com.example.contactlistdemo.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactRoomDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();
    private static final int NUMBER_OF_THREADS = 4;

    // singleton pattern:
    private static volatile ContactRoomDatabase INSTANCE;

    // push to a background thread...
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ContactRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (ContactRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ContactRoomDatabase.class, "contact_list_database").build();
                }
            }
        }

        return INSTANCE;
    }
}
