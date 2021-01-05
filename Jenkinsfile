timestamps {

    node() {

        stage('Checkout') {
            checkout scm
        }

        stage('Build') {
            withMaven(maven: 'maven-3.6.3') {
                if (isUnix()) {
                    sh "mvn clean package "
                } else {
                    bat "mvn clean package "
                }
            }
        }

        stage("Execute Tests") {
            ansiColor('xterm') {
                try {
                    if (isUnix()) {
                        sh """
                    export DRIVER_PROVIDER=com.canadalife.automation.sdfc.support.SFDriverProvider
                    java -jar target/sfdc-1.0-SNAPSHOT.jar
                    """
                    } else {
                        bat """
                    set DRIVER_PROVIDER=com.canadalife.automation.sdfc.support.SFDriverProvider
                    java -jar target/sfdc-1.0-SNAPSHOT.jar
                    """
                    }
                } finally {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            results: [[path: 'target/results']]
                    ])
                    publishHTML(target: [
                            allowMissing         : false,
                            alwaysLinkToLastBuild: true,
                            keepAll              : true,
                            reportDir            : 'target/report',
                            reportFiles          : 'index.html',
                            reportName           : "Test Report"
                    ])
                }
            }

        }

    }
}