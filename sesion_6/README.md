# Sesión 06: Operaciones deInfraestructur a como código

## 1. Tener instalado Terraform en local 
   
Instalamos [terraform](https://developer.hashicorp.com/terraform/downloads) según nuestro sistema operativo.
   
En windows obtenemos los binarios

```
Invoke-WebRequest -Uri “https://releases.hashicorp.com/terraform/1.3.5/terraform_1.3.5_windows_amd64.zip” -OutFile “~/terraform.zip”
```

Expandimos el zip

```
Expand-Archive -LiteralPath ~/terraform.zip -DestinationPath ~/terraform
```

Agregamos la variable de ambiente

```
$env:Path += ";$home/terraform"
```

Validamos la instalación obteniendo la versión instalada

```
terraform –version

Terraform v1.3.5
on windows_amd64
```
   
## 2. Identificar los comandos básicos para el despliegue y destrucción de ambientes 

```
# Versión instalada de terraform
terraform –version

# Da formato a los archivos tf
terraform fmt

# Inicializa tf
Terraform init

# Hace el plan de los archivos tf
terraform plan

# Aplica todo lo que contiene los archivos tf
terraform apply

# Muestra el output de los archivos tf
terraform output

# Destruye todo lo que construyó
terraform destroy
```
   
## 3. Crear nuestro primer despliegue 

Teniendo nuestro proyecto ejecutamos lo siguiente

```
terraform fmt

Terraform init

terraform plan

terraform apply
```

Pasará lo siguiente:

```javascript
terraform fmt
main.tf
```

```javascript
Terraform init
Initializing the backend...

Initializing provider plugins...
- Finding kreuzwerker/docker versions matching ">= 2.16.0"...
- Installing kreuzwerker/docker v2.23.1...
- Installed kreuzwerker/docker v2.23.1 (self-signed, key ID BD080C4571C6104C)

Partner and community providers are signed by their developers.
If you'd like to know more about provider signing, you can read about it here:
https://www.terraform.io/docs/cli/plugins/signing.html

Terraform has created a lock file .terraform.lock.hcl to record the provider
selections it made above. Include this file in your version control repository
so that Terraform can guarantee to make the same selections by default when
you run "terraform init" in the future.

Terraform has been successfully initialized!

You may now begin working with Terraform. Try running "terraform plan" to see
any changes that are required for your infrastructure. All Terraform commands
should now work.

If you ever set or change modules or backend configuration for Terraform,
rerun this command to reinitialize your working directory. If you forget, other
commands will detect it and remind you to do so if necessary.
```

```javascript
terraform plan

Terraform used the selected providers to generate the following execution plan. Resource actions are indicated with the following symbols:
  + create

Terraform will perform the following actions:

  # docker_container.microservice will be created
  + resource "docker_container" "microservice" {
      + attach                                      = false
      + bridge                                      = (known after apply)
      + command                                     = (known after apply)
      + container_logs                              = (known after apply)
      + container_read_refresh_timeout_milliseconds = 15000
      + entrypoint                                  = (known after apply)
      + env                                         = (known after apply)
      + exit_code                                   = (known after apply)
      + gateway                                     = (known after apply)
      + hostname                                    = (known after apply)
      + id                                          = (known after apply)
      + image                                       = (known after apply)
      + init                                        = (known after apply)
      + ip_address                                  = (known after apply)
      + ip_prefix_length                            = (known after apply)
      + ipc_mode                                    = (known after apply)
      + log_driver                                  = (known after apply)
      + logs                                        = false
      + must_run                                    = true
      + name                                        = "microservice-demo"
      + network_data                                = (known after apply)
      + read_only                                   = false
      + remove_volumes                              = true
      + restart                                     = "no"
      + rm                                          = false
      + runtime                                     = (known after apply)
      + security_opts                               = (known after apply)
      + shm_size                                    = (known after apply)
      + start                                       = true
      + stdin_open                                  = false
      + stop_signal                                 = (known after apply)
      + stop_timeout                                = (known after apply)
      + tty                                         = false
      + wait                                        = false
      + wait_timeout                                = 60

      + healthcheck {
          + interval     = (known after apply)
          + retries      = (known after apply)
          + start_period = (known after apply)
          + test         = (known after apply)
          + timeout      = (known after apply)
        }

      + labels {
          + label = (known after apply)
          + value = (known after apply)
        }

      + ports {
          + external = 5000
          + internal = 5000
          + ip       = "0.0.0.0"
          + protocol = "tcp"
        }
    }

  # docker_image.microservice will be created
  + resource "docker_image" "microservice" {
      + id          = (known after apply)
      + image_id    = (known after apply)
      + latest      = (known after apply)
      + name        = "microservice"
      + output      = (known after apply)
      + repo_digest = (known after apply)

      + build {
          + dockerfile = "Dockerfile"
          + path       = "../microservice/."
          + remove     = true
          + tag        = [
              + "microservice:latest",
            ]
        }
    }

Plan: 2 to add, 0 to change, 0 to destroy.

─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

Note: You didn't use the -out option to save this plan, so Terraform can't guarantee to take exactly these actions if you run "terraform apply" now.

```

```javascript
terraform apply

Terraform used the selected providers to generate the following execution plan. Resource actions are indicated with the following symbols:
  + create

Terraform will perform the following actions:

  # docker_container.microservice will be created
  + resource "docker_container" "microservice" {
      + attach                                      = false
      + bridge                                      = (known after apply)
      + command                                     = (known after apply)
      + container_logs                              = (known after apply)
      + container_read_refresh_timeout_milliseconds = 15000
      + entrypoint                                  = (known after apply)
      + env                                         = (known after apply)
      + exit_code                                   = (known after apply)
      + gateway                                     = (known after apply)
      + hostname                                    = (known after apply)
      + id                                          = (known after apply)
      + image                                       = (known after apply)
      + init                                        = (known after apply)
      + ip_address                                  = (known after apply)
      + ip_prefix_length                            = (known after apply)
      + ipc_mode                                    = (known after apply)
      + log_driver                                  = (known after apply)
      + logs                                        = false
      + must_run                                    = true
      + name                                        = "microservice-demo"
      + network_data                                = (known after apply)
      + read_only                                   = false
      + remove_volumes                              = true
      + restart                                     = "no"
      + rm                                          = false
      + runtime                                     = (known after apply)
      + security_opts                               = (known after apply)
      + shm_size                                    = (known after apply)
      + start                                       = true
      + stdin_open                                  = false
      + stop_signal                                 = (known after apply)
      + stop_timeout                                = (known after apply)
      + tty                                         = false
      + wait                                        = false
      + wait_timeout                                = 60

      + healthcheck {
          + interval     = (known after apply)
          + retries      = (known after apply)
          + start_period = (known after apply)
          + test         = (known after apply)
          + timeout      = (known after apply)
        }

      + labels {
          + label = (known after apply)
          + value = (known after apply)
        }

      + ports {
          + external = 5000
          + internal = 5000
          + ip       = "0.0.0.0"
          + protocol = "tcp"
        }
    }

  # docker_image.microservice will be created
  + resource "docker_image" "microservice" {
      + id          = (known after apply)
      + image_id    = (known after apply)
      + latest      = (known after apply)
      + name        = "microservice"
      + output      = (known after apply)
      + repo_digest = (known after apply)

      + build {
          + dockerfile = "Dockerfile"
          + path       = "../microservice/."
          + remove     = true
          + tag        = [
              + "microservice:latest",
            ]
        }
    }

Plan: 2 to add, 0 to change, 0 to destroy.

Do you want to perform these actions?
  Terraform will perform the actions described above.
  Only 'yes' will be accepted to approve.

  Enter a value: yes

docker_image.microservice: Creating...
docker_image.microservice: Creation complete after 2s [id=sha256:36531df3323e3b9a25a7ccce94ab3cc1370e5dddb813990d2b99287bb47b52b9microservice]
docker_container.microservice: Creating...
docker_container.microservice: Creation complete after 0s [id=ee66d865cba3d49032c455f170e380de92e299faddfe9faff6810621c18a836a]

Apply complete! Resources: 2 added, 0 changed, 0 destroyed.
```


Para destruir todo lo que se creó hacemos un terraform destroy

```javascript
terraform destroy

docker_image.microservice: Refreshing state... [id=sha256:36531df3323e3b9a25a7ccce94ab3cc1370e5dddb813990d2b99287bb47b52b9microservice]
docker_container.microservice: Refreshing state... [id=ee66d865cba3d49032c455f170e380de92e299faddfe9faff6810621c18a836a]

Terraform used the selected providers to generate the following execution plan. Resource actions are indicated with the following symbols:
  - destroy

Terraform will perform the following actions:

  # docker_image.microservice will be destroyed
  - resource "docker_image" "microservice" {
      - id       = "sha256:36531df3323e3b9a25a7ccce94ab3cc1370e5dddb813990d2b99287bb47b52b9microservice" -> null
      - image_id = "sha256:36531df3323e3b9a25a7ccce94ab3cc1370e5dddb813990d2b99287bb47b52b9" -> null
      - latest   = "sha256:36531df3323e3b9a25a7ccce94ab3cc1370e5dddb813990d2b99287bb47b52b9" -> null
      - name     = "microservice" -> null

      - build {
          - build_arg    = {} -> null
          - dockerfile   = "Dockerfile" -> null
          - force_remove = false -> null
          - label        = {} -> null
          - no_cache     = false -> null
          - path         = "../microservice/." -> null
          - remove       = true -> null
          - tag          = [
              - "microservice:latest",
            ] -> null
        }
    }

Plan: 0 to add, 0 to change, 1 to destroy.

Do you really want to destroy all resources?
  Terraform will destroy all your managed infrastructure, as shown above.
  There is no undo. Only 'yes' will be accepted to confirm.

  Enter a value: yes

docker_image.microservice: Destroying... [id=sha256:36531df3323e3b9a25a7ccce94ab3cc1370e5dddb813990d2b99287bb47b52b9microservice]
docker_image.microservice: Destruction complete after 0s

Destroy complete! Resources: 1 destroyed.
```

