package com.ce216.dictionary;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainController {

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private Label titleLabel;

    @FXML
    private Button replaceButton;

    @FXML
    private ImageView arrowImageView;

    @FXML
    private Button translateButton;

    @FXML
    private Button clearButton;

    @FXML
    private ImageView xImageView;

    @FXML
    private AnchorPane root;
    @FXML
    private ListView<String> H_List;
    @FXML
    private Button AddButton;
    @FXML
    private Button EditButton;
    @FXML
    private Button DeleteButton;




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

    private ArrayList<String[]> History = new ArrayList<>();


    private TEIParser Parser;
    private String selectedLanguage1;
    private String selectedLanguage2;
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

        Parser = new TEIParser();
        H_List.setItems(FXCollections.observableArrayList());

        //The TeiParser class puts words into hashmaps for translation of languages, and hashmaps are created for each language pair variation.
        German_ModernGreek = Parser.Parsing(0);
        languageMaps.put("German_ModernGreek",German_ModernGreek);
        if (German_ModernGreek.keySet() == null) {
            System.out.println("German to Modern Greek is empty");
        }

        German_English = Parser.Parsing(1);
        languageMaps.put("German_English",German_English);
        if (German_English.keySet() == null) {
            System.out.println("German to English is empty");
        }

        German_French = Parser.Parsing(2);
        languageMaps.put("German_French",German_French);
        if (German_French.keySet() == null) {
            System.out.println("German to French is empty");
        }


        German_Swedish = Parser.Parsing(3);
        languageMaps.put("German_Swedish",German_Swedish);
        if (German_Swedish.keySet() == null) {
            System.out.println("German to Swedish is empty");
        }



        ModernGreek_English = Parser.Parsing(4);
        languageMaps.put("ModernGreek_English",ModernGreek_English  );
        if (ModernGreek_English.keySet() == null) {
            System.out.println("Modern Greek to English is empty");
        }

        ModernGreek_French = Parser.Parsing(5);
        languageMaps.put("ModernGreek_French", ModernGreek_French );
        if (ModernGreek_French.keySet() == null) {
            System.out.println("Modern Greek to French is empty");
        }

        ModernGreek_Italian = Parser.Parsing(6);
        languageMaps.put("ModernGreek_Italian",ModernGreek_Italian  );
        if (ModernGreek_Italian.keySet() == null) {
            System.out.println("Modern Greek to Italian is empty");
        }

        Turkish_German = Parser.Parsing(7);
        languageMaps.put("Turkish_German",Turkish_German  );

        if (Turkish_German.keySet()==null)
            System.out.println("This is empty");

        Turkish_English = Parser.Parsing(8);
        languageMaps.put("Turkish_English",Turkish_English  );

        if (Turkish_English.keySet()==null)
            System.out.println("This is empty");



        English_ModernGreek = Parser.Parsing(9);
        languageMaps.put("English_ModernGreek", English_ModernGreek );
        if (English_ModernGreek.keySet() == null) {
            System.out.println("English to Modern Greek is empty");
        }

        English_German = Parser.Parsing(10);
        languageMaps.put("English_German",English_German  );
        if (English_German.keySet() == null) {
            System.out.println("English to German is empty");
        }

        English_French = Parser.Parsing(11);
        languageMaps.put("English_French", English_French  );
        if (English_French.keySet() == null) {
            System.out.println("English_French is empty");
        }



        English_Swedish = Parser.Parsing(12);
        languageMaps.put("English_Swedish", English_Swedish  );
        if (English_Swedish.keySet() == null) {
            System.out.println("English_Swedish is empty");
        }

        English_Turkish = Parser.Parsing(13);
        languageMaps.put("English_Turkish",  English_Turkish );
        if (English_Turkish.keySet() == null) {
            System.out.println("English_Turkish is empty");
        }

        French_German = Parser.Parsing(14);
        languageMaps.put("French_German", French_German );
        if (French_German.keySet() == null) {
            System.out.println("French_German is empty");
        }

        French_ModernGreek = Parser.Parsing(15);
        languageMaps.put("French_ModernGreek",  French_ModernGreek );
        if (French_ModernGreek.keySet() == null) {
            System.out.println("French_ModernGreek is empty");
        }

        French_English = Parser.Parsing(16);
        languageMaps.put("French_English",  French_English );
        if (French_English.keySet() == null) {
            System.out.println("French_English is empty");
        }

        French_Italian = Parser.Parsing(17);
        languageMaps.put("French_Italian",French_Italian  );
        if (French_Italian.keySet() == null) {
            System.out.println("French_Italian is empty");
        }

        French_Swedish = Parser.Parsing(18);
        languageMaps.put("French_Swedish",French_Swedish  );
        if (French_Swedish.keySet() == null) {
            System.out.println("French_Swedish is empty");
        }

        French_Turkish = Parser.Parsing(19);
        languageMaps.put("French_Turkish",French_Turkish  );
        if (French_Turkish.keySet() == null) {
            System.out.println("French_Turkish is empty");
        }

        Italian_German = Parser.Parsing(20);
        languageMaps.put("Italian_German",Italian_German   );
        if (Italian_German.keySet() == null) {
            System.out.println("Italian_German is empty");
        }

        Italian_ModernGreek = Parser.Parsing(21);
        languageMaps.put("Italian_ModernGreek", Italian_ModernGreek  );
        if (Italian_ModernGreek.keySet() == null) {
            System.out.println("Italian_ModernGreek is empty");
        }

        Italian_English = Parser.Parsing(22);
        languageMaps.put("Italian_English", Italian_English  );
        if (Italian_English.keySet() == null) {
            System.out.println("Italian_English is empty");
        }

        Italian_Swedish = Parser.Parsing(23);
        languageMaps.put("Italian_Swedish", Italian_Swedish );
        if (Italian_Swedish.keySet() == null) {
            System.out.println("Italian_Swedish is empty");
        }

        Italian_Turkish = Parser.Parsing(24);
        languageMaps.put("Italian_Turkish",Italian_Turkish  );
        if (Italian_Turkish.keySet() == null) {
            System.out.println("Italian_Turkish is empty");
        }

        Swedish_German = Parser.Parsing(25);
        languageMaps.put("Swedish_German",Swedish_German  );
        if (Swedish_German.keySet() == null) {
            System.out.println("Swedish_German is empty");
        }

        Swedish_English = Parser.Parsing(26);
        languageMaps.put("Swedish_English",Swedish_English  );
        if (Swedish_English.keySet() == null) {
            System.out.println("Swedish_English is empty");
        }

        Swedish_French = Parser.Parsing(27);
        languageMaps.put("Swedish_French",Swedish_French  );
        if (Swedish_French.keySet() == null) {
            System.out.println("Swedish_French is empty");
        }

        Swedish_Italian = Parser.Parsing(28);
        languageMaps.put("Swedish_Italian",Swedish_Italian  );

        if (Swedish_Italian.keySet()==null)
            System.out.println("This is empty");

        Swedish_Turkish = Parser.Parsing(29);
        languageMaps.put("Swedish_Turkish",Swedish_Turkish  );

        if (Swedish_Turkish.keySet()==null)
            System.out.println("This is empty");

        English_Italian = Parser.Parsing(30);
        languageMaps.put("English_Italian",English_Italian  );
        if (English_Italian.keySet() == null) {
            System.out.println("English_Italian is empty");
        }
        German_Turkish = Parser.Parsing(31);
        languageMaps.put("German_Turkish",  German_Turkish );
        if (German_Turkish.keySet() == null) {
            System.out.println("German to Turkish is empty");
        }

        German_Italian = Parser.Parsing(32);
        languageMaps.put("German_Italian",German_Italian);
        if (German_Italian.keySet() == null) {
            System.out.println("German to Italian is empty");
        }
        H_List.setOnMouseClicked(e -> {
            String selectedItem = H_List.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                if(selectedItem.contains("_")){
                    Languages=selectedItem.split("_");
                    comboBox1.setValue(Languages[0]);
                    comboBox2.setValue(Languages[1]);
                }
            }
        });


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
                H_List.setOnMouseClicked(e -> {
                    String selectedItem = H_List.getSelectionModel().getSelectedItem();
                    if (selectedItem != null) {
                        textArea1.setText(selectedItem);
                    }
                });


            }}
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
                        H_List.setOnMouseClicked(e -> {
                            String selectedItem = H_List.getSelectionModel().getSelectedItem();
                            if (selectedItem != null) {
                                textArea1.setText(selectedItem);
                            }
                        });

                }

                }

        }});

    }

    public void Clear () {
        textArea1.setText("");
        textArea2.setText("");
        System.out.println("Deleted");

    }
    String[] Synonyms;
    public String[] Translate(){//Translates the given word in the desired language

        String[] Boş = new String[0];

        String Searchword=textArea1.getText();
        String selectedLanguagePair = selectedLanguage1 + "_" + selectedLanguage2;
        if (languageMaps.containsKey(selectedLanguagePair)) {
            HashMap<String, String> selectedLanguageMap = languageMaps.get(selectedLanguagePair);
            String translation = selectedLanguageMap.get(Searchword);
             Synonyms = translation.split("/synonym: ");
            String wantedtrans=Synonyms[0];
            if (wantedtrans != null) {
                textArea1.setText(Searchword);
                textArea2.setText(wantedtrans);
                String[] translationhistory = {selectedLanguage1,selectedLanguage2,Searchword,wantedtrans};
                History.add(translationhistory);
                return Synonyms;


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

                if(translationcheck!=null&&wordexist==true){
                    String indirecttranslation=tempLanguageMap2.get(tempLanguageMap1.get(Searchword));
                     Synonyms = indirecttranslation.split("/synonym: ");
                    String wantedtrans=Synonyms[0];
                    textArea1.setText(Searchword);
                    textArea2.setText(wantedtrans);
                    String[] translationhistory = {selectedLanguage1,selectedLanguage2,Searchword,wantedtrans};
                    History.add(translationhistory);
                    return Synonyms;


                }
                else System.out.println("The word you searched for was not found .");
            }
        }
    return Synonyms;
    }
    public  void Replace(){
        String s1 = comboBox1.getValue();
        String s2 = comboBox2.getValue();
        int temp = comboBox1.getSelectionModel().getSelectedIndex();
        comboBox1.getSelectionModel().select(comboBox2.getSelectionModel().getSelectedIndex());
        comboBox2.getSelectionModel().select(temp);
    }
    public void Add(){

    }
    public void Edit(){

    }
    public void Delete(){

    }
    String[]Languages;
    public void FindLanguage() {
        String Searchword=textArea1.getText();
        ArrayList<String>AvailableLanguages=new ArrayList<>();

        H_List.getItems().clear();
        for (String key : languageMaps.keySet()) {
            HashMap<String, String> innerHashMap = languageMaps.get(key);

            if (innerHashMap.containsKey(Searchword)) {
                AvailableLanguages.add(key);
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
        }

