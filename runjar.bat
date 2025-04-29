@echo off
echo Running the JAR file...
java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar target\restaurant-software-1.0-SNAPSHOT.jar
pause
