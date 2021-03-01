# React JS App with docker-compose

# build from Dockerfile to image

    $ docker build -t frontend:1.0.0 .

# run test

    $ docker run -p 3000:3000 frontend

# run container permanently

    $ docker run -t -d -p 3000:3000 frontend 

# https://www.bogotobogo.com/DevOps/Docker/Docker-React-App.php
# https://github.com/Aakashdeveloper/EDU_May_React_Eveng