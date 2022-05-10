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
          def gradleCommandJustOneTest './gradlew clean test --tests "EmptySearchRunner"'
          if (isUnix()) {
            sh gradleCommandJustOneTest
          } else {
            bat gradleCommandJustOneTest
          }
        }
      }
    }

    stage('Generate summary report') {
      steps {
        script {
          def generateSummaryReport = './gradlew reports'
          if (isUnix()) {
            sh generateSummaryReport
          } else {
            bat generateSummaryReport
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
      
      emailext attachLog: true,
        attachmentsPattern: 'target/site/serenity/serenity-summary.html', 
        body: 'Echa un vistazo al reporte generado de la prueba.', 
        subject: '[Sistecredito-AutomationChallenge] $PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', 
        to: 'diegopip62@gmail.com, dquintero@grupohdi.com',
        mimeType: 'text/html'
    }

    failure {
      //mail to: 'diegopip62@gmail.com',
      // subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
      // body: "Something is wrong with ${env.BUILD_URL}"
    }
  }
}
}
