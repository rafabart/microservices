# microservices

Projeto de estudo de microserviços:  
    
    -> congig-server: api responsável por centralizar as configurações das apis. Acessa um repositório no github onde ficam todas as configurações das apis.  
    
    -> eureka-server: api responsável por registrar todas apis em execução.

    -> api-gateway-zuul: api responsável por orquestrar as requisições, ela faz a comunicação do ambiente externo com o ambiente onde estão as apis.

    -> oauth: responsável por autenticar o usuário e liberar o token de acesso as apis.

    -> user: crud responsável pelos dados do usuário.

    -> hr-worker: crud responsável pelo funcionário. (escalável)

    -> hr-payroll: api que calcula os pagamentos dos funcionários. (escalável)  
  
  </br>  
  
 # Endpoints

Login  
GET: http://localhost:8765/oauth/oauth/token  

Listar todos usuários:  
GET: http://localhost:8765/user/users  

Listar todos funcionários:  
GET: http://localhost:8765/hr-worker/workers

Calcular pagamento por funcionário(1) e dia (20):  
GET: http://localhost:8765/hr-payroll/payments/1/days/20  

 </br> 

 # Ambiente de Dev com somente bancos de dados em containers docker

Criar rede docker para sistema:  
```docker network create hr-net```  

Postgresql:  
```docker pull postgres:12-alpine```

```docker run -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres:12-alpine```

```docker run -p 5432:5432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres:12-alpine```

</br> 

# Ambiente de Prod com tudo em containers docker

Criar rede docker para sistema:  
```docker network create hr-net```  