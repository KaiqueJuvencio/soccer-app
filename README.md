# :soccer: soccer-app :soccer:

## Pipeline:
- GitHub Actions
- É possível ver o comandos completos no arquivo: .github/workflows/main.yml
- Link do deploy da aplicação : https://soccer-app.herokuapp.com/home

## 1º Step
Sobe um container composto no docker-compose onde faz um check na instância do postgres que é usada pela aplicação
```bash
postgres-check:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: postgres up
        run: docker-compose up -d db | tee build.log
```

## 2º Step
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

## 3º Step
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

![image](https://user-images.githubusercontent.com/39711228/226415118-2589713d-3476-47ff-8e46-c4dd107e86c6.png)


