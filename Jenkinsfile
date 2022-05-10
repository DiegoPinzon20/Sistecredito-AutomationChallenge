pipeline {

  agent any

  options {
    // Only keep the 5 most recent builds
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

  stages {

    stage('Clean up workspace') {
      steps {
        deleteDir()
      }
    }

    stage('SCM') {
      steps {
        git 'https://github.com/DiegoPinzon20/Sistecredito-AutomationChallenge.git'
      }
    }

    stage('build & SonarQube analysis') {
      steps {
        withSonarQubeEnv(installationName: 'my-sonar-qube') { // Will pick the global server connection you have configured
          bat './gradlew clean sonarqube'
        }
      }
    }

    stage("Quality Gate") {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          script {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
              error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
          }
        }
      }
    }

    stage('Gradle Build Artifact And Run Test') {
      steps {
        script {
          def gradleCommandBasic = './gradlew clean build test aggregate -i'
          if (isUnix()) {
            sh gradleCommandBasic
          } else {
            bat gradleCommandBasic
          }
        }
      }
    }
  }

  post {
    
    always {
      publishHTML(
        [allowMissing: false,
          alwaysLinkToLastBuild: true,
          keepAll: true,
          reportDir: 'target/site/serenity',
          reportFiles: 'index.html',
          reportName: 'HTML Report'
        ]
      )
      archiveArtifacts artifacts: "build/libs/*.jar",
        allowEmptyArchive: true,
        fingerprint: true
      junit "build/test-results/test/*.xml"
    }
    
    failure {
      //mail to: 'diegopip62@gmail.com',
       // subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
       // body: "Something is wrong with ${env.BUILD_URL}"
      
      emailext attachLog: true, attachmentsPattern: '*_log.txt', body: 'Echa un vistazo al reporte generado de la prueba.', subject: 'Sistecredito-AutomationChallenge [FAILURE]', to: 'diegopip62@gmail.com, dquintero@grupohdi.com'
    }
    success {
      emailext attachLog: true, attachmentsPattern: '*_log.txt', body: 'Echa un vistazo al reporte generado de la prueba.', subject: 'Sistecredito-AutomationChallenge [SUCCESS]', to: 'diegopip62@gmail.com, dquintero@grupohdi.com'
    }
  }

}
}
