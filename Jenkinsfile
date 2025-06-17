pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'  // Usa el nombre configurado en "Global Tools" de Jenkins
        jdk 'JDK_21'         // Usa el nombre del JDK configurado en Jenkins
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Clonar código') {
            steps {
                git branch: 'main', url: 'https://github.com/cesarnarma/SeleniumCucumber.git'
            }
        }

        stage('Compilar y ejecutar pruebas') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Publicar Reportes') {
            steps {
                // Archiva reportes Cucumber y Extent (si los generas en target/)
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'  // Solo si generas reportes JUnit
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }
        failure {
            echo 'La ejecución falló. Revisar logs.'
        }
    }
}
