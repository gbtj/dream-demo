node('jenkins-node') {
    stage('Clone') {
		echo "1.Clone Stage"
		git url: "${git_link}"
		if ("${git_branch}" !=  'master' ) {
            sh "git checkout ${git_branch}"
        }
		script {
			build_tag = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
		}
		echo "${build_tag}"
	}
    stage('Maven') {
		echo "2.Maven build package Stage"
		sh 'mvn -B -DskipTests clean package'
	}
    stage('Build') {
		echo "3.Build Docker Image Stage"
		sh "docker build -t registry.cn-hangzhou.aliyuncs.com/carl_zh/${api_name}-${api_version}:${build_tag} ."
	}
    stage('Push') {
		echo "4.Push Docker Image Stage"
		sh "docker login --username=tb_9256807 registry.cn-hangzhou.aliyuncs.com -p 121610zh"
		sh "docker push registry.cn-hangzhou.aliyuncs.com/carl_zh/${api_name}-${api_version}:${build_tag}"
	}
	stage('YAML') {
		echo "5.Change YAML File Stage"
		sh "sed -i 's/<API_NAME>/${api_name}/' ${api_name}.yaml"
		sh "sed -i 's/<API_VERSION>/${api_version}/' ${api_name}.yaml"
		sh "sed -i 's/<BUILD_TAG>/${build_tag}/' ${api_name}.yaml"
	}
	stage('Deploy') {
		echo "6.Deploy to K8S Stage"
		sh "kubectl apply -f ${api_name}.yaml -n dev"
	}
}