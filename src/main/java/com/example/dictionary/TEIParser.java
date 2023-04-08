package com.example.dictionary;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TEIParser {

    public static HashMap<String,String> Parsing(int Selected) {

        String[] fileNames = {
                "deu-ell.tei","deu-eng.tei","deu-fra.tei","deu-swe.tei","ell-eng.tei",
                "ell-fra.tei","ell-ita.tei","tur-deu.tei","tur-eng.tei","eng-ell.tei",
                "eng-deu.tei","eng-fra.tei","eng-swe.tei","eng-tur.tei","fra-deu.tei",
                "fra-ell.tei","fra-eng.tei","fra-ita.tei","fra-swe.tei","fra-tur.tei",
                "ita-deu.tei","ita-ell.tei","ita-eng.tei","ita-swe.tei","ita-tur.tei",
                "swe-deu.tei","swe-eng.tei","swe-fra.tei","swe-ita.tei","swe-tur.tei",
                "eng-ita.tei","deu-tur.tei","deu-ita.tei"};
        HashMap<String, String> maps  = new HashMap<>();

            try {
            // Define file names and corresponding HashMaps

            // Loop through files and read data into HashMaps

                String fileName = fileNames[Selected];
                System.out.println(TEIParser.class.getClassLoader().getResource(fileName));
                InputStream inputStream = TEIParser.class.getClassLoader().getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String currentOrth = null;
                String line;
                while ((line = reader.readLine()) != null) {

                        if (line.contains("</orth>")) {
                            currentOrth = line.replaceAll("<.*?>", "").trim();
                        } else if (line.contains("</quote>")||line.contains("</def>")) {
                            String quote = line.replaceAll("<.*?>", "").trim();
                            maps.put(currentOrth, quote);
                            if(maps.keySet()==null)
                                System.out.println("this hashmap is empty");
                            currentOrth = null;

                    }
                }

                reader.close();






        } catch (Exception e) {
            e.printStackTrace();
        }
    return maps;

    }




}