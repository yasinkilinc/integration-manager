def envMap = [
    "development": 'development',
    "test/v1": 'development',
    "release/v1": 'production'
]

def environment = envMap[env.BRANCH_NAME]

pipeline {
    agent {
        label "${environment}"
    }

    stages {
        stage('Checkout') {
            steps {
                script{
                    try {
                        checkout scm
                    }
                    catch (e) {
                        currentBuild.result ="FAILED"
                        notifyBuild(currentBuild.result)
                        throw e

                    }
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    try {
                        sh """
                        ./mvnw clean install -DskipTests
                        """
                    }
                    catch (e) {
                        currentBuild.result ="FAILED"
                        notifyBuild(currentBuild.result) 
                        throw e                      
                    }
                }
            }
        }
        stage('Unit Test') {
            steps {
                sh """
                echo NO TEST FOUND
                """
            }
        }
        stage('Deploy') {
            steps {
                script{
                    try {
                        sh """
                        pm2 reload INTEGRATION_MANAGER
                        pm2 ps
                        """
                    }
                    catch (e) {
                        currentBuild.result ="FAILED"
                        notifyBuild(currentBuild.result)
                        throw e                      
                    }
                    finally{
                        notifyBuild(currentBuild.result)
                    }

                }
            }
        }
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'
    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#FFFF00'
    } else if (buildStatus == 'SUCCESS') {
        color = 'GREEN'
        colorCode = '#00FF00'
    } else {
        color = 'RED'
        colorCode = '#FF0000'
    }
    // Send notifications
    slackSend(channel: '#ops-amz', color: colorCode, message: summary)
}