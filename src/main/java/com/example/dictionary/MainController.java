package com.example.dictionary;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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


    private Translation translation;

    public void initialize() {
        // set the prompt text and items for the combo boxes
        comboBox1.setPromptText("Language");
        comboBox1.getItems().addAll("English", "French", "German", "Turkish", "Italian", "Swedish" , "Modern Greek");

        comboBox2.setPromptText("Language");
        comboBox2.getItems().addAll("English", "French", "German", "Turkish", "Italian", "Swedish" , "Modern Greek");

        // set the text for the text areas
        textArea1.setPromptText("Enter text here");
        textArea2.setPromptText("Translated text will apear here");





    }



    public void Clear () {
        textArea1.setText("");
        textArea2.setText("");
        System.out.println("SİLİNDİ");

    }
    public void Langperm(){

        String s1 = comboBox1.getValue();
        String s2 = comboBox2.getValue();



    }

    public String translateNow(){
       String Searchword=textArea1.getText();
       return Searchword;



        //textArea2.setText(HashMap);

    }

}