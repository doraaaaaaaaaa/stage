pipeline { 
   environment { 

        registry = "ghadahajjaji/finalachat" 

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
		 
        stage('MVN COMPILE') { 
            steps { 
               sh' mvn compile' 
                
            }
         }
		/*
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=Ghada3728'
            }
        }
		
		stage("Unit tests") {
			steps {
				sh 'mvn test'
			}
			post {
				always {
					junit 'target/surefire-reports/*.xml'
				}
			}
		}
		*/
		stage('clean et packaging'){
			steps {
				sh 'mvn clean package -DskipTests'
			}
		}
		/*
        stage ('NEXUS DEPLOY') {
           steps {
				script {
					nexusPublisher nexusInstanceId: 'Nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]
		 		}
           }
        }
		*/
		stage('Build docker image'){
            steps{
             sh 'docker build -t ghadahajjaji/finalachat:latest .'
            }
        }
		
        stage('Dockerhub Login') {
             steps {
             sh 'docker login -u "ghadahajjaji" -p "Ghada3728"'
            }
         }
        
         stage('Push Image to Docker Hub') {         
            steps{                            
             sh 'docker push ghadahajjaji/finalachat:latest'             
            }            
        }
		
        stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }

        }
        /*
		stage("Docker-Compose") { 
             steps { 
                 script { 
                    sh "docker-compose up -d  "
                 } 
             }
		}*/

		stage('Email notification') {
            steps {
                mail bcc: '', body: 'All containers are up', cc: '', from: '', replyTo: '', subject: 'Jenkins-Dockerhub Alert', to: 'ghada.hajjaji@esprit.tn'
            }
        }
		
   }
}