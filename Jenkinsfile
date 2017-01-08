node("master") {

    //  Version Control Stage
    def gitUri = "git@github.com:amelja/jenkins-pipeline-as-code-example.git"
    def branch = "master"
	
	//  Build Stage
    def mvnGoals = "-B verify"
	
	//  File Archive Stage
    def fileMask = "target/*.jar"
	
    stage("Get code from version control") {

        //  Version Control
        echo "Checking out the ${branch} branch from VCS"
        git branch: branch, url: gitUri

    }
	
	stage("Build with Maven") {

        //  Environment Variables
        echo "Performing a Maven ${mvnGoals}"

        try {
            sh "${tool 'maven_3'}/bin/mvn ${mvnGoals}"
            currentBuild.result
        } catch (error) {
			//  Sets build to failed if job Maven fails
            currentBuild.result
        }
    }
	
	stage("Archive in Jenkins") {

        echo "Archiving artifacts to Jenkins"
        archiveArtifacts artifacts: fileMask, fingerprint: true

    }
}
