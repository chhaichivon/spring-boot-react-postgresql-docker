#### Stage 1: Build the react application
FROM node:12.18.1 as build

# set working directory
WORKDIR /app

# install app dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm install --silent
RUN npm install react-scripts@3.4.1 -g --silent

# add app
COPY . ./

# start app
CMD ["npm", "start"]

## Arguments
ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=${REACT_APP_API_BASE_URL}

## Build the application
RUN npm run build

# Stage 2: Serve the React application from Nginx
FROM nginx
#
## Copy the react build from Stage 1
COPY --from=build /app/build /var/www
#
## Copy our custom nginx config
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 3000 to the Docker host, so we can access it
# from the outside.
EXPOSE 3000

ENTRYPOINT ["nginx","-g","daemon off;"]
