# Restaurant Software (JavaFX)

Simple restaurant management system built using JavaFX.

## Requirements

- IntelliJ IDEA (Community Edition is fine)
- Java 24.0.1
- Internet connection (to download Maven dependencies automatically)

## How to Open and Run

# Setup Instructions
1. Download and install Java 24 (or Java 21+). You can also install Java 24 through IntelliJ under Project Structure if you don't have it installed yet.
2. **Add Java 24.0.1 to your system PATH** (important if running the jar manually).
   - In IntelliJ, find where Java 24 is installed. It should be something like: `C:/Users/yourpcusername/.jdks/openjdk-24.0.1`
   - Press the Windows key, search for **"Edit the system environment variables"**, and open it.
   - Under **System Variables**, create a new variable called `JAVA_HOME` if it doesn't exist, or edit it if it does.
     - Set `JAVA_HOME` to the directory: `C:/Users/yourpcusername/.jdks/openjdk-24.0.1`
   - Under **System Variables**, edit the `Path` variable.
     - Click **New** and add: `%JAVA_HOME%\bin`
     - Move this entry above any other old Java paths if they exist.
   - Click OK to save everything.
   - To test if it worked, open Command Prompt and run:
     ```
     java -version
     ```
     It should print:
     ```
     java version "24.0.1"
     ```

3. Open this project in IntelliJ IDEA.
   - Click **Get from VCS** and paste this URL:  
     `https://github.com/rosshd/RestaurantSoftwareProject.git`

4. IntelliJ will automatically detect Maven and set up the project.
   - Accept any prompts to enable Maven auto-import if asked.

5. To run the project inside IntelliJ:
   - Click the **M** button (Maven tab on the right side).
   - Expand **Plugins** → **javafx** → double-click **`javafx:run`** to run the project.

# Run Jar file
1. Go to https://gluonhq.com/products/javafx/
2. Download the JavaFX SDK for Windows.
3. Extract it to `C:\`, so you should have a folder like `C:\javafx-sdk-24.0.1`.
4. Open Command Prompt inside the project folder and run:
   ```
   java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar target/restaurant-software-1.0-SNAPSHOT.jar
   ```
5. If you extracted JavaFX to a different directory, update the path in the command above to match your location.
6. (Optional) You can edit `runjar.bat` to automatically use your custom JavaFX SDK path, for example:
   ```
   java --module-path "D:\user\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar target/restaurant-software-1.0-SNAPSHOT.jar
   ```

## Project Structure

```
RestaurantSoftware/
 ├── src/
 │   └── main/
 │       ├── java/
 │       │    └── (your Java source files)
 │       └── resources/
 │            └── (FXML, CSS, other assets)
 ├── target/
 │    └── (compiled .class files and built .jar file)
 ├── pom.xml (Maven configuration file)
 ├── README.md (this file)
 └── runjar.bat (optional batch file to run jar easily)
```