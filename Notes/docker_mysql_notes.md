Connecting to mysql container from the cmd

Prerequisites:
  - container was created
  - mysql user 'springstudent' exists

To run the created mysql docker container:
> docker start <container-name>

To open a remote shell inside that container:
> docker exec -it <container-id-or-name> /bin/bash

Connect to mysql:
> mysql -u springstudent -p
> 
> use <database-name>
> 
> show tables;