def call(String credId, String imageName, Integer ImageTag){
  withCredentials([usernamePassword(
                    credentialsId: "${credId}",
                    usernameVariable: "DOCKER_USER",
                    passwordVariable: "DOCKER_PASS"
                )]) {

                    sh """
                    echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    docker push ${env.DOCKER_USER}/${imageName}:${ImageTag}
                    """
                }
}
