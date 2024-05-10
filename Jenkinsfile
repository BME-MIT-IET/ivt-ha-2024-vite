pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Clone the Git repository and build the project
                git branch: 'main', url: 'https://github.com/BME-MIT-IET/ivt-ha-2024-vite'
            }
        }
        stage('Test') {
            steps {
                
                bat "mvn test"
                
                // Generate Surefire test reports
                bat "mvn surefire-report:report"

                bat "mvn verify"
            }
        }
    }

    post {
        success {
            // If unit tests pass, print a success message
            echo 'Unit tests passed successfully!'
        }
        failure {
            // If any unit test fails, print an error message and fail the build
            echo 'Unit tests failed!'
            error 'Unit tests failed!'
        }
        always {
            // Capture XML test report files using the JUnit plugin
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
}
