# Tool required

- Terraform
- Terragrunt
- Tfswitch

This small project will create ec2 intance with variable name and also use S3 as backend for keeptrack history and dynamo db

cd to terraform/service and run terragrunt plan/apply

### Note that, please adapt profile and region before applying terragrunt

### when to use terragrunt destroy 

maybe you have to set ENV for AWS_PROFILE, AWS_PROFILE_REGISON