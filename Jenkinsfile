pipeline {
    agent any

    tools {
        jdk 'jdk17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/VGavrish/RestAssured.git'
            }
        }

        stage('Check Java') {
            steps {
                bat 'java -version'
                bat 'echo %JAVA_HOME%'
                bat 'gradlew -version'
            }
        }

        stage('Run tests') {
            steps {
                bat 'gradlew clean qaTest'
            }
        }
    }
}