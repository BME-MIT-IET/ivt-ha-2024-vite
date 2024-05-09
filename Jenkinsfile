pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Clone the Git repository and build the project
                git branch: 'main', url: 'https://github.com/BME-MIT-IET/ivt-ha-2024-vite'
                bat "mvn -Dmaven.test.failure.ignore=true clean package"

                //testing if webhook is working
            }
        }
        stage('Test') {
            steps {
                // Run unit tests
                bat "mvn test"

                // Capture test results
                //junit '**/target/surefire-reports/TEST-*.xml'
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
    }
}
