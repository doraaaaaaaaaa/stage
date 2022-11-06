pipeline { 
   environment { 

        registry = "ghadahj/tpachat" 

        registryCredential = 'dockerHub' 

        dockerImage = '' 

    }
     agent any
  
   stages{
        stage('GIT') { 
           steps { 
               git branch: 'ghada', credentialsId: '98b95d8d-772b-4b8b-8718-3cab8a09a4ec', url: 'https://github.com/HssanMahdi/backfordevops.git'
                
            }
         }
         
        stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
            }
         }

          stage('MVN COMPILE') { 
            steps { 
               sh' mvn compile' 
                
            }
         }

          /*stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=Ghada3728'
            }
        }*/

         stage ('NEXUS DEPLOY') {
           steps {
				script {
					nexusPublisher nexusInstanceId: 'Nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]
		 		}
           }
        }
      stage('Building our image') {
         steps {
         script {
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
                } 
         }
         stage('Deploy our image') {
         steps {
         script {
             docker.withRegistry( '', registryCredential ) {
             dockerImage.push()
               }
               }
               }
               }
                  stage('Cleaning up') { 

            steps { 

                sh "docker rmi $registry:$BUILD_NUMBER" 

            }

        }
        
   }
}