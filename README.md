# Personnages Wiki

## Lancer le backend (sans installer Maven)

À la racine du projet :

```powershell
.\mvnw.cmd spring-boot:run
```

Au premier lancement, le script télécharge le Maven Wrapper puis Maven. L’API sera disponible sur http://localhost:8080/api.

## Lancer le frontend
```powershell
cd .\frontend\
npm install
ng serve
```
