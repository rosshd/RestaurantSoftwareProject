# Restaurant Software (JavaFX)

Simple restaurant management system built using JavaFX.

## Requirements

- IntelliJ IDEA (Community Edition is fine)
- Java 17 or newer (tested on Java 24.0.1)
- Internet connection (to download Maven dependencies automatically)

## How to Open and Run

## Steps
1. Install IntelliJ IDEA.
2. Open IntelliJ → **File → New → Project from Version Control** → Paste the GitHub URL.
3. IntelliJ will detect the `pom.xml` and auto-import the Maven project.
4. Open the Maven panel (right side of IntelliJ).
5. Expand `Lifecycle` → Double-click `install`.
6. Expand `Plugins` → `javafx` → Double-click `javafx:run`.
7. The app will start.

OR Right click in file explorer, click show more options, click open git bash here in the project root directory
type:
mvn clean install
mvn javafx:run

✅ No terminal needed.  
✅ No separate Maven install needed.

## Project Structure

