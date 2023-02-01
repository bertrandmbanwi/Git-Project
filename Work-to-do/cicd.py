# First, you need to import the necessary packages and modules.

import boto3
from aws_cdk import aws_codepipeline as codepipeline
from aws_cdk import aws_codepipeline_actions as codepipeline_actions

# Create a new CodePipeline object
pipeline = codepipeline.Pipeline(self, "MyPipeline")

# Add a source stage to the pipeline
source_stage = pipeline.add_stage(
    stage_name="Source",
    actions=[
        codepipeline_actions.GitHubSourceAction(
            action_name="GitHub_Source",
            output=source_output,
            owner="bertrandmbanwi",
            repo="YourGitHubRepoName",
            oauth_token=codepipeline.SecretValue.secrets_manager("GitHubToken"),
            branch="master"
        )
    ]
)

# Add a build stage to the pipeline
build_stage = pipeline.add_stage(
    stage_name="Build",
    actions=[
        codepipeline_actions.CodeBuildAction(
            action_name="CodeBuild",
            project=codebuild.Project(self, "MyProject"),
            input=source_output
        )
    ]
)

# Add a deployment stage to the pipeline
deploy_stage = pipeline.add_stage(
    stage_name="Deploy",
    actions=[
        codepipeline_actions.CloudFormationCreateUpdateStackAction(
            action_name="CFN_Deploy",
            stack_name="MyStack",
            template_path=build_output.at_path("template.yaml"),
            admin_permissions=True
        )
    ]
)
    