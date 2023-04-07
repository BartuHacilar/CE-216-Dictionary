package com.example.dictionary;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

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




    private Translation eng_deutrans;

    private TEIParser Parser;

    public void initialize() {
        // set the prompt text and items for the combo boxes
        comboBox1.setPromptText("Language");
        comboBox1.getItems().addAll("English", "French", "German", "Turkish", "Italian", "Swedish" , "Modern Greek");

        comboBox2.setPromptText("Language");
        comboBox2.getItems().addAll("English", "French", "German", "Turkish", "Italian", "Swedish" , "Modern Greek");

        // set the text for the text areas
        textArea1.setPromptText("Enter text here");
        textArea2.setPromptText("Translated text will apear here");

        Parser = new TEIParser();
        HashMap<String,String>tempeng_deu = Parser.Parsing(11);

        eng_deutrans = new Translation("eng_deu",tempeng_deu);
        H_List.setItems(FXCollections.observableArrayList());
        if (eng_deutrans.getTranslation().keySet()==null)
            System.out.println("bu boş la");


        // ... your existing code ...

        // Add listener for textArea1
        textArea1.textProperty().addListener((observable, oldValue, newValue) -> {
            H_List.getItems().clear();
            String searchWord = textArea1.getText();

            String regex = "(?i)" + searchWord + "\\w*";
            boolean hasMatches = eng_deutrans.getTranslation().keySet()
                    .stream()
                    .anyMatch(key -> key != null && key.matches(regex));

            if (hasMatches) {
                eng_deutrans.getTranslation().keySet()
                        .stream()
                        .filter(key -> key != null && key.matches(regex))
                        .forEach(H_List.getItems()::add);
            }

        });

    }

    public void Clear () {
        textArea1.setText("");
        textArea2.setText("");
        System.out.println("SİLİNDİ");

    }

    public void Translate(){
        String Searchword=textArea1.getText();

        String s1 = comboBox1.getValue();
        String s2 = comboBox2.getValue();

        if(s1=="English"&&s2=="German"){
            String key = Searchword;
           if(  eng_deutrans.getTranslation().containsKey(Searchword)) {
               String value=  eng_deutrans.getTranslation().get(key);
               textArea1.setText(key);
               textArea2.setText(value);
           }
           else System.out.println("There is no such word in this file");
           }
        }

    public  void Replace(){
        String s1 = comboBox1.getValue();
        String s2 = comboBox2.getValue();
        int temp = comboBox1.getSelectionModel().getSelectedIndex();
        comboBox1.getSelectionModel().select(comboBox2.getSelectionModel().getSelectedIndex());
        comboBox2.getSelectionModel().select(temp);
    }

}