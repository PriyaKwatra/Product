node{


        stage('Build'){


                   withMaven(maven: 'M3', jdk: 'JDK8')
                   {
                       sh "mvn clean install"
                   }

        }

}