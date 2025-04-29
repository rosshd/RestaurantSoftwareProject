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

# Build and Run Jar file

If you want to run the project without IntelliJ:

1. Go to https://gluonhq.com/products/javafx/
2. Download the JavaFX SDK for Windows.
3. Extract it to `C:\`, so you should have a folder like `C:\javafx-sdk-24.0.1`.

4. Double-click `buildjar.bat` in the project folder.
   - This will automatically build the `restaurant-software-1.0-SNAPSHOT.jar` without needing Maven installed manually.

5. After building, double-click `runjar.bat`.
   - This will launch the application using the JavaFX SDK.

6. (Optional) If you extracted JavaFX to a different directory, edit `runjar.bat` and change the module path.
   Example:
   ```
   java --module-path "D:\user\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar target\restaurant-software-1.0-SNAPSHOT.jar
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
 ├── .mvn/ (Maven Wrapper files)
 ├── mvnw
 ├── mvnw.cmd
 ├── buildjar.bat (builds the JAR)
 ├── runjar.bat (runs the JAR)
 ├── pom.xml
 └── README.md (this file)
```