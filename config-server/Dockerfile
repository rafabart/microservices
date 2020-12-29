FROM openjdk:11
VOLUME /tmp
ADD ./build/libs/config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENV GITHUB_USER=rafabart
#ENV GITHUB_PASS=
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]

# Lembrar de colocar a senha no GITHUB_PASS, assim quando construir o build da imagem
# docker da aplicação config-server não será necessário passar a senha na execução do
# do container (docker run -e). Assim evintando problemas com caracteres especias.