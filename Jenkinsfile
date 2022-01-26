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
                    sh "nohup bash ./gradlew bootRun &"
                    sleep 20
                    //println "Stage: ${env.STAGE_NAME}"
                }
            }
        }

        stage('Test') {
            steps {
                script{
                    sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
                    //println "Stage: ${env.STAGE_NAME}"
                }
            }
        }
        
        stage('nexus') {
            steps {
                nexusPublisher nexusInstanceId: 'nexus_test',
                nexusRepositoryId: 'test_nexus',
                packages: [
                    [
                        $class: 'MavenPackage',
                        mavenAssetList: [
                            [classifier: '', extension: '', filePath: "${env.WORKSPACE}/build/libs/DevOpsUsach2020-0.0.1.jar"]
                        ],
                        mavenCoordinate: [
                            artifactId: 'DevOpsUsach2020',
                            groupId: 'com.devopsusach2020',
                            packaging: 'jar',
                            version: '0.0.1'
                        ]
                    ]
                ]
            }
        }
    }
}
