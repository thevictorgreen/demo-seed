// Jenkins Job DSL to create Jobs

//Base Path For All Jobs Related to this project
def basePath = 'DemoProject';

//Folder already exists. Seed job inside of it
folder (basePath) {
  displayName('DemoProject');
  description('Folder for DemoProject');
}


//Git repository for demo-userportal
def repoUrl = "https://github.com/thevictorgreen/demo-userportal.git"; //Repository UrL

pipelineJob(basePath + "/demo-userportal") { //JobName
  description("Application frontend for the user portal");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
          }
        }
      }
      triggers {
        githubPush();
      }
    }
  }
}


