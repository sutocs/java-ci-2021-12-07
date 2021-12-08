## SonarQube

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-failsafe-plugin</artifactId>
	<version>2.22.2</version>
	<executions>
		<execution>
			<goals>
				<goal>integration-test</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

```xml
<plugin>
   <groupId>org.sonarsource.sonar-packaging-maven-plugin</groupId>
   <artifactId>sonar-packaging-maven-plugin</artifactId>
   <version>1.18.0.372</version>
</plugin>	
```

```xml
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.7</version>
  <executions>
    <execution>
        <id>jacoco-initialize</id>
        <goals>
            <goal>prepare-agent</goal>
        </goals>
    </execution>
    <execution>
        <id>jacoco-site</id>
        <phase>package</phase>
        <goals>
            <goal>report</goal>
        </goals>
    </execution>
  </executions>
</plugin>
```

<configuration>
      <systemPropertyVariables>
        <build.profile.url>${build.profile.url}</build.profile.url>
      </systemPropertyVariables>
    </configuration>

```shell
mvn -Dsonar.login=admin -Dsonar.password=admin12 clean package sonar:sonar
```

```Jenkinsfile
pipeline {
    agent any

    stages {
        stage('package') {
            steps {
                git 'https://github.com/vicziani/employees'

                sh './mvnw clean package'
            }
        }
        stage('test') {
            steps {
                sh './mvnw verify'
            }
        }
        stage('sonar') {
            steps {
                sh './mvnw -Dsonar.host.url=http://employees-sonarqube:9000 -Dsonar.login=admin -Dsonar.password=admin12 sonar:sonar'
            }
        }
    }
}
```