pipeline {
    agent any                      // usa cualquier agente disponible

    environment {
        MAVEN_HOME = tool 'Maven'  // nombre exacto del Maven instalado en Jenkins
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {        // Jenkins hace checkout por defecto, pero lo dejamos explícito
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {    // compila y ejecuta los escenarios Cucumber
            steps {
                bat 'mvn -B clean test'   // usa bat porque tu agente es Windows
            }
        }
    }

    post {                         // siempre publica resultados JUnit
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
