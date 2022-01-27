pipeline {

	agent any
	
	environment {
	    STAGE = ''
	}

	parameters {
		choice(name: 'buildTool', choices: ['gradle', 'maven'], description: 'Indicar herramienta de construcción')
	}

	stages{
		stage('Pipeline'){
			steps{
				script{
					println 'Pipeline'
					
	                if (params.buildTool == "gradle") {
	                    def ejecucion = load 'gradle.groovy'
	                    ejecucion.call()
	                } else {
	                    def ejecucion = load 'maven.groovy'
	                    ejecucion.call()
	                }
				}
			}
		}
	}
}