  # Spring boot, mysql and react js using docker deployment

    1. Spring Boot framework
    2. Mysql database
    3. React JS
    
   
  Exec to Container 
  
    $ docker exec -i -t ${CONTAINER_ID} /bin/sh
    
  Docker 
    
    $ docker run ${CONTAINER_ID}  
    
  Docker Compose
    
    $ docker-compose up -d
    
    or 
    
    $ docker-compose up -d --build
    
    
    $ docker-compose stop


  Remove All Docker Containers
   
    $ docker container stop $(docker container ls –aq) && docker system prune –af ––volumes

  Remove All Stopped Containers
  
    $ docker container rm $(docker container ls -aq)


  Remove all images
  
    List:
    $ docker images -a
    
    Remove:
    $ docker rmi $(docker images -a -q)

  Purging All Unused or Dangling Images, Containers, Volumes, and Networks
  
    $ docker system prune
    $ docker system prune -a
