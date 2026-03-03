def call(String credId, String image, String ImageTag){
  withCredentials([usernamePassword(
                    credentialsId: "${credId}",
                    usernameVariable: "DOCKER_USER",
                    passwordVariable: "DOCKER_PASS"
                )]) {

                    sh """
                    echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    docker push ${image}:${ImageTag}
                    """
                }
}
