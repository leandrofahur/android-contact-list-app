package com.example.contactlistdemo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    // @NonNull redundant for the auto-generated annotation
    private int id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "phone")
    private String phone;

    // default constructor:
    public Contact() {
        // i'm empty on purpose...
    }

    // constructor for all attributes:
    public Contact(@NonNull String firstName, String lastName, @NonNull String phone) {
        //this.id = id; in this case the id will be auto-generated!!!
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // getters and setters to enable modifications:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
