def call(String credId, String imageName){
  withCredentials([usernamePassword(
                    credentialsId: "${credId}",
                    usernameVariable: "dockerHubUser",
                    passwordVariable: "dockerHubPass"
                )]) {

                    sh """
                    docker login -u "${env.dockerHubUser}" -p ${env.dockerHubPass}
                    docker push ${env.dockerHubUser}/${imageName}:latest
                    """
                }
}
