# Tecnologias de Programação: TP Sockets

**Professor:** João Eduardo Montandon

**Disciplina:** Tecnologias de Programação

**Valor:** 15 pontos

**Nº de integrantes:** 4 alunos

## QualéZé

O WhatsApp foi tomado por comunistas!! Você e seus colegas, dispostos fazer frente a esse movimento, decidiram implementar seu próprio aplicativo de chat. O aplicativo, chamado QualéZé, é destinado especificamente ao público brasileiro.

Você e seu grupo decidiram criar uma versão alternativa do sistema, voltada especificamente para vocês. Em uma reunião com os integrantes do grupo, foi definido que o sistema de vocês deverá implementar os seguintes módulos:

1. Servidor
1. Cliente Android

As seções abaixo descreverão cada módulo em detalhe:

### Servidor

O módulo de servidor deverá controlar a conexão e comunicação entre os usuários do chat. *Toda a comunicação ao servidor deverá ser feita através de sockets!!*

O servidor deverá gerenciar as salas de bate-papo disponíveis no chat. Mais especificamente, seu sistema deverá suportar pelo menos quatro tipos diferentes de salas:

* Geral
* Eventos
* Oportunidades
* OffTopic

Essas listas deverão estar disponíveis por padrão para seus usuários escolherem em qual eles irão se conectar.

Além disso, seu servidor deverá implementar as seguintes funcionalidades:

1. **Identificação do usuário:** seu servidor deverá identificar, de alguma forma, os usuários conectados nas salas. Essa informação será utilizada posteriormente no Cliente Android.
1. **Notificações:** o servidor deverá notificar no chat quando houver a entrada ou saída de usuários nas respectivas salas de bate-papo. Essas notificações deverão ser feitas no formato de mensagens.

### Cliente Android

Você deverá implementar um cliente em Android que irá se conectar ao servidor descrito anteriormente. Como é de se esperar, essa comunicação também deverá ser feita via sockets. Seu aplicativo deverá cumprir as seguintes restrições:

1. **Listar salas de bate-papo:** Seu aplicativo deverá listar na tela inicial as salas de bate-papo disponíveis no servidor. O usuário selecionará qual sala ele deseja se conectar através dessa lista.
1. **Listar os usuários conectados na sala:** Uma vez escolhido a sala, seu aplicativo deverá fornecer uma tela que liste os usuários conectados nessa sala.

## Avaliação

O trabalho será avaliado por meio de uma entrevista e análise do código-fonte dos aplicativos de cliente e servidor entregues até a data limite. Entre outros quesitos, serão levados em consideração:

* Desenvoltura do grupo na entrevista
* Conhecimento do código implementado, bem como dos padrões adotados
* Implementação das funcionalidades
* Organização e legibilidade do código
* Comentários e documentação