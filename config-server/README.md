### Servido de configuração dos microserviços.  
Aplicação que centraliza as configurações (application.yml) de todos os microserviços.


GET:```http://localhost:8888/"nome do microserviço"/"profile"```  
Busca e exibe as configurações de um determinado microserviço e perfil de execução(profile).


Exemplo: ```http://localhost:8888/hr-worker/prod```  
Busca e exibe as configurações da api hr-worker com profile de produção.


GET:```http://localhost:8888/configs/default```  
Busca e exibe as configurações do proprio config-server no profile default.



### Criando uma imagem docker da api.

Para criar uma imagem docker da api basta gerar o artefato .jar e executar o comando na raiz do projeto:  
```docker build -t hr-config-server:v1 .```  

Rodar o comando abaixo para criar e rodar o cotainer da imagem gerada:  
```docker run -p 8888:8888 --name hr-config-server --network hr-net -e "GITHUB_PASS=senha_do_github" hr-config-server:v1``  

Obs: hr-net é a rede que o container ira usar e deve ser criada antes de tudo.