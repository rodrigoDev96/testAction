# O Desafio

Você é um programador talentoso encarregado de subir os códigos. No entanto, o caminho para a produção está cheio de desafios. Você precisa corrigir problemas no fluxo de CI/CD e garantir que o código esteja implantado de forma segura e funcional. 

## Setup

1. Faça fork do repositório para o seu usuário t ou x.
2. Resolva os 4 desafios.

## Estrutura do desafio

| Desafio   | Descrição                                                         | Pontos |
|:----------|:------------------------------------------------------------------|:-------|
| Desafio 1 | [Criar uma Action do GitHub](./desafio1/README.md)                | 10     |
| Desafio 2 | [Dockerfile e Fluxo Git Flow](./desafio2/README.md)               | 10     |
| Desafio 3 | [Criar um novo Component Template](./desafio3/README.md)          | 25     |
| Desafio 4 | [Definir OAM para deploy de um Microservice](./desafio4/README.md)| 15     |


## Desafios

### Desafio 1

Criar uma Action do GitHub que será ativido sempre que houver commit na branch main que execute os seguintes passos:

* Instalar as dependências do projeto.
* Faça o build e gere um pacote da aplicação
* Execute os teste unitários
* Armazene os artefatos como release do github.
* Usar as evironments do githubpara restringir a aprovação do deploy para um usuário ou grupo do github
* Fazer o deploy no ambiente de teste.

Veja o desafio detalhado aqui [Step by step](./desafio1/README.md)


### Desafio 2

Corrija o Dockerfile e aponte os erros por meio de comentários.
DIFERENCIAL NÃO OBRIGATÓRIO: Execute o Dockerfile corrigido em uma Action no GitHub. 
Adicione essa Action na pasta do desafio.

Veja o desafio detalhado aqui [Step by step](./desafio2/README.md)


### Desafio 3

Sua equipe gostaria de homologar uma nova tecnologia que não está disponível no Portal Gluon de criação de componentes. Você, federado, propõe criar um **Component Template** novo para disponibilizar para toda empresa. Monte o Component Template que deve conter as seguintes especificidades:  


Veja o desafio detalhado aqui [Step by step](./desafio3/README.md)



### Desafio 4

O time de desenvolvimento acionou o suporte através da abertura de ticket porque o step de deploy dev está falhando. Você analisou o problema e viu que existe uma configuração incorreta do OAM (Open Application Model) do projeto. O time informou que gostaria de fazer deploy no openshift com o namespace mbb-ms-dev, registry no artifactory com o path mmb-images-dev.  

Configure o OAM dev corretamente conforme essas informações, você pode consultar o OAM que se encontra nessa pasta. 

Veja o desafio detalhado aqui [Step by step](./desafio4/README.md)


