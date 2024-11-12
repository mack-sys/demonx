pipeline {
    agent any

    environment {
        // Define any environment variables here if needed
        MAVEN_HOME = tool 'Maven'  // Make sure you have configured a Maven tool in Jenkins
        JAVA_HOME = tool 'JDK 11'  // Ensure the appropriate JDK is installed and configured
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git url: 'https://github.com/mack-sys/demonx.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Clean and build the project with Maven
                sh 'mvn clean install' // Add a command here to avoid an empty steps block
            }
        }

        stage('Test') {
            steps {
                // Run tests
                 sh 'mvn test'
            }
            post {
                always {
                    // Archive test results even if tests fail
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Analysis') {
            steps {
                // Run code analysis tools like SonarQube (if configured)
                // Example: sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
            }
        }

        stage('Package') {
            steps {
                // Package the Spring Boot application (typically generates a JAR file)
                sh "${MAVEN_HOME}/bin/mvn package"
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
                }
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the JAR to a server or run it locally
                // Example for local: sh 'java -jar target/your-app.jar'
                // Example for remote: use SCP, SSH, or Docker for deployment
                echo 'Deploying the application...'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
