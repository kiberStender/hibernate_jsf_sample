#!/usr/bin/env bash
export TOM=~/.apps/as/tomcat/apachetomcat7069

mvn clean install -U

rm -rf $TOM/webapps/hibernate*

mv target/*.war $TOM/webapps

sh $TOM/bin/catalina.sh run
