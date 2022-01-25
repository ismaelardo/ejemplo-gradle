pipeline {
    agent any

    stages {

        stage('Build & Unit test') {
            steps {
                script {
                    sh './gradlew clean build'
                    //println "Stage: ${env.STAGE_NAME}"
                }
            }
        }

        stage('SonarQube analysis'){
            steps{
                script {
                    def scannerHome = tool 'sonar-scanner';
                    withSonarQubeEnv('sonarqube-server'){
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle-nuevo -Dsonar.sources=src -Dsonar.java.binaries=build"
                    }
                }
            }
        }

        stage('Run') {
            steps {
                script{
                    println "Stage: ${env.STAGE_NAME}"
                }
            }
        }

        stage('Test') {
            steps {
                script{
                    println "Stage: ${env.STAGE_NAME}"
                }
            }
        }
        
        stage('Nexus') {
            steps {
                script{
                    println "Stage: ${env.STAGE_NAME}"
                }
            }
        }
    }
}
