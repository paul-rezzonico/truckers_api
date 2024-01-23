docker build --tag "truckers_api" .
docker run -p 8080:8080 -d --name "truckers_api" truckers_api