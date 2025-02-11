
### Desafio Prático: Integração Contínua com GitHub Actions e Ferramentas do Gluon

#### Objetivo

Criar uma Action do GitHub que será lançada sempre que houver commit na branch main, deve executar os seguintes passos:

* Instalar as dependências do projeto.
* Faça o build e gere um pacote da aplicação
* Execute os teste unitários
* Armazene os artefatos como release do github.
* Usar as evironments do githubpara restringir a aprovação do deploy para um usuário ou grupo do github
* Fazer o deploy no ambiente de teste.
