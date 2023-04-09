plugins {
    id("application")
    id("org.openjfx.javafxplugin") version ("0.0.13")
}

javafx {
    version = "20"
    modules("javafx.controls", "javafx.fxml")
}


repositories {
    mavenCentral()
}

application {
    mainClass.set("com.ce216.dictionary.App")
}