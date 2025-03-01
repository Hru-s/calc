pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        DOCKER_IMAGE_NAME = 'calc'
        GITHUB_REPO_URL = 'https://github.com/Hru-s/calc.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh 'mvn test'  // Runs JUnit tests
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'  // Collects test reports
                }
            }
        }
        stage('Build Jar') {
            steps {
                sh 'mvn clean package'
                sh 'mv target/*.jar target/calculator.jar'  // Build the .jar file
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'DockerHubCred') {
                        sh 'docker push calc'
                    }
                }
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                script {
                    withEnv(["ANSIBLE_HOST_KEY_CHECKING=False"]) {
                        ansiblePlaybook(
                            playbook: 'deploy.yml',
                            inventory: 'inventory'
                        )
                    }
                }
            }
        }
    }

    post {
        success {
            mail to: 'nakka.hrushikesh@iiitb.ac.in',
                subject: "Application Deployment SUCCESS: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "The build was successful!"
        }
        failure {
            mail to: 'nakka.hrushikesh@iiitb.ac.in',
                subject: "Application Deployment FAILURE: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "The build failed."
        }
        always {
            cleanWs()
        }
    }
}
