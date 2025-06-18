pipeline {
    agent any

    tools {
        maven 'Maven' // version como aparece en tools de Jenkins
        jdk 'Java_JDK' // version como aparece en tools de Jenkins
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    parameters {
        string(name: 'TAGS', defaultValue: '@regresion', description: 'Cucumber Tags a ejecutar (por ejemplo: @login or @regresion and not @wip)')
    }

    stages {
        stage('Clonar código') {
            steps {
                git branch: 'main', url: 'https://github.com/cesarnarma/SeleniumCucumber.git'
            }
        }

        stage('Compilar y ejecutar pruebas') {
            steps {
                sh "mvn clean test -Dcucumber.filter.tags='${params.TAGS}'"
            }
        }

        stage('Publicar Reportes') {
            steps {
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
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }
        failure {
            echo 'La ejecución falló. Revisar logs.'
        }
    }
}

