pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:/apache-tomcat-10.0.13/apache-tomcat-10.0.13'
        JAVA_HOME = 'C:/Program Files/Java/jdk-17'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/your-user/your-repository.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Run Maven to build the project
                    sh "${MAVEN_HOME}/bin/mvn clean install"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run Maven tests
                    sh "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    // Package the Spring Boot app
                    sh "${MAVEN_HOME}/bin/mvn package"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Example deployment step (e.g., copy to server, or use Docker)
                    sh 'scp target/your-app.jar user@your-server:/path/to/deploy/'
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
