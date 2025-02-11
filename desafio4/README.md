O time de desenvolvimento acionou o suporte através da abertura de ticket porque o step de deploy dev está falhando. Você analisou o problema e viu que existe uma configuração incorreta do OAM (Open Application Model) do projeto. O time informou que gostaria de fazer deploy no openshift com o namespace mbb-ms-dev, registry no artifactory com o path mbb-images-dev.

### Passos para Configurar e Executar o Deploy

1. **Verifique qual o CI_ID para esse deploy ocorrer**
   - Entre no OAM fornecido nesse desafio e encontre o CI_ID que resolveria a situação-problema acima. 

2. **Verifique qual environment name e environment type**
   - Com o CI_ID em mãos, verifique qual o environment name e para o cenário de CERTIFICATION (pois o deploy é dev). Com essa informação, renomeie o NOME DA PASTA de deploy no .gluon/cd com o environment name encontrado.

3. **Adicione o CI_ID**
   - Adicione o CI_ID correto no cd.yml da pasta de configuração citada acima. 
   Obs: somente configuração do CI_ID de dev.

# Documentação
https://gluon.gs.corp/community/docs/latest/application/release-management/oam/