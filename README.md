# play tuto

- https://www.playframework.com/documentation/1.5.x
- https://github.com/playframework/play1
- utilisation de eclipse... ça a l'air d'être l'IDE gratos le plus compatible avec cette techno


### questions générales sur playframework

https://www.playframework.com/documentation/1.5.x

- la conf à priori on la git pas... du coup on fait un .dist ? (jan fait plputôt un .model)
- pourquoi les méthodes des controller sont en static ?
- appeler des routes en javascript (ajax?)
- creation de formulaires basé sur les entités ? => module CRUD
- sécurité => module SECURITY
- utilisation des assets (minification, compilation...)
- @Entity field unique ??
- pas besoin de stipuler qu'on surcharge des méthodes ?
  - `controllers/Security.java` authenticate / check / onDisconnected / onAuthenticated
  
- retrouver les principes de définition de "block" de twig dans le système de templating
- debug ?
- CRUD généré, impossible de faire de la recherche multicritères ?

### pour charger les fixtures

> cette classe est à la racine du dossier `app` donc pas dans un package, pas de namespace...

```java
public class Bootstrap extends Job {
 
    public void doJob() {
        // Check if the database is empty
        //if(User.count() == 0 && !play.Play.runningInTestMode()) {
        if(User.count() == 0 && !play.Play.runningInTestMode()) {
        	
            Fixtures.loadModels("initial-data.yml");
        }
        // si j'ai ajouté des fixtures, les nouvelles ne seront pas ajoutées
        Fixtures.deleteAllModels(); // instead of deleteDatabase() -> avoid deleting hibernate_sequence
        Fixtures.loadModels("initial-data.yml");

    }
 
}
```
### dans les fixtures :

```yaml
Post(jeffPost):
    title:          The MVC application
    postedAt:       2009-06-06
    author:         jeff
    tags:
                    - play     # ici on fait référence à un tag qui a été déclaré *AVANT* dans les fixtures avec Tag(play)
                    - architecture
                    - mvc
    content:        >
                    A Play
 ```


### install

- `cd ~/projects`
- `git clone thirepository`
- `play eclispsify`

puis dans eclipse :

- File -> import -> existing project into workspace

\o/

- ensuite dans le projet
- cp conf/application.model.conf conf/application.conf
- play dependencies
- npm install
- npm run build
  


### dependencies

- lancer la commande `play dependencies` update le fichier conf/dependencies.conf
- lancer `play eclipsify`
- faire un refresh du projet dans eclipse

### CRUD

Then, in views/CRUD/layout.html, change the #{set 'moreStyles'} block to make it look like the following:

```
#{set 'moreStyles'}
    <link rel="stylesheet" type="text/css" media="screen" href="@{'/public/stylesheets/crud.css'}" />
    <link rel="stylesheet" type="text/css" media="screen" href="@{'/public/stylesheets/tags.css'}" />
#{/set}
```
.... ça marche pas...
 j'ai du l'ajouter dans crud/CRUD/views/layout.html
 
- j'ai aussi essayé la commande `play crud:override --layout` qui copie le fichier layout dans le bon répertoire, mais pas de `#{set 'moreStyles'}`
- OK voir pour la partie admin comment c'est gaulé

- dans ma logique CRUD/layout.html est sensé être le template de base
- puis admin.html hérite de layout.html
- sauf que du coup pour les templates non surchargés (genre Users/list.html) le système prend le layout uniquement...
- c'est pour ça que dans le tuto CRUD/layout hérite de admin.html


- @CRUD.For(Post.class) normalement pour le controller pas besoin de dire pour quelle entité c'est si on se contente de pluraliser l'entité concernée ie Post -> Posts
- @Check("admin")