VRaptor 4 Template Using Ivy
==========

Dependências
-------------

* Java 8
* WildFly 8.2 (JBoss AS Tools)
* Ivy (IvyDe)

Instalação
-----------

Baixe o projeto utilizando a linha de comando.

```
git clone git@bitbucket.org:umovme/vraptor4template.git vraptor4template

```
Importe o projeto em seu eclipse, e instale a versão mais recente do plugin JBoss AS Tools.


Baixe a versão mais atualizada do WildFly através do link a seguir

```
http://download.jboss.org/wildfly/8.2.0.Final/wildfly-8.2.0.Final.tar.gz

```
Descompacte o servidor de aplicação em seu ambiente de desenvolvimento, vinculando e inicializando o servidor com JBoss AS Tools e eclipse.


Baixe a última versão do driver jdbc do PostgreSQL:

```
cd /tmp

```
```
wget https://jdbc.postgresql.org/download/postgresql-9.4-1200.jdbc4.jar

```


Abra o diretório /bin dentro do servidor de aplicação, para realizar algumas configurações pelo terminal. Execute os comandos para acessar o servidor.

```
./jboss-cli.sh

```
```
connect

```


Adicione um novo módulo no servidor para o driver jdbc do PostgreSQL:

```
module add --name=org.postgres --resources=/tmp/postgresql-9.4-1200.jdbc4.jar --dependencies=javax.api,javax.transaction.api

```

Instale o driver jdbc no Wildfly:

```
/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

```

Crie um Datasource para a aplicação no Wildfly:

```
/subsystem=datasources/data-source="vraptor4templateDS":add(jndi-name="java:jboss/datasources/vraptor4templateDS",driver-name="postgres",connection-url="jdbc:postgresql://192.168.150.175:5432/dese_umov_platform",user-name="postgres",password="postgres")

```

Teste a conexão do banco usando o Datasource:

```
/subsystem=datasources/data-source=vraptor4templateDS:test-connection-in-pool

```

Feche o jboss-cli:

```
exit

```

Volte ao eclipse, selecione o projeto para adicionar aos artefatos de deploy do servidor.
Verifique o projeto requisitando a url de index com a versão da aplicação através do link:

```
http://localhost:8080/vraptor4template

```
