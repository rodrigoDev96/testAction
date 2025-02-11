# Desafio 2

Corrija o Dockerfile e aponte os erros por meio de comentários.

Você pode usar uma aplicação Java qualquer para testar!! 

### Correção do Dockerfile

```dockerfile
# Use uma imagem base adequada para Java
FROM openjdk:11-jre-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/cerveja-gluon.jar app.jar

# Exponha a porta que a aplicação irá usar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Passos para Executar o Fluxo CI Novamente

1. **Atualize o Dockerfile**
   - Certifique-se de que o Dockerfile está correto e atualizado conforme o exemplo acima.

2. **DIFERENCIAL NÃO OBRIGATÓRIO** Execute o Dockerfile
   - Crie uma Action no GitHub que execute o Dockerfile corrigido.
   - Adicione essa Action na pasta do desafio.
