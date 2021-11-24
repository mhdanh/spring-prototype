remote_state {
  backend = "s3"
  generate = {
    path      = "backend.tf"
    if_exists = "overwrite"
  }
  config = {
    bucket         = "mhdpersonal-tf-state"
    key            = "clusters/terraform.tfstate"
    region         = "ap-southeast-1"
    dynamodb_table = "mhdpersonal-tf-locks"
    profile        = "personal"
    encrypt        = true
  }
}

terraform {
  extra_arguments "common_vars" {
    commands = ["plan", "apply", "import", "destroy", "refresh", "state"]
    arguments = [
      "-compact-warnings",
      "-var-file=../../venture.tfvars",
      "-var-file=../environment.tfvars"
    ]
  }
}
