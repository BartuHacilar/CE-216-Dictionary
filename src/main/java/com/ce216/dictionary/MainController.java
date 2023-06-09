package com.ce216.dictionary;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainController {


    @FXML
    private AnchorPane AddAnchor;

    @FXML
    private Button AddButton;

    @FXML
    private Button AddButton1;

    @FXML
    private ComboBox<String> AddComboBox1;



    @FXML
    private ComboBox<String> AddComboBox2;



    @FXML
    private Button AddDeletebutton;

    @FXML
    private Button AddGoBack;

    @FXML
    private Button AddReplaceButton;

    @FXML
    private TextArea AddTextArea1;
    @FXML
    private Button HelpButton;

    @FXML
    private TextArea AddTextArea2;

    @FXML
    private AnchorPane DeleteAnchor;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button DeleteButton1;

    @FXML
    private ComboBox<String> DeleteComboBox1;

    @FXML
    private ComboBox<String> DeleteComboBox2;

    @FXML
    private Button DeleteDeletebutton;

    @FXML
    private Button DeleteGoBack;

    @FXML
    private Button DeleteReplaceButton1;

    @FXML
    private TextArea DeleteTextArea1;

    @FXML
    private TextArea DeleteTextArea2;



    @FXML
    private AnchorPane EditAnchor;

    @FXML
    private Button EditButton;

    @FXML
    private Button EditButton1;

    @FXML
    private Button EditGoback;

    @FXML
    private Button EditclearButton1;

    @FXML
    private Button EditclearButton2;

    @FXML
    private ComboBox<String> EditComboBox1;

    @FXML
    private ComboBox<String> EditComboBox2;

    @FXML
    private Button EditreplaceButton;

    @FXML
    private TextArea EditTextArea1;

    @FXML
    private TextArea EditTextArea11;

    @FXML
    private TextArea EditTextArea12;



    @FXML
    private ListView<String> H_List;

    @FXML
    private ListView<String> H_List2;

    @FXML
    private AnchorPane HistoryAnchor;

    @FXML
    private Button HistoryGoback;

    @FXML
    private Button Languagebutton;

    @FXML
    private AnchorPane MainAnchor;

    @FXML
    private Button Synonymbutton;


    @FXML
    private Button clearButton;


    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;



    @FXML
    private ImageView editimage;

    @FXML
    private ImageView editimage1;

    @FXML
    private Button replaceButton;

    @FXML
    private Button HistoryButton;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;



    @FXML
    private Button translateButton;






    private HashMap<String,String> German_ModernGreek;
    private HashMap<String,String> German_English;
    private HashMap<String,String> German_French;
    private HashMap<String,String> German_Italian;
    private HashMap<String,String> German_Swedish;
    private HashMap<String,String> German_Turkish;

    private HashMap<String,String> ModernGreek_English;
    private HashMap<String,String> ModernGreek_French;
    private HashMap<String,String> ModernGreek_Italian;

    private HashMap<String,String> English_German;
    private HashMap<String,String> English_ModernGreek;
    private HashMap<String,String> English_French;
    private HashMap<String,String> English_Italian;
    private HashMap<String,String> English_Swedish;
    private HashMap<String,String> English_Turkish;

    private HashMap<String,String> French_German;
    private HashMap<String,String> French_ModernGreek;
    private HashMap<String,String> French_English;
    private HashMap<String,String> French_Italian;
    private HashMap<String,String> French_Swedish;
    private HashMap<String,String> French_Turkish;

    private HashMap<String,String> Italian_German;
    private HashMap<String,String> Italian_ModernGreek;
    private HashMap<String,String> Italian_English;
    private HashMap<String,String> Italian_Swedish;
    private HashMap<String,String> Italian_Turkish;

    private HashMap<String,String> Swedish_German;
    private HashMap<String,String> Swedish_English;
    private HashMap<String,String> Swedish_French;
    private HashMap<String,String> Swedish_Italian;
    private HashMap<String,String> Swedish_Turkish;

    private HashMap<String,String> Turkish_German;
    private HashMap<String,String> Turkish_English;
    HashMap<String,String> Dil_Dosya= new HashMap<>();

    private ArrayList<String> History = new ArrayList<>();


    private TEIParser Parser;
    private String selectedLanguage1;
    private String selectedLanguage2;
    private String DeleteSelectedLanguage1;
    private String DeleteSelectedLanguage2;
    private String AddSelectedLanguage1;
    private String AddSelectedLanguage2;
    private String EditSelectedLanguage1;
    private String EditSelectedLanguage2;
    HashMap<String, HashMap<String, String>> languageMaps = new HashMap<>();

    public void initialize() {
        // set the prompt text and items for the combo boxes
        comboBox1.setPromptText("Language");
        comboBox1.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        comboBox1.setOnAction(event -> {
            selectedLanguage1 = comboBox1.getValue().replace(" ", "").trim();

        });

        comboBox2.setPromptText("Language");
        comboBox2.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        comboBox2.setOnAction(event -> {
            selectedLanguage2 = comboBox2.getValue().replace(" ", "").trim();
        });

        // set the text for the text areas
        textArea1.setPromptText("Enter text here");
        textArea2.setPromptText("Translated text will appear here");


        // set the prompt text and items for the combo boxes
        AddComboBox1.setPromptText("Language");
        AddComboBox1.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        AddComboBox1.setOnAction(event -> {
            AddSelectedLanguage1 = AddComboBox1.getValue().replace(" ", "").trim();

        });

        AddComboBox2.setPromptText("Language");
        AddComboBox2.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        AddComboBox2.setOnAction(event -> {
            AddSelectedLanguage2 = AddComboBox2.getValue().replace(" ", "").trim();
        });

        // set the text for the text areas
        AddTextArea1.setPromptText("Enter text here");
        AddTextArea2.setPromptText("Translated text will appear here");




        // set the prompt text and items for the combo boxes
        EditComboBox1.setPromptText("Language");
        EditComboBox1.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        EditComboBox1.setOnAction(event -> {
            EditSelectedLanguage1 = EditComboBox1.getValue().replace(" ", "").trim();

        });

        EditComboBox2.setPromptText("Language");
        EditComboBox2.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        EditComboBox2.setOnAction(event -> {
            EditSelectedLanguage2 = EditComboBox2.getValue().replace(" ", "").trim();
        });

        // set the text for the text areas
        EditTextArea1.setPromptText("Enter which word you want to edit");
        EditTextArea11.setPromptText("Enter how should be the edited version of word");
        EditTextArea12.setPromptText("Enter how should be the edited version of translation");




        // set the prompt text and items for the combo boxes
        DeleteComboBox1.setPromptText("Language");
        DeleteComboBox1.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        DeleteComboBox1.setOnAction(event -> {
            DeleteSelectedLanguage1 = DeleteComboBox1.getValue().replace(" ", "").trim();

        });

        DeleteComboBox2.setPromptText("Language");
        DeleteComboBox2.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");
        DeleteComboBox2.setOnAction(event -> {
            DeleteSelectedLanguage2 = DeleteComboBox2.getValue().replace(" ", "").trim();
        });

        // set the text for the text areas
        DeleteTextArea1.setPromptText("Enter text here");
        DeleteTextArea2.setPromptText("Translated text will appear here");



        Parser = new TEIParser();
        H_List.setItems(FXCollections.observableArrayList());
        H_List2.setItems(FXCollections.observableArrayList());

        //The TeiParser class puts words into hashmaps for translation of languages, and hashmaps are created for each language pair variation.
        German_ModernGreek = Parser.Parsing(0);
        languageMaps.put("German_ModernGreek",German_ModernGreek);
        if (German_ModernGreek.keySet() == null) {
            System.out.println("German to Modern Greek is empty");
        }
        Dil_Dosya.put("German_ModernGreek","deu-ell.tei");

        German_English = Parser.Parsing(1);
        languageMaps.put("German_English",German_English);
        if (German_English.keySet() == null) {
            System.out.println("German to English is empty");
        }
        Dil_Dosya.put("German_English","deu-eng.tei");

        German_French = Parser.Parsing(2);
        languageMaps.put("German_French",German_French);
        if (German_French.keySet() == null) {
            System.out.println("German to French is empty");
        }
        Dil_Dosya.put("German_fra","deu-fra.tei");


        German_Swedish = Parser.Parsing(3);
        languageMaps.put("German_Swedish",German_Swedish);
        if (German_Swedish.keySet() == null) {
            System.out.println("German to Swedish is empty");
        }
        Dil_Dosya.put("German_Swedish","deu-swe.tei");



        ModernGreek_English = Parser.Parsing(4);
        languageMaps.put("ModernGreek_English",ModernGreek_English  );
        if (ModernGreek_English.keySet() == null) {
            System.out.println("Modern Greek to English is empty");
        }
        Dil_Dosya.put("ModernGreek_English","ell-eng.tei");

        ModernGreek_French = Parser.Parsing(5);
        languageMaps.put("ModernGreek_French", ModernGreek_French );
        if (ModernGreek_French.keySet() == null) {
            System.out.println("Modern Greek to French is empty");
        }
        Dil_Dosya.put("ModernGreek_French ","ell-fra.tei");

        ModernGreek_Italian = Parser.Parsing(6);
        languageMaps.put("ModernGreek_Italian",ModernGreek_Italian  );
        if (ModernGreek_Italian.keySet() == null) {
            System.out.println("Modern Greek to Italian is empty");
        }
        Dil_Dosya.put("ModernGreek_Italian","ell-ita.tei");

        Turkish_German = Parser.Parsing(7);
        languageMaps.put("Turkish_German",Turkish_German  );

        if (Turkish_German.keySet()==null){
            System.out.println("This is empty");}
        Dil_Dosya.put("Turkish_German","tur-deu.tei");

        Turkish_English = Parser.Parsing(8);
        languageMaps.put("Turkish_English",Turkish_English  );

        if (Turkish_English.keySet()==null) {
            System.out.println("This is empty");
        }
        Dil_Dosya.put("Turkish_English","tur-eng.tei");


        English_ModernGreek = Parser.Parsing(9);
        languageMaps.put("English_ModernGreek", English_ModernGreek );
        if (English_ModernGreek.keySet() == null) {
            System.out.println("English to Modern Greek is empty");
        }
        Dil_Dosya.put("English_ModernGreek","eng-ell.tei");

        English_German = Parser.Parsing(10);
        languageMaps.put("English_German",English_German  );
        if (English_German.keySet() == null) {
            System.out.println("English to German is empty");
        }
        Dil_Dosya.put("English_German","eng-deu.tei");

        English_French = Parser.Parsing(11);
        languageMaps.put("English_French", English_French  );
        if (English_French.keySet() == null) {
            System.out.println("English_French is empty");
        }
        Dil_Dosya.put("English_French","eng-fra.tei");



        English_Swedish = Parser.Parsing(12);
        languageMaps.put("English_Swedish", English_Swedish  );
        if (English_Swedish.keySet() == null) {
            System.out.println("English_Swedish is empty");
        }
        Dil_Dosya.put("English_Swedish","eng-swe.tei");

        English_Turkish = Parser.Parsing(13);
        languageMaps.put("English_Turkish",  English_Turkish );
        if (English_Turkish.keySet() == null) {
            System.out.println("English_Turkish is empty");
        }
        Dil_Dosya.put("English_Turkish","eng-tur.tei");

        French_German = Parser.Parsing(14);
        languageMaps.put("French_German", French_German );
        if (French_German.keySet() == null) {
            System.out.println("French_German is empty");
        }
        Dil_Dosya.put("French_German","fra-deu.tei");


        French_ModernGreek = Parser.Parsing(15);
        languageMaps.put("French_ModernGreek",  French_ModernGreek );
        if (French_ModernGreek.keySet() == null) {
            System.out.println("French_ModernGreek is empty");
        }
        Dil_Dosya.put("French_ModernGreek","fra-ell.tei");

        French_English = Parser.Parsing(16);
        languageMaps.put("French_English",  French_English );
        if (French_English.keySet() == null) {
            System.out.println("French_English is empty");
        }
        Dil_Dosya.put(" French_English","fra-eng.tei");

        French_Italian = Parser.Parsing(17);
        languageMaps.put("French_Italian",French_Italian  );
        if (French_Italian.keySet() == null) {
            System.out.println("French_Italian is empty");
        }
        Dil_Dosya.put("French_Italian","fra-ita.tei");

        French_Swedish = Parser.Parsing(18);
        languageMaps.put("French_Swedish",French_Swedish  );
        if (French_Swedish.keySet() == null) {
            System.out.println("French_Swedish is empty");
        }
        Dil_Dosya.put("French_Swedish","fra-swe.tei");

        French_Turkish = Parser.Parsing(19);
        languageMaps.put("French_Turkish",French_Turkish  );
        if (French_Turkish.keySet() == null) {
            System.out.println("French_Turkish is empty");
        }
        Dil_Dosya.put("French_Turkish","fra-tur.tei");

        Italian_German = Parser.Parsing(20);
        languageMaps.put("Italian_German",Italian_German   );
        if (Italian_German.keySet() == null) {
            System.out.println("Italian_German is empty");
        }
        Dil_Dosya.put("Italian_German","ita-deu.tei");

        Italian_ModernGreek = Parser.Parsing(21);
        languageMaps.put("Italian_ModernGreek", Italian_ModernGreek  );
        if (Italian_ModernGreek.keySet() == null) {
            System.out.println("Italian_ModernGreek is empty");
        }
        Dil_Dosya.put("Italian_ModernGreek","ita-ell.tei");

        Italian_English = Parser.Parsing(22);
        languageMaps.put("Italian_English", Italian_English  );
        if (Italian_English.keySet() == null) {
            System.out.println("Italian_English is empty");
        }
        Dil_Dosya.put("Italian_English","ita-eng.tei");

        Italian_Swedish = Parser.Parsing(23);
        languageMaps.put("Italian_Swedish", Italian_Swedish );
        if (Italian_Swedish.keySet() == null) {
            System.out.println("Italian_Swedish is empty");
        }
        Dil_Dosya.put("Italian_Swedish","ita-swe.tei");

        Italian_Turkish = Parser.Parsing(24);
        languageMaps.put("Italian_Turkish",Italian_Turkish  );
        if (Italian_Turkish.keySet() == null) {
            System.out.println("Italian_Turkish is empty");
        }
        Dil_Dosya.put("Italian_Turkish","ita-tur.tei");

        Swedish_German = Parser.Parsing(25);
        languageMaps.put("Swedish_German",Swedish_German  );
        if (Swedish_German.keySet() == null) {
            System.out.println("Swedish_German is empty");
        }
        Dil_Dosya.put("Swedish_German","swe-deu.tei");

        Swedish_English = Parser.Parsing(26);
        languageMaps.put("Swedish_English",Swedish_English  );
        if (Swedish_English.keySet() == null) {
            System.out.println("Swedish_English is empty");
        }
        Dil_Dosya.put("Swedish_English","swe-eng.tei");

        Swedish_French = Parser.Parsing(27);
        languageMaps.put("Swedish_French",Swedish_French  );
        if (Swedish_French.keySet() == null) {
            System.out.println("Swedish_French is empty");
        }
        Dil_Dosya.put("Swedish_French","swe-fra.tei");

        Swedish_Italian = Parser.Parsing(28);
        languageMaps.put("Swedish_Italian",Swedish_Italian  );
        if (Swedish_Italian.keySet()==null) {
            System.out.println("This is empty");
        }
        Dil_Dosya.put("Swedish_Italian","swe-ita.tei");

        Swedish_Turkish = Parser.Parsing(29);
        languageMaps.put("Swedish_Turkish",Swedish_Turkish  );
        if (Swedish_Turkish.keySet()==null){
            System.out.println("This is empty");
        }
        Dil_Dosya.put("Swedish_Turkish","swe-tur.tei");

        English_Italian = Parser.Parsing(30);
        languageMaps.put("English_Italian",English_Italian  );
        if (English_Italian.keySet() == null) {
            System.out.println("English_Italian is empty");
        }
        Dil_Dosya.put("English_Italian","eng-ita.tei");

        German_Turkish = Parser.Parsing(31);
        languageMaps.put("German_Turkish",  German_Turkish );
        if (German_Turkish.keySet() == null) {
            System.out.println("German to Turkish is empty");
        }
        Dil_Dosya.put("German_Turkish","deu-tur.tei");

        German_Italian = Parser.Parsing(32);
        languageMaps.put("German_Italian",German_Italian);
        if (German_Italian.keySet() == null) {
            System.out.println("German to Italian is empty");
        }
        Dil_Dosya.put("German_Italian","deu-ita.tei");
        
        H_List.setOnMouseClicked(e -> {
            String selectedItem = H_List.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                if(selectedItem.contains("_")){
                    Languages=selectedItem.split("_");
                    if(Objects.equals(Languages[0], "ModernGreek")){
                        Languages[0]="Modern Greek";

                    }
                    if(Objects.equals(Languages[1], "ModernGreek")){
                        Languages[1]="Modern Greek";

                    }
                    comboBox1.setValue(Languages[0]);
                    comboBox2.setValue(Languages[1]);
                }
                else if (!selectedItem.contains("_")){
                    textArea1.setText(selectedItem);
                }

                }

            }
        );


        // Displays words that are ready to be translated to the user based on changes made in the text area.
        textArea1.textProperty().addListener((observable, oldValue, newValue) -> {
            H_List.getItems().clear();
            String searchWord = textArea1.getText();

            String SelectedLanguagePair = selectedLanguage1 + "_" + selectedLanguage2;
            if (languageMaps.containsKey(SelectedLanguagePair)) {
                HashMap<String, String> selectedLanguageMap = languageMaps.get(SelectedLanguagePair);

            String regex = "(?i)" + searchWord + "\\w*";
            boolean hasMatches = selectedLanguageMap.keySet()
                    .stream()
                    .anyMatch(key -> key != null && key.matches(regex));

            if (hasMatches) {
                selectedLanguageMap.keySet()
                        .stream()
                        .filter(key -> key != null && key.matches(regex))
                        .forEach(H_List.getItems()::add);

                }


            }
            else { /*"For indirect translations, the keys and values of two hashmaps will be searched,
            any words that are ready to be translated will be displayed to the user." */
                String tsellangpair1= selectedLanguage1+"_"+ "English";
                String tsellangpair2="English"+"_"+selectedLanguage2;
                if(languageMaps.containsKey(tsellangpair1)&&languageMaps.containsKey(tsellangpair2)){
                    HashMap<String, String> tLanguageMap1 = languageMaps.get(tsellangpair1);
                    HashMap<String, String> tLanguageMap2 = languageMaps.get(tsellangpair2);
                String regex = "(?i)" + searchWord + "\\w*";
                boolean hasMatches = tLanguageMap1.keySet()
                        .stream()
                        .anyMatch(key -> key != null && key.matches(regex));

                if(hasMatches){
                        ArrayList<String>Translatable = new ArrayList<>();
                        for (String key : tLanguageMap1.keySet()) {
                            boolean Translationexist =tLanguageMap2.containsKey(tLanguageMap1.get(key));
                            if(Translationexist)
                                Translatable.add(key);
                        }

                        Translatable
                                .stream()
                                .filter(key -> key != null && key.matches(regex))
                                .forEach(H_List.getItems()::add);

                }

                }

        }});

    }

    public void Clear () {
        textArea1.setText("");
        textArea2.setText("");
        System.out.println("Deleted");

    }
    String[] SynonymsAndTranslations;
    String[]Translations;

    public String[] Translate(){//Translates the given word in the desired language
        String translations=" ";
        String Searchword=textArea1.getText();
        String selectedLanguagePair = selectedLanguage1 + "_" + selectedLanguage2;
        if (languageMaps.containsKey(selectedLanguagePair)) {
            HashMap<String, String> selectedLanguageMap = languageMaps.get(selectedLanguagePair);
            String translation = selectedLanguageMap.get(Searchword);
             SynonymsAndTranslations = translation.split("/synonym: ");
            String wantedtrans= SynonymsAndTranslations[0];
            Translations=SynonymsAndTranslations[0].split(",");
            if (wantedtrans != null) {
                textArea1.setText(Searchword);
                for (String items:Translations){
                    int count=1;
                    translations+=items+"\n";
                }
                textArea2.setText(translations);
                String translationhistory = "From "+selectedLanguage1+" Language to "+selectedLanguage2+" Word is : "+Searchword+wantedtrans;
                History.add(translationhistory);
                return SynonymsAndTranslations;

            } else {
                System.out.println("There is no such word in this file");
            }
        } else { //To translate the desired word, it first translates it into English and from English to the desired language.
            System.out.println("Translation between these languages will be indirectly translated");
            String tempsellangpair1= selectedLanguage1+"_"+ "English";
            String tempsellangpair2="English"+"_"+selectedLanguage2;
            if(languageMaps.containsKey(tempsellangpair1)&&languageMaps.containsKey(tempsellangpair2)){
                HashMap<String, String> tempLanguageMap1 = languageMaps.get(tempsellangpair1);
                HashMap<String, String> tempLanguageMap2 = languageMaps.get(tempsellangpair2);
                String translationcheck=tempLanguageMap1.get(Searchword);
                boolean wordexist =tempLanguageMap2.containsKey(tempLanguageMap1.get(Searchword));

                if(translationcheck!=null&& wordexist){
                    String indirecttranslation=tempLanguageMap2.get(tempLanguageMap1.get(Searchword));
                     SynonymsAndTranslations = indirecttranslation.split("/synonym: ");
                    String wantedtrans= SynonymsAndTranslations[0];
                    Translations=SynonymsAndTranslations[0].split(",");


                        for (String items:Translations){
                            int count=1;
                            translations+=items+"\n";
                        }
                        textArea2.setText(translations);
                    textArea1.setText(Searchword);

                    String translationhistory = "From "+selectedLanguage1+" Language to "+selectedLanguage2+" Word is : "+Searchword+wantedtrans;
                    History.add(translationhistory);
                    return SynonymsAndTranslations;


                }
                else System.out.println("The word you searched for was not found .");
            }
        }
    return SynonymsAndTranslations;
    }
    public  void Replace(){
        String s1 = comboBox1.getValue();
        String s2 = comboBox2.getValue();
        int temp = comboBox1.getSelectionModel().getSelectedIndex();
        comboBox1.getSelectionModel().select(comboBox2.getSelectionModel().getSelectedIndex());
        comboBox2.getSelectionModel().select(temp);
    }
    public void Add() throws IOException {

        String selectedLanguagePair = AddSelectedLanguage1 + "_" + AddSelectedLanguage2;
        if (Dil_Dosya.containsKey(selectedLanguagePair)){
            String dosyaname = Dil_Dosya.get(selectedLanguagePair);
            InputStream inputStream = com.ce216.dictionary.MainController.class.getResourceAsStream("/languages/" + dosyaname);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            ArrayList<String> lines = new ArrayList<>();
            String word = AddTextArea1.getText();
            String translation = AddTextArea2.getText();

            // Check that both values are non-empty
            if (word.isEmpty() || translation.isEmpty()) {
                System.out.println("Please enter a word and its translation.");
                reader.close();
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/languages/" + dosyaname, true), StandardCharsets.UTF_8));

            if (languageMaps.containsKey(selectedLanguagePair)) {
                writer.write("<entry>");
                writer.newLine();
                writer.write("<orth>"+word+"</orth>");
                writer.newLine();
                writer.write("<quote>"+translation+"</quote>");
                writer.newLine();
                writer.write("</entry>");
                writer.flush();
                languageMaps.get(selectedLanguagePair).put(word, translation);
            }

            writer.close();
            System.out.println("Word added.");
        }
    }



    public void Edit() throws IOException {

        // Get the value from the first TextArea
        String word = EditTextArea1.getText();
        String wordd = EditTextArea11.getText();
        String worddd = EditTextArea12.getText();

        // Check if the selected language pair exists in languageMaps
        String languagePair = EditSelectedLanguage1 + "_" + EditSelectedLanguage2;
        if (!languageMaps.containsKey(languagePair)) {
            System.out.println("No translations found for the selected language pair.");
            return;
        }

        // Get the language map for the selected language pair
        HashMap<String, String> languageMap = languageMaps.get(languagePair);

        // Check if the word exists in the language map
        if (!languageMap.containsKey(word)) {
            System.out.println("The word does not exist in the language map.");
            return;
        }

        // Check if the user input is for updating the key or value
        if (!wordd.isEmpty() && !worddd.isEmpty()) {
            languageMap.remove(word);

            // Delete the word and its translation from the language file
            String dosyaname = Dil_Dosya.get(languagePair);
            Path path = Paths.get("src/main/resources/languages/" + dosyaname);
            Charset charset = StandardCharsets.UTF_8;
            List<String> fileContent = new ArrayList<>();
            try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                String line;
                boolean orthfound=false;
                while ((line = reader.readLine()) != null) {

                    if (line.contains("<orth>" + word + "</orth>")){
                        orthfound=true;
                    }
                    if ( !orthfound) {
                        fileContent.add(line);
                    }
                    if (line.contains("</entry>")) {
                        if(orthfound){
                            fileContent.add(line);
                            orthfound=false;
                        }



                    }
                }
                fileContent.add("<entry>");
                fileContent.add("<orth>"+wordd+"</orth>");
                fileContent.add("<quote>"+worddd+"</quote>");
                fileContent.add("</entry>");

            }
            Files.write(path, fileContent, charset);


            // Update the language map with the edited key
            languageMap.put(wordd, languageMap.get(word));
            languageMap.remove(word);
            // Update the UI to reflect the changes
            EditTextArea1.setText(wordd);
            languageMap.put(wordd,worddd);
        }
        else if(!wordd.isEmpty() && worddd.isEmpty()){
            String Translationtemp;
            Translationtemp=languageMap.get(word);
            languageMap.remove(word);

            // Delete the word and its translation from the language file
            String dosyaname = Dil_Dosya.get(languagePair);
            Path path = Paths.get("src/main/resources/languages/" + dosyaname);
            Charset charset = StandardCharsets.UTF_8;
            List<String> fileContent = new ArrayList<>();
            try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                String line;
                boolean orthfound=false;
                while ((line = reader.readLine()) != null) {

                    if (line.contains("<orth>" + word + "</orth>")){
                        orthfound=true;
                    }
                    if ( !orthfound) {
                        fileContent.add(line);
                    }
                    if (line.contains("</entry>")) {
                        if(orthfound){
                            fileContent.add(line);
                            orthfound=false;
                        }



                    }
                }
                fileContent.add("<entry>");
                fileContent.add("<orth>"+wordd+"</orth>");
                fileContent.add("<quote>"+Translationtemp+"</quote>");
                fileContent.add("</entry>");

            }
            Files.write(path, fileContent, charset);


            languageMap.put(wordd, Translationtemp);
            languageMap.remove(word);
            EditTextArea1.setText(wordd);
        }
        else if(wordd.isEmpty() && !worddd.isEmpty()){
            languageMap.remove(word);

            // Delete the word and its translation from the language file
            String dosyaname = Dil_Dosya.get(languagePair);
            Path path = Paths.get("src/main/resources/languages/" + dosyaname);
            Charset charset = StandardCharsets.UTF_8;
            List<String> fileContent = new ArrayList<>();
            try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                String line;
                boolean orthfound=false;
                while ((line = reader.readLine()) != null) {

                    if (line.contains("<orth>" + word + "</orth>")){
                        orthfound=true;
                    }
                    if ( !orthfound) {
                        fileContent.add(line);
                    }
                    if (line.contains("</entry>")) {
                        if(orthfound){
                            fileContent.add(line);
                            orthfound=false;
                        }



                    }
                }
                fileContent.add("<entry>");
                fileContent.add("<orth>"+word+"</orth>");
                fileContent.add("<quote>"+worddd+"</quote>");
                fileContent.add("</entry>");

            }
            Files.write(path, fileContent, charset);

            languageMap.put(word,worddd);
        }

        else {
            System.out.println("Please enter a value for either the key or value field.");
            return;
        }

        // Update the languageMaps object with the updated language map
        languageMaps.put(languagePair, languageMap);
        System.out.println("Word edited.");
    }












    public void Delete() throws IOException {

        // Get the value from the first TextArea
        String word = DeleteTextArea1.getText();

        // Check that the value is non-empty
        if (word.isEmpty()) {
            System.out.println("Please enter a word to delete.");
            return;
        }

        // Check if the selected language pair exists in languageMaps
        String languagePair = DeleteSelectedLanguage1 + "_" + DeleteSelectedLanguage2;
        if (!languageMaps.containsKey(languagePair)) {
            System.out.println("No translations found for the selected language pair.");
            return;
        }

        // Get the language map for the selected language pair
        HashMap<String, String> languageMap = languageMaps.get(languagePair);

        // Check if the word exists in the language map
        if (!languageMap.containsKey(word)) {
            System.out.println("The word does not exist in the language map.");
            return;
        }

        // Remove the word and its translation from the language map
        languageMap.remove(word);

        // Delete the word and its translation from the language file
        String dosyaname = Dil_Dosya.get(languagePair);
        Path path = Paths.get("src/main/resources/languages/" + dosyaname);
        Charset charset = StandardCharsets.UTF_8;
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;
            boolean entryFound = false;
            boolean orthfound=false;
            while ((line = reader.readLine()) != null) {

                if (line.contains("<orth>" + word + "</orth>")){
                    orthfound=true;
                }
                if ( !orthfound) {
                    fileContent.add(line);
                }
                if (line.contains("</entry>")) {
                    if(orthfound){
                        fileContent.add(line);
                        orthfound=false;
                    }



                }
            }
        }
        Files.write(path, fileContent, charset);

        System.out.println("Word deleted.");
    }

    String[]Languages;
    public void FindLanguage() {
        ArrayList<String>IndirectLanguages=new ArrayList<>();
        IndirectLanguages.add("ModernGreek_German");
        IndirectLanguages.add("ModernGreek_Swedish");
        IndirectLanguages.add("ModernGreek_Turkish");
        IndirectLanguages.add("Italian_French");
        IndirectLanguages.add("Swedish_ModernGreek");
        IndirectLanguages.add("Turkish_Swedish");
        IndirectLanguages.add("Turkish_Italian");
        IndirectLanguages.add("Turkish_French");
        IndirectLanguages.add("Turkish_ModernGreek");
        String Searchword=textArea1.getText();
        ArrayList<String>AvailableLanguages=new ArrayList<>();
        H_List.getItems().clear();
        for (String key : languageMaps.keySet()) {

            HashMap<String, String> innerHashMap = languageMaps.get(key);

            if (innerHashMap.containsKey(Searchword)) {
                AvailableLanguages.add(key);
            }

        }

        for (String indirectkey : IndirectLanguages){

        String[] myArray;
        myArray = indirectkey.split("_");


               String firstlang=myArray[0];
               String secondlang=myArray[1];
               String lang1toeng=firstlang+"_"+"English";
               String engtolang2="English"+"_"+secondlang;

            if(languageMaps.containsKey(lang1toeng)&&languageMaps.containsKey(engtolang2)) {
                HashMap<String, String> tempLanguageMap1 = languageMaps.get(lang1toeng);
                HashMap<String, String> tempLanguageMap2 = languageMaps.get(engtolang2);
                String translationcheck=tempLanguageMap1.get(Searchword);
                boolean wordexist =tempLanguageMap2.containsKey(tempLanguageMap1.get(Searchword));


                if(translationcheck!=null&& wordexist) {

                    String Availableindirect = firstlang + "_" + secondlang;
                    if (!AvailableLanguages.contains(Availableindirect)) {
                        AvailableLanguages.add(Availableindirect);

                    }
                }

              }

        }

            AvailableLanguages
                    .stream()
                    .forEach(H_List.getItems()::add);



        }



    public void FindSynonym(){
            String[]Synonyms=Translate();
            String synonym="Synonyms are : ";
            for(int i=1;i< Synonyms.length;i++){
                synonym+=Synonyms[i];
                synonym+=",";
            }
        textArea2.setText(synonym);

        }

    public void GoBackFromAddToMain(){
        AddAnchor.setVisible(false);
        MainAnchor.setVisible(true);
    }
    public void GoBackFromEditToMain(){
        EditAnchor.setVisible(false);
        MainAnchor.setVisible(true);
    }
    public void GoBackFromDeleteToMain(){
        DeleteAnchor.setVisible(false);
        MainAnchor.setVisible(true);
    }
    public void GoBackFromHistoryToMain(){
        HistoryAnchor.setVisible(false);
        MainAnchor.setVisible(true);
        H_List2.getItems().clear();
    }
    public void History(){
        MainAnchor.setVisible(false);
        HistoryAnchor.setVisible(true);

        History.stream().forEach(
                H_List2.getItems()::add);

    }
    public void AddButton(){
        MainAnchor.setVisible(false);
        AddAnchor.setVisible(true);

    }

    public void DeleteButton(){
        MainAnchor.setVisible(false);
        DeleteAnchor.setVisible(true);

    }

    public void EditButton(){
        MainAnchor.setVisible(false);
        EditAnchor.setVisible(true);

    }
    public void EditClearWord(){

            EditTextArea1.setText("");

    }
    public void EditClearUpdate(){

            EditTextArea11.setText("");
            EditTextArea12.setText("");



    }
    public void EditReplace(){
        String s1 = EditComboBox1.getValue();
        String s2 = EditComboBox2.getValue();
        int temp = EditComboBox1.getSelectionModel().getSelectedIndex();
        EditComboBox1.getSelectionModel().select(EditComboBox2.getSelectionModel().getSelectedIndex());
        EditComboBox2.getSelectionModel().select(temp);

    }
    public void DeleteReplace(){
        String s1 = DeleteComboBox1.getValue();
        String s2 = DeleteComboBox2.getValue();
        int temp = DeleteComboBox1.getSelectionModel().getSelectedIndex();
        DeleteComboBox1.getSelectionModel().select(DeleteComboBox2.getSelectionModel().getSelectedIndex());
        DeleteComboBox2.getSelectionModel().select(temp);
    }
    public void DeleteClear(){
        DeleteTextArea1.setText("");
        DeleteTextArea2.setText("");
    }
    public void AddClear(){
        AddTextArea1.setText("");
        AddTextArea2.setText("");

    }
    public void AddReplace(){
        String s1 = AddComboBox1.getValue();
        String s2 = AddComboBox2.getValue();
        int temp = AddComboBox1.getSelectionModel().getSelectedIndex();
        AddComboBox1.getSelectionModel().select(AddComboBox2.getSelectionModel().getSelectedIndex());
        AddComboBox2.getSelectionModel().select(temp);

    }
    @FXML
    private void GoHelp() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/HelpScreen.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Help");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }







}


