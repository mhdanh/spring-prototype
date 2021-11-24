resource "aws_instance" "ec2web" {
  ami           = "ami-03326c3f2f37e56a4"
  instance_type = "t3.micro"

  tags = {
    Name = "${var.ec2_name}"
  }
}