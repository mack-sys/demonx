pipeline {
    agent any

    tools {
        maven 'Maven 3.8.4' // Use the name you configured in Jenkins for Maven
      
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning Repository...'
                git 'https://github.com/mack-sys/demonx.git'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building Spring Boot Application...'
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Tests...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging Application...'
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Application...'
                // Replace the following line with your actual deployment commands
                sh 'cp target/*.jar /path/to/deploy/location/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
