package com.example.ce26projecttest;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;






import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.sun.javafx.application.PlatformImpl.exit;

public class CE26ProjectTest extends Application {

    private ListView<String> listView;
    private TextField searchBox;

    private Map<String, Map<String,String>> dictionary;

    @Override
    public void start(Stage primaryStage) throws Exception {


        dictionary = new HashMap<String, Map<String, String>>();
        loadDictionary();


        // Create the search box
        searchBox = new TextField();
        searchBox.setPromptText("Enter a word to search");

        // Create the search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> searchWord());

        // Create the add button
        Button addButton = new Button("Add");
        //addButton.setOnAction(e -> addWord());

        // Create the edit button
        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> editWord());

        // Create the synonyms button
        Button synonymsButton = new Button("Synonyms");
        synonymsButton.setOnAction(e -> showSynonyms());

        // Create the buttons box
        HBox buttonsBox = new HBox(10, searchBox, searchButton, addButton, editButton, synonymsButton);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setPadding(new Insets(10));

        // Create the list view
        listView = new ListView<String>();

        // Create the menu bar
        MenuBar menuBar = new MenuBar();

        // Create the file menu
        Menu fileMenu = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exitMenuItem);

        // Create the help menu
        Menu helpMenu = new Menu("Help");
        MenuItem manualMenuItem = new MenuItem("Manual");
        manualMenuItem.setOnAction(e -> showManual());
        helpMenu.getItems().add(manualMenuItem);

        // Add the menus to the menu bar
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Create the root pane
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(listView);
        root.setBottom(buttonsBox);

        // Create the scene and show the stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadDictionary() {
        try {
            // Load the dictionary files for each language
            String[] languages = {"English", "French", "German", "Turkish", "Italian", "Swedish", "Modern Greek"};
            for (String language : languages) {
                Map<String, String> translations = new HashMap<String, String>();
                BufferedReader reader = new BufferedReader(new FileReader(new File(language + ".txt")));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        translations.put(parts[0], parts[1]);
                    }
                }
                dictionary.put(language, translations);
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load the dictionary files", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                exit();
            }
        }
    }



    private void searchWord() {
        String word = searchBox.getText().trim().toLowerCase();
        if (!word.isEmpty()) {
            List<String> translations = new ArrayList<String>();
            for (Map.Entry<String, Map<String, String>> entry : dictionary.entrySet()) {
                String language = entry.getKey();
                Map<String, String> translationsMap = entry.getValue();
                if (translationsMap.containsKey(word)) {
                    String translation = translationsMap.get(word);
                    translations.add(language + ": " + translation);
                }
            }
            if (translations.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Word not found", ButtonType.OK);
                alert.showAndWait();
            } else {
                listView.getItems().setAll(translations);
            }
        }
    }


    /* private void addWord() {
        // Get the word and translation from the user
        String word = showTextInputDialog("Add Word", "Enter the word:");
        if (word == null || word.isEmpty()) {
            return;
        }
        String translation = showTextInputDialog("Add Word", "Enter the translation:");
        if (translation == null || translation.isEmpty()) {
            return;
        }

        // Add the word to the dictionary
        Map<String, String> translations = dictionary.get("English");
        translations.put(word.toLowerCase(), translation);

        // Save the dictionary
        saveDictionary();

        // Show a confirmation message
        showAlert("Information", "Word added successfully.");
    }

     */

    private void editWord() {
        // Implement edit functionality
    }

    private void showSynonyms() {
        // Implement synonyms functionality
    }

    private void showManual() {
        // Implement manual functionality
    }

    public static void main(String[] args) {
        launch(args);
    }
}
