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

Le front devrait être servi sur http://localhost:4200/

## Accès à la base de données
url: http://localhost:8080/h2-console/login.jsp
Jdbc url: jdbc:h2:file:{pathfile}/data/personnagedb;AUTO_SERVER=TRUE
username: sa

## Potentiel problème
Dans le cas où le npm install ne permet pas de lancer le frontend du à des problèmes de packages, un clean reinstall est possible avec:
```powershell
Remove-Item -Recurse -Force .\node_modules
Remove-Item -Force .\package-lock.json  
npm cache clean --force
npm install
ng serve
```

