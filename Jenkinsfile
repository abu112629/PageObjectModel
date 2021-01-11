timestamps {

    node('HybrisQAVM01') {
        ansiColor('xterm') {
            withEnv(["JAVA_HOME=${tool 'jdk8'}", "PATH+MAVEN=${tool 'maven'}/bin:${env.JAVA_HOME}/bin"]) {

                stage('Checkout') {
                    checkout scm
                }

                stage('Build') {
                    if (isUnix()) {
                        sh "mvn clean package"
                    } else {
                        bat "mvn clean package"
                    }
                }

                stage("Execute Tests") {
                    try {
                        if (isUnix()) {
                            sh """
                            %JAVA_HOME%/bin/java -jar target/grsoe-1.0-SNAPSHOT.jar
                            """
                        } else {
                            bat """
                          
                            %JAVA_HOME%/bin/java -jar target/grsoe-1.0-SNAPSHOT.jar
                            """
                        }
                    } finally {
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
}