package com.example.dictionary;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TEIParser {

    public static HashMap<String,String> Parsing(int Selected) {
        String[] fileNames = {"eng-ell.txt", "eng-fra.txt", "eng-swe.txt", "eng-tur.txt", "fra-eng.txt", "ita-deu.txt", "ita-eng.txt","spa-eng.txt","swe-eng.txt","tur-deu.txt","tur-eng.txt"};
        HashMap<String, String>[] maps = new HashMap[11];
        for (int i = 0; i < 11; i++) {
            maps[i] = new HashMap<>();
        }

        try {
            // Define file names and corresponding HashMaps

            // Loop through files and read data into HashMaps
            for (int i = 0; i < 11; i++) {
                String fileName = fileNames[i];
                System.out.println(TEIParser.class.getClassLoader().getResource(fileName));
                InputStream inputStream = TEIParser.class.getClassLoader().getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String currentOrth = null;
                String line;
                while ((line = reader.readLine()) != null) {

                        if (line.contains("<orth>")) {
                            currentOrth = line.replaceAll("<.*?>", "");
                        } else if (line.contains("<quote>")) {
                            String quote = line.replaceAll("<.*?>", "");
                            maps[i].put(currentOrth, quote);
                            currentOrth = null;

                    }
                }

                reader.close();
            }

            // Print results

                System.out.println("Results for  "+fileNames[Selected]+  (Selected+1) + ":");
                HashMap<String, String> map = maps[Selected];
                for (String key : map.keySet()) {
                    System.out.println("Key: " + key + " Value: " + map.get(key));
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    return maps[Selected];

    }




}