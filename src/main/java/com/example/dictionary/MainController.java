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



    private Translation deu_ell;
    private Translation deu_eng;
    private Translation deu_fra;
    private Translation deu_ita;
    private Translation deu_swe;
    private Translation deu_tur;

    private Translation ell_eng;
    private Translation ell_fra;
    private Translation ell_ita;


    private Translation eng_deu;
    private Translation eng_ell;
    private Translation eng_fra;
    private Translation eng_ita;
    private Translation eng_swe;
    private Translation eng_tur;

    private Translation fra_deu;
    private Translation fra_ell;
    private Translation fra_eng;
    private Translation fra_ita;
    private Translation fra_swe;
    private Translation fra_tur;

    private Translation ita_deu;
    private Translation ita_ell;
    private Translation ita_eng;
    private Translation ita_swe;
    private Translation ita_tur;

    private Translation swe_deu;
    private Translation swe_eng;
    private Translation swe_fra;
    private Translation swe_ita;
    private Translation swe_tur;

    private Translation tur_deu;
    private Translation tur_eng;


    private TEIParser Parser;

    public void initialize() {
        // set the prompt text and items for the combo boxes
        comboBox1.setPromptText("Language");
        comboBox1.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");

        comboBox2.setPromptText("Language");
        comboBox2.getItems().addAll("English","French","German","Turkish","Italian","Swedish" ,"Modern Greek");

        // set the text for the text areas
        textArea1.setPromptText("Enter text here");
        textArea2.setPromptText("Translated text will apear here");

        Parser = new TEIParser();
        H_List.setItems(FXCollections.observableArrayList());


        HashMap<String,String>tempdeu_ell = Parser.Parsing(0);

        deu_ell = new Translation("deu_ell",tempdeu_ell);

        if (deu_ell.getTranslation().keySet()==null){
            System.out.println("This is empty");}

        HashMap<String,String>tempdeu_eng = Parser.Parsing(1);

        deu_eng = new Translation("deu_eng",tempdeu_eng);

        if (deu_eng.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempdeu_fra = Parser.Parsing(2);

        deu_fra = new Translation("deu_fra",tempdeu_fra);

        if (deu_fra.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempdeu_swe = Parser.Parsing(3);

        deu_swe = new Translation("deu_swe",tempdeu_swe);

        if (deu_swe.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempell_eng = Parser.Parsing(4);

        ell_eng = new Translation("ell_eng",tempell_eng);

        if (ell_eng.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempell_fra = Parser.Parsing(5);

        ell_fra = new Translation("ell_fra",tempell_fra);

        if (ell_fra.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempell_ita = Parser.Parsing(6);

        ell_ita = new Translation("ell_ita",tempell_ita);

        if (ell_ita.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>temptur_deu = Parser.Parsing(7);

        tur_deu = new Translation("tur_deu",temptur_deu);

        if (tur_deu.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>temptur_eng = Parser.Parsing(8);

        tur_eng = new Translation("tur_eng",temptur_eng);

        if (tur_eng.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempeng_ell = Parser.Parsing(9);

        eng_ell = new Translation("eng_ell",tempeng_ell);

        if (eng_ell.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempeng_deu = Parser.Parsing(10);

        eng_deu = new Translation("eng_deu",tempeng_deu);

        if (eng_deu.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempeng_fra = Parser.Parsing(11);

        eng_fra = new Translation("eng_fra",tempeng_fra);

        if (eng_fra.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempeng_swe = Parser.Parsing(12);

        eng_swe = new Translation("eng_swe",tempeng_swe);

        if (eng_swe .getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempeng_tur = Parser.Parsing(13);

        eng_tur = new Translation("eng_tur",tempeng_tur);

        if (eng_tur.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempfra_deu = Parser.Parsing(14);

        fra_deu = new Translation("fra_deu",tempfra_deu);

        if (fra_deu.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempfra_ell = Parser.Parsing(15);

        fra_ell = new Translation("fra_ell",tempfra_ell);

        if (fra_ell.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempfra_eng = Parser.Parsing(16);

        fra_eng = new Translation("fra_eng",tempfra_eng);

        if (fra_eng.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempfra_ita = Parser.Parsing(17);

        fra_ita = new Translation("fra_ita",tempfra_ita);

        if (fra_ita.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempfra_swe = Parser.Parsing(18);

        fra_swe = new Translation("fra_swe",tempfra_swe);

        if (fra_swe.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempfra_tur = Parser.Parsing(19);

        fra_tur = new Translation("fra_tur",tempfra_tur);

        if (fra_tur.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempita_deu = Parser.Parsing(20);

        ita_deu = new Translation("ita_deu",tempita_deu);

        if (ita_deu.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempita_ell = Parser.Parsing(21);

        ita_ell = new Translation("ita_ell",tempita_ell);

        if (ita_ell .getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempita_eng = Parser.Parsing(22);

        ita_eng = new Translation("ita_eng",tempita_eng);

        if (ita_eng.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempita_swe = Parser.Parsing(23);

        ita_swe = new Translation("ita_swe",tempita_swe);

        if (ita_swe.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempita_tur = Parser.Parsing(24);

        ita_tur = new Translation("ita_tur",tempita_tur);

        if (ita_tur.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempswe_deu = Parser.Parsing(25);

        swe_deu = new Translation("swe_deu",tempswe_deu);

        if (swe_deu.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempswe_eng = Parser.Parsing(26);

        swe_eng = new Translation("swe_eng",tempswe_eng);

        if (swe_eng.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempswe_fra = Parser.Parsing(27);

        swe_fra = new Translation("swe_fra",tempswe_fra);

        if (swe_fra.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempswe_ita = Parser.Parsing(28);

        swe_ita = new Translation("swe_ita",tempswe_ita);

        if (swe_ita.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempswe_tur = Parser.Parsing(29);

        swe_tur = new Translation("swe_tur",tempswe_tur);

        if (swe_tur.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempeng_ita = Parser.Parsing(30);

        eng_ita = new Translation("eng_ita",tempeng_ita);

        if (eng_ita.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempdeu_tur = Parser.Parsing(31);

        deu_tur = new Translation("tur_eng",tempdeu_tur);

        if (deu_tur.getTranslation().keySet()==null)
            System.out.println("This is empty");

        HashMap<String,String>tempdeu_ita = Parser.Parsing(32);

        deu_ita = new Translation("deu_ita",tempdeu_ita);

        if (deu_ita.getTranslation().keySet()==null)
            System.out.println("This is empty");


/*
        // Add listener for textArea1
        textArea1.textProperty().addListener((observable, oldValue, newValue) -> {
            H_List.getItems().clear();
            String searchWord = textArea1.getText();

            String regex = "(?i)" + searchWord + "\\w*";
            boolean hasMatches = eng_deu.getTranslation().keySet()
                    .stream()
                    .anyMatch(key -> key != null && key.matches(regex));

            if (hasMatches) {
                eng_deu.getTranslation().keySet()
                        .stream()
                        .filter(key -> key != null && key.matches(regex))
                        .forEach(H_List.getItems()::add);
            }

        });*/

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
           if(  eng_deu.getTranslation().containsKey(Searchword)) {
               String value=  eng_deu.getTranslation().get(key);
               textArea1.setText(key);
               textArea2.setText(value);
           }
           else System.out.println("There is no such word in this file");
           }
        else if(s1=="English"&&s2=="Modern Greek"){
            String key = Searchword;
            if(  eng_ell.getTranslation().containsKey(Searchword)) {
                String value=  eng_ell.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="English"&&s2=="French"){
            String key = Searchword;
            if(  eng_fra.getTranslation().containsKey(Searchword)) {
                String value=  eng_fra.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="English"&&s2=="Swedish"){
            String key = Searchword;
            if(  eng_swe.getTranslation().containsKey(Searchword)) {
                String value=  eng_swe.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="English"&&s2=="Turkish"){
            String key = Searchword;
            if(  eng_tur.getTranslation().containsKey(Searchword)) {
                String value=  eng_tur.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="English"&&s2=="Italian"){
            String key = Searchword;
            if(  eng_ita.getTranslation().containsKey(Searchword)) {
                String value=  eng_ita.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }

        //Switching to first box to German
        else if(s1=="German"&&s2=="Modern Greek"){
            String key = Searchword;
            if(  deu_ell.getTranslation().containsKey(Searchword)) {
                String value=  deu_ell.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);

            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="German"&&s2=="English"){
            String key = Searchword;
            if(  deu_eng.getTranslation().containsKey(Searchword)) {
                String value=  deu_eng.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);


            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="German"&&s2=="French"){
            String key = Searchword;
            if(  deu_fra.getTranslation().containsKey(Searchword)) {
                String value=  deu_fra.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="German"&&s2=="Swedish"){
            String key = Searchword;
            if(  deu_swe.getTranslation().containsKey(Searchword)) {
                String value=  deu_swe.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="German"&&s2=="Turkish"){
            String key = Searchword;
            if(  deu_tur.getTranslation().containsKey(Searchword)) {
                String value=  deu_tur.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="German"&&s2=="Italian"){
            String key = Searchword;
            if(  deu_ita.getTranslation().containsKey(Searchword)) {
                String value=  deu_ita.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }


        //Switching first language box to Modern Greek
        else if(s1=="Modern Greek"&&s2=="English"){
            String key = Searchword;
            if(  ell_eng.getTranslation().containsKey(Searchword)) {
                String value=  ell_eng.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Modern Greek"&&s2=="French"){
            String key = Searchword;
            if(  ell_fra.getTranslation().containsKey(Searchword)) {
                String value=  ell_fra.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Modern Greek"&&s2=="Italian"){
            String key = Searchword;
            if(  ell_ita.getTranslation().containsKey(Searchword)) {
                String value=  ell_ita.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        //İndirect translation
        else if(s1=="Modern Greek"&&s2=="German"){
            String key = Searchword;
            if(ell_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= ell_eng.getTranslation().get(key);


                if(eng_deu.getTranslation().containsKey(engSearchWord)){
                    String value=eng_deu.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }
        //İndirect translation

        else if(s1=="Modern Greek"&&s2=="Turkish"){
            String key = Searchword;
            if(ell_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= ell_eng.getTranslation().get(key);


                if(eng_tur.getTranslation().containsKey(engSearchWord)){
                    String value=eng_tur.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }
        //İndirect translation

        else if(s1=="Modern Greek"&&s2=="Swedish"){
            String key = Searchword;
            if(ell_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= ell_eng.getTranslation().get(key);


                if(eng_swe.getTranslation().containsKey(engSearchWord)){
                    String value=eng_swe.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }










        //Switching first language box to Turkish
        else if(s1=="Turkish"&&s2=="German"){
            String key = Searchword;
            if(  tur_deu.getTranslation().containsKey(Searchword)) {
                String value=  tur_deu.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Turkish"&&s2=="English"){
            String key = Searchword;
            if(  tur_eng.getTranslation().containsKey(Searchword)) {
                String value=  tur_eng.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        //İndirect translation
        else if(s1=="Turkish"&&s2=="Modern Greek"){
            String key = Searchword;
            if(tur_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= tur_eng.getTranslation().get(key);


                if(eng_ell.getTranslation().containsKey(engSearchWord)){
                    String value=eng_ell.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }
        //İndirect translation

        else if(s1=="Turkish"&&s2=="Italian"){
            String key = Searchword;
            if(tur_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= tur_eng.getTranslation().get(key);


                if(eng_ita.getTranslation().containsKey(engSearchWord)){
                    String value=eng_ita.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }
        //İndirect translation

        //Translated twice (once from Turk
        else if(s1=="Turkish"&&s2=="Swedish"){
            String key = Searchword;
            if(tur_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= tur_eng.getTranslation().get(key);


                if(eng_swe.getTranslation().containsKey(engSearchWord)){
                    String value=eng_swe.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }
        //İndirect translation
        else if(s1=="Turkish"&&s2=="French"){
            String key = Searchword;
            if(tur_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= tur_eng.getTranslation().get(key);


                if(eng_fra.getTranslation().containsKey(engSearchWord)){
                    String value=eng_fra.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }



        //Switching first language to French
        else if(s1=="French"&&s2=="German"){
            String key = Searchword;
            if(  fra_deu.getTranslation().containsKey(Searchword)) {
                String value=  fra_deu.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="French"&&s2=="Modern Greek"){
            String key = Searchword;
            if(  fra_ell.getTranslation().containsKey(Searchword)) {
                String value=  fra_ell.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="French"&&s2=="English"){
            String key = Searchword;
            if(  fra_eng.getTranslation().containsKey(Searchword)) {
                String value=  fra_eng.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="French"&&s2=="Italian"){
            String key = Searchword;
            if(  fra_ita.getTranslation().containsKey(Searchword)) {
                String value=  fra_ita.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="French"&&s2=="Swedish"){
            String key = Searchword;
            if(  fra_swe.getTranslation().containsKey(Searchword)) {
                String value=  fra_swe.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }



        //Swithing first language box to Italian
        else if(s1=="Italian"&&s2=="German"){
            String key = Searchword;
            if(  ita_deu.getTranslation().containsKey(Searchword)) {
                String value=  ita_deu.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Italian"&&s2=="Modern Greek"){
            String key = Searchword;
            if(  ita_ell.getTranslation().containsKey(Searchword)) {
                String value=  ita_ell.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Italian"&&s2=="English"){
            String key = Searchword;
            if(  ita_eng.getTranslation().containsKey(Searchword)) {
                String value=  ita_eng.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Italian"&&s2=="Swedish"){
            String key = Searchword;
            if(  ita_swe.getTranslation().containsKey(Searchword)) {
                String value=  ita_swe.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Italian"&&s2=="Turkish"){
            String key = Searchword;
            if(  ita_tur.getTranslation().containsKey(Searchword)) {
                String value=  ita_tur.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }

        //İndirect translation
        else if(s1=="Italian"&&s2=="French"){
            String key = Searchword;
            if(ita_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= ita_eng.getTranslation().get(key);


                if(eng_fra.getTranslation().containsKey(engSearchWord)){
                    String value=eng_fra.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
        }




        //Switching first language box to Swedish
        else if(s1=="Swedish"&&s2=="German"){
            String key = Searchword;
            if(  swe_deu.getTranslation().containsKey(Searchword)) {
                String value=  swe_deu.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Swedish"&&s2=="English"){
            String key = Searchword;
            if(  swe_eng.getTranslation().containsKey(Searchword)) {
                String value=  swe_eng.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Swedish"&&s2=="French"){
            String key = Searchword;
            if(  swe_fra.getTranslation().containsKey(Searchword)) {
                String value=  swe_fra.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Swedish"&&s2=="Italian"){
            String key = Searchword;
            if(  swe_ita.getTranslation().containsKey(Searchword)) {
                String value=  swe_ita.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        else if(s1=="Swedish"&&s2=="Turkish"){
            String key = Searchword;
            if(  swe_tur.getTranslation().containsKey(Searchword)) {
                String value=  swe_tur.getTranslation().get(key);
                textArea1.setText(key);
                textArea2.setText(value);
            }
            else System.out.println("There is no such word in this file");
        }
        //Indirect translation
        else if(s1=="Swedish"&&s2=="Modern Greek"){
            String key = Searchword;
            if(swe_eng.getTranslation().containsKey(Searchword)){
                String engSearchWord= swe_eng.getTranslation().get(key);


                if(eng_ell.getTranslation().containsKey(engSearchWord)){
                    String value=eng_ell.getTranslation().get(engSearchWord);
                    textArea1.setText(key);
                    textArea2.setText(value);
                }

            }
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