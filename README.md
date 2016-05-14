# hibernate_jsf_sample
This is just a simple application to show how to use hibernate in a JSF web java application. This web app use all modern tools and configs I found in the internet so far. The persistence unit has almost every property mapped to javax.persistence instead of hibernate properties, so if for any reason you decide to change hibernate for any other ORM that is JPA 2.1 complient you will have a few things to change. No faces-config is used because of two reasons.

1- There is no need to create it because I'm using JSF 2.0 <br/>
2- Richfaces is there in the maven dependencies just to show you how to use it with hibernate in the same application but I'm not using anything related to Richfaces. The "index page" uses only "pure" JSF tags.
<br/>

All hibernate mappings is done by JPA 2.1 annotations. So anything you want to see about hibernate is in the entity classes itself. I made a big effort to create a sample that uses all mapping cases possible. There is simples classes without any relation. There is classes with many to one relation, one to many relation and one to one relation.
<br/>

Obs: The persistence unit has all the information that is needed in order to create the database automatically. Just uncoment the first line and comment the second one. When you click on any button in the "index" page it will create the database. After this, before doing anything stop the web container (jboss, tomcat glassfish, etc) and edit the persistence.xml file again and take it back to its original config. If you do not do this, everytime you perform any operation in the database, hibernate will drop all your tables and create them again.
