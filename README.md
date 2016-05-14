# hibernate_jsf_sample
This is just a simple application to show how to use hibernate in a jsf web java application. This web app use all modern tools and configs I found in the internet so far. The persistence unit has almost every property mapped to javax.persistence instead of hibernate properties, so if for any reason you decide to change hibernate for any other ORM that is JPA 2.1 complient you will have a few things to change. No faces-config is used because of two reasons. 

1- There is no need because I'm using jsf 2.0
2- Richfaces is there in the maen depencies just to show you how to use it with hibernate in the same application but I'm not using anything related to Richfaces. The "index page" uses only jsf pure tags.

All hibernate mappings is done by jpa 2.1 annotations. So anything you want to see about hibernate is in the entity classes itself. I make a big effort to create a sample that uses all mapping cases possible. There is simples classes without any relation. There is classes with many to one relation, one to many relation and one to one relation.

Obs: The persistence unit has all the information that is needed in order to create the database automatically. Just uncoment the first line and comment the second one. When you click on any button in the "index" page it will create the database. After this, before doing anything stop the web container (jboss, tomcat glassfish, etc) and edit the persistence.xml file again e get it back to its original config. If you do not do this, everytime you perform any operation in the database, hibernate will drop all your tables and create then again.
