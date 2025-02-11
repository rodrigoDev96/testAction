# Desafio 3

Suponha que sua equipe gostaria de homologar uma nova tecnologia que não está disponível no Portal Gluon de criação de componentes. Você, federado, propõe criar um Component Template novo para disponibilizar para toda empresa. Monte o Component Template que deve conter as seguintes especificidades:

1. Configurar o `definition.yml`:
  - Nome e descrição do Component Template;
  - Labels com framework, tecnologia, linguagem;
  - Preencher com true/false os campos `visible`, `catalog.enabled`, `sast`, `sca`.

2. Configurar o `data-schema.json`:
  - Remover a opção de criação com `TBD`;
  - Adicionar um selecionador de versão da aplicação. 
    Exemplo: se o componente for Angular teria as opções [15, 16]

    Exemplo de selecionador do Sonar: 
    ```json
    "sonar_profile": {
      "title": "Sonar profile",
      "description": "Sonar profile for components created",
      "enumNames": [
        "1",
        "2"
      ],
      "enum": [
        "1",
        "2"
      ]
    }
    ```

3. `setup.sh` deve alterar o nome do `FORTIFY_PROJECT` e `SONAR_PROJECT_KEY` no arquivo properties.env (Dica: utilize `sed`) e deve conter um script de inicialização, podendo ser uma inicialização de projeto com a tecnologia de sua escolha (ex: java, angular, react, etc) e você deve utilizar o valor da versão criada anteriormente. Disponibilizaremos workflows para java e npm.

Lembrando que em tempo de execução o pipeline de scaffolding do GitHub Actions passa essas informações coletando diretamente da API do Portal Gluon.

4. Estilize da maneira que quiser utilizando o `presentation-schema`.    

5. Adicione os workflows de usuário corretos na pasta `src/.github/workflows`. 
  Disponibilizaremos workflows para java e npm, selecione quais são e os coloque nessa pasta.

### Documentação

https://gluon.gs.corp/community/docs/latest/contribute/base-component-template/