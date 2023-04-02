package com.example.dictionary;

import java.util.HashMap;

public class Translation {
    private String Name;
    private HashMap <String,String> Translation = new HashMap <> ();

    public Translation(String Name ,HashMap<String, String> translation ) {
        Translation = translation;
        this.Name  = Name;
    }


    public HashMap<String, String> getTranslation() {
        return Translation;
    }

    public void setTranslation(HashMap<String, String> translation) {
        Translation = translation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
