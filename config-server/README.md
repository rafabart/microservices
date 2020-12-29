Servido de configuração dos microserviços.
Aplicação que centraliza as configurações (application.yml) de todos os microserviços.


GET:```http://localhost:8888/"nome do microserviço"/"profile"```

Busca e exibe as configurações de um determinado microserviço e perfil de execução(profile).


Exemplo: ```http://localhost:8888/hr-worker/prod```

Busca e exibe as configurações da api hr-worker com profile de produção.


GET:```ttp://localhost:8888/configs/default```

Busca e exibe as configurações do proprio config-server no profile default.
