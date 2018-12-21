# play tuto

https://www.playframework.com/documentation/1.5.x/guide2

- Pour rendre le projet compatible avec netbeans (pouvoir l'ouvrir) la commande `play netbeansify myApp`est utilisée.
- Elle a pour effet de créer un répertoire nbproject dans lequel se trouve le fichier `project.xml`
- Dans ce fichier :

```
<java-data xmlns="http://www.netbeans.org/ns/freeform-project-java/2">
    <compilation-unit>
        <package-root>app</package-root>
        <package-root>test</package-root>
        <package-root>/opt/play/modules/docviewer/app</package-root>
        <classpath mode="compile">/home/patrick/projects/yabe/conf;/opt/play/framework/play-1.5.2.jar;/opt/play/modules/docviewer/lib/play-docviewer.jar;/opt/play/framework/lib/commons-email-1.4.jar;/opt/play/framework/lib/xmlpull-1.1.3.4d_b4_min.jar;/opt/play/framework/lib/jj-wikitext.jar;/opt/play/framework/lib/javax.inject-1.0.jar;/opt/play/framework/lib/jsr107cache-1.1.jar;/opt/play/framework/lib/hamcrest-all-1.3.jar;/opt/play/framework/lib/hibernate-jpa-2.1-api-1.0.0.Final.jar;/opt/play/framework/lib/dom4j-1.6.1.jar;/opt/play/framework/lib/xstream-1.4.9.jar;/opt/play/framework/lib/signpost-core-1.2.1.2.jar;/opt/play/framework/lib/byte-buddy-1.8.17.jar;/opt/play/framework/lib/gson-2.8.5.jar;/opt/play/framework/lib/ezmorph-1.0.6.jar;/opt/play/framework/lib/oval-1.86.jar;/opt/play/framework/lib/org.eclipse.jdt.core-3.14.0.jar;/opt/play/framework/lib/asm-6.2.jar;/opt/play/framework/lib/hibernate-c3p0-5.3.6.Final.jar;/opt/play/framework/lib/spymemcached-2.12.1.jar;/opt/play/framework/lib/commons-fileupload-1.3.2.jar;/opt/play/framework/lib/jaxen-1.1.6.jar;/opt/play/framework/lib/mchange-commons-java-0.2.12.jar;/opt/play/framework/lib/h2-1.4.196.jar;/opt/play/framework/lib/slf4j-log4j12-1.7.22.jar;/opt/play/framework/lib/commons-javaflow-1590792.jar;/opt/play/framework/lib/commons-collections-3.2.2.jar;/opt/play/framework/lib/bcprov-jdk15on-1.60.jar;/opt/play/framework/lib/commons-io-2.5.jar;/opt/play/framework/lib/snakeyaml-1.17.jar;/opt/play/framework/lib/hibernate-entitymanager-5.3.6.Final.jar;/opt/play/framework/lib/antlr-2.7.7.jar;/opt/play/framework/lib/jregex-1.2_01.jar;/opt/play/framework/lib/postgresql-42.2.4.jar;/opt/play/framework/lib/hibernate-ehcache-5.3.6.Final.jar;/opt/play/framework/lib/c3p0-0.9.5.2.jar;/opt/play/framework/lib/slf4j-api-1.7.22.jar;/opt/play/framework/lib/ehcache-core-2.6.11.jar;/opt/play/framework/lib/bcpkix-jdk15on-1.60.jar;/opt/play/framework/lib/commons-logging-1.2.jar;/opt/play/framework/lib/netty-3.10.6.Final.jar;/opt/play/framework/lib/jboss-logging-3.3.0.Final.jar;/opt/play/framework/lib/log4j-1.2.17.jar;/opt/play/framework/lib/jboss-transaction-api_1.2_spec-1.0.1.Final.jar;/opt/play/framework/lib/javassist-3.23.1-GA.jar;/opt/play/framework/lib/classmate-1.3.3.jar;/opt/play/framework/lib/ivy-2.4.0.jar;/opt/play/framework/lib/groovy-xml-2.5.1.jar;/opt/play/framework/lib/jj-imaging.jar;/opt/play/framework/lib/activation-1.1.1.jar;/opt/play/framework/lib/groovy-2.5.1.jar;/opt/play/framework/lib/jj-simplecaptcha.jar;/opt/play/framework/lib/commons-beanutils-1.9.2.jar;/opt/play/framework/lib/validation-api-1.1.0.Final.jar;/opt/play/framework/lib/mysql-connector-java-5.1.46.jar;/opt/play/framework/lib/hibernate-commons-annotations-5.0.1.Final.jar;/opt/play/framework/lib/mail-1.4.7.jar;/opt/play/framework/lib/hibernate-core-5.3.6.Final.patched.jar;/opt/play/framework/lib/hibernate-validator-5.4.1.Final.jar;/opt/play/framework/lib/commons-lang-2.6.jar;/opt/play/framework/lib/junit-4.12.jar;/opt/play/framework/lib/c3p0-oracle-thin-extras-0.9.5.jar;/opt/play/framework/lib/geronimo-servlet_2.5_spec-1.2.jar;/opt/play/framework/lib/HikariCP-3.2.0.jar;/opt/play/framework/lib/async-http-client-1.9.40.jar;/opt/play/framework/lib/jj-textile.jar;/opt/play/framework/lib/javax.persistence-api-2.2.jar;/opt/play/framework/lib/commons-codec-1.10.jar;/opt/play/framework/lib/cglib-3.2.7.jar;/opt/play/framework/lib/joda-time-2.10.jar;/opt/play/framework/lib/jamon-2.81.jar;/opt/play/framework/lib/asm-all-5.2.jar;nbproject/classes;/opt/play/framework/src</classpath>
        <built-to>nbproject/classes</built-to>
        <!-- CECI NE MARCHE PAS !!! IL FAUT SUPPRIMER CETTE BALISE -->
        <source-level>1.8</source-level>
    </compilation-unit>
</java-data>
```

`<source-level>1.8</source-level>` n'est pas valide pour Netbeans 8.2, supprimer cette balise permet d'importer le projet dans Netbeans


- moteur de template groovy