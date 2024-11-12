pipeline {
    agent any
    
    tools {
        maven 'Maven3'  // Refer to the name of your Maven installation in Jenkins
    }

    environment {
        MAVEN_HOME = 'C:/apache-tomcat-10.0.13/apache-tomcat-10.0.13/bin'
        JAVA_HOME = 'C:/Program Files/Java/jdk-17'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git (
                	url: 'https://github.com/mack-sys/demonx.git',
                	credentialsId: 'github-pat',
                	branch: 'main'
                )
            }
        }

        stage('Build') {
            steps {
                script {
                    // Run Maven to build the project
                    bat  "${MAVEN_HOME}/bin/mvn clean install"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run Maven tests
                    bat  "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    // Package the Spring Boot app
                    bat  "${MAVEN_HOME}/bin/mvn package"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Example deployment step (e.g., copy to server, or use Docker)
                    bat  'scp target/your-app.jar user@your-server:/path/to/deploy/'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deploy successful!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
