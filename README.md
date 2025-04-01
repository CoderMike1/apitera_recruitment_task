# ATIPERA RECRUITMENT TASK #

![Java](https://img.shields.io/badge/java-21-red?style=for-the-badge&logo=java&color=red)
![Spring](https://img.shields.io/badge/spring-3.4.4-green?style=for-the-badge&logo=spring-boot)

## 🔍General Info ##

This REST API is a task for Atipera Internship Program.<br>
Application allows to get a list of repositories from specific github user.
Written in JAVA 21 with Spring Boot framework.

# ❗️IMPORTANT

**Make sure to put a github access token to 'src/main/resources/application.properties' before running an application.**

## Build & Run

Firstly, please clone the repository to your directory and select a correct folder
```
git clone https://github.com/CoderMike1/atipera_recruitment_task.git

cd atipera_recruitment_task
```
then you can build and run app
```
./mvnw clean package
java -jar target/apiteraApp.jar
```

## Endpoint

Request:<br>
``
GET http://localhost:8080/api/getRepos/{ownerLogin}
``

Success Response Example:<br>
``200 status code``
```
[
    {
        "repositoryName": "apartment_price_predictor",
        "ownerLogin": "CoderMike1",
        "branches": [
            {
                "branchName": "main",
                "sha": "f18ec752659f07ddf6e33c38c095291fbd0249ff"
            }
        ]
    },
    {
        "repositoryName": "atipera_recruitment_task",
        "ownerLogin": "CoderMike1",
        "branches": [
            {
                "branchName": "main",
                "sha": "3a90bd52733bce0dff85f263de5721247a3c9a5a"
            }
        ]
    }
]
```

Error Response Example:<br>
``404 status code``
```
{
    "statusCode": 404,
    "message": "user 'pff9239' not found."
}
```


