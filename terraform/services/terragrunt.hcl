# stage/terragrunt.hcl
generate "provider" {
  path = "providers.tf"
  if_exists = "overwrite_terragrunt"
  contents = <<EOF
provider aws {
  region  = "ap-southeast-1"
  profile = "personal"
}
EOF
}
