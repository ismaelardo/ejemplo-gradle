pipeline {
    agent any

    stages {

        stage('Build & Unit test') {
            steps {
                script {
                    sh 'env'
                    println "Stage: ${env.STAGE_NAME}"
                }
            }
        }

        stage('Sonar') {
            steps {
                script{
                    println "Stage: ${env.STAGE_NAME}"

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
