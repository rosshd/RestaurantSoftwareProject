@echo off
echo Building the project and creating the JAR file...
call mvnw.cmd clean package

if exist target\restaurant-software-1.0-SNAPSHOT.jar (
    echo Build successful!
) else (
    echo Build failed. Check project structure or Java setup.
)

pause
