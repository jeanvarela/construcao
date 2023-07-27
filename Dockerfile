# Use uma imagem do Maven para a construção
FROM maven:3.8.3-openjdk-17 as build

WORKDIR /app
COPY . /app

# Build da aplicação Spring Boot
RUN mvn package

# Etapa de criação da imagem final
FROM openjdk:17-jre

WORKDIR /app

# Instala o utilitário netcat no contêiner
RUN apt-get update && apt-get install -y netcat

# Copia o jar construído da pasta target para a imagem final
COPY --from=build /app/target/construction.jar /app/app.jar

# Aguarda até que o MySQL esteja pronto na porta 3306
# Você pode ajustar o tempo de espera e/ou implementar uma lógica mais sofisticada aqui, se necessário
CMD ["sh", "-c", "while ! nc -z mysql 3306; do sleep 1; done; java -jar app.jar"]