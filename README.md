# :soccer: soccer-app 

## :warning: Considerações :warning:
- Usamos GitHub Actions
- É possível ver os comandos completos no arquivo: .github/workflows/main.yml
- Link do deploy da aplicação: https://soccer-app.herokuapp.com/home
- Link análise SonaQube: https://sonarcloud.io/project/overview?id=KaiqueJuvencio_soccer-app


## Tech Stack

<div style="display: inline_block">
    <img align="center" alt="Java" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">
    <img align="center" alt="Postgres" height="50" width="50"  src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" />
    <img align="center" alt="Docker" height="70" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" />
    <img align="center" alt="JavaScript" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" />
    <img align="center" alt="JavaScript" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" />
    <img align="center" alt="JavaScript" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" />    
</div>
<br>
Tecnologias usadas para construir a aplicação

- Java (jdk-11.0.2)
- Postgres
- Docker/Docker Compose
- Front: HTML5, CSS3, JavaScript

## Pipeline:

## 1º Step
Faz o build da apliação java
```bash
  java-build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Setup Java JDK
        uses: actions/setup-java@v3.10.0
        with:
          java-version: 11
          distribution: adopt-openj9
      - name: mvn clean install
        run: mvn clean install    
```

## 2º Step
Faz uma análise do código com SonaQube
```bash
  sonar-analyze:
    name: sonar-analyze
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
        with:
          fetch-depth: 0  # Shallow clones should be disabled for a better relevancy of analysis
      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: 11
          distribution: 'zulu' # Alternative distribution options are available.
      - name: Cache SonarCloud packages
        uses: actions/cache@v3
        with:
          path: ~/.sonar/cache
          key: ${{ runner.os }}-sonar
          restore-keys: ${{ runner.os }}-sonar
      - name: Cache Maven packages
        uses: actions/cache@v3
        with:
          path: ~/.m2
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
          restore-keys: ${{ runner.os }}-m2
      - name: Build and analyze
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}  # Needed to get PR information, if any
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}
        run: mvn -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=KaiqueJuvencio_soccer-app  
```

## 3º Step
Sobe um container composto no docker-compose onde faz um check na instância do postgres que é usada pela aplicação
```bash
postgres-check:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: postgres up
        run: docker-compose up -d db | tee build.log
```

## 4º Step
Realiza um deploy no Heroku
```bash
deploy-dev:
    runs-on: ubuntu-latest
    needs: java-build
    steps:
      - uses: actions/checkout@v2
      - uses: akhileshns/heroku-deploy@v3.12.12
        with: 
          heroku_api_key: ${{ secrets.HEROKU_API_KEY }}
          heroku_app_name: "soccer-app"
          heroku_email: kaiquejuvencio@hotmail.com
```

![image](https://user-images.githubusercontent.com/39711228/226448529-576aa6c8-048f-4992-a58f-f547b360f3a5.png)



