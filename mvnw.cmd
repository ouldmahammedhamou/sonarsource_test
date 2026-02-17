@REM ----------------------------------------------------------------------------
@REM Maven Wrapper - lance Maven sans avoir "mvn" installe
@REM Usage: mvnw.cmd spring-boot:run
@REM ----------------------------------------------------------------------------
@echo off
setlocal

set MAVEN_PROJECTBASEDIR=%~dp0
if not "%MAVEN_PROJECTBASEDIR%"=="" set MAVEN_PROJECTBASEDIR=%MAVEN_PROJECTBASEDIR:~0,-1%

if "%JAVA_HOME%"=="" (
  where java >nul 2>&1
  if errorlevel 1 (
    echo Erreur: Java introuvable. Installez JDK 17 ou definissez JAVA_HOME.
    exit /b 1
  )
  set "JAVA_CMD=java"
) else (
  set "JAVA_CMD=%JAVA_HOME%\bin\java.exe"
  if not exist "%JAVA_CMD%" set "JAVA_CMD=java"
)

set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_URL=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar

if not exist %MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar (
  echo Telechargement du Maven Wrapper...
  powershell -NoProfile -ExecutionPolicy Bypass -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object Net.WebClient).DownloadFile('%WRAPPER_URL%', '%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar')"
  if errorlevel 1 (
    echo Erreur lors du telechargement. Verifiez votre connexion.
    exit /b 1
  )
)

"%JAVA_CMD%" -classpath "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar" "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %*
exit /b %ERRORLEVEL%
