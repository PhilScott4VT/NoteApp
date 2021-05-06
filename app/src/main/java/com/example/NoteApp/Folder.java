package com.example.NoteApp;

import android.content.Context;

import java.util.HashMap;
import java.util.Set;

public class Folder {
    private HashMap<String, Object> folderInformation;

    public Folder(int noteID, Context applicationContext){

        SQLiteHelper database = new SQLiteHelper(applicationContext);
        folderInformation = database.fetchFolder(noteID);
    }

    public String getName(){ return (String)folderInformation.get("name"); }
    public String getPassword(){ return (String)folderInformation.get("password"); }
    public Integer getID(){ return (int)folderInformation.get("folderID"); }

    static int addFolder(String folderName, String folderPassword, Context applicationContext){
        SQLiteHelper database = new SQLiteHelper(applicationContext);
        // This returns the ID of the most recently added folder, so we can then add it to the ArrayAdapter.
        return database.addFolder(folderName, folderPassword);
    }
    static void deleteFolder(int folderID, Context applicationContext){
        SQLiteHelper database = new SQLiteHelper(applicationContext);
        database.deleteFolder(folderID);
        database.close();
    }

}