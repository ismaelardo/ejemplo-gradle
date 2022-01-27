/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
  	stage('Compile') {
            sh './mvnw clean compile -e'
            sh 'exit 1'
    }
    stage('Test') {
        sh './mvnw clean test -e'
    }
    stage('Jar') {
        sh './mvnw clean package -e'
    }
    stage('Run') {
        sh 'JENKINS_NODE_COOKIE=dontKillMe nohup bash mvnw spring-boot:run &'
    }
    stage('Testing') {
        sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
    }
}

return this;