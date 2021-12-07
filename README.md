## Lab 1

Wrapper:

```
mvn -N io.takari:maven:wrapper 
```

Következő parancs végrehajtása:

```
cd C:\
mkdir training
cd training
git clone https://github.com/Training360/java-ci-2021-12-07
cd java-ci-2021-12-07\hello-world
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.1
mvnw package
```