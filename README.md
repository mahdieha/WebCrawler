# WebCrawler

This is a web crawler that uses the Jsoup library to extract general information from the HTML page by entering the web address and store the information in the SQLite database.


## Running the application locally


You can run this program in two ways:

1.  Maven
```bash
mvn spring-boot:run
```

2. Docker (make sure docker dameon is running)
```bash
mvn clean package
docker build -t web-crawler .
docker run -d -p 8085:8085 -t web-crawler
```
After running the program, you can call the API through the Swagger from the following address:

```bash
http://localhost:8085/swagger-ui.html
```

## Run JUnit test cases

```bash
mvn clean test
```