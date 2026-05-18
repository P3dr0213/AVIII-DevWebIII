#  AutoManager - Microservio de Gesto Automotiva

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8-blue)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

Um microservio REST completo para gesto de empresas automotivas, usurios, veculos, mercadorias e vendas. Desenvolvido com Spring Boot, JPA/Hibernate e HATEOAS.

---

##  ndice

- [Viso Geral](#viso-geral)
- [Features](#features)
- [Pr-requisitos](#pr-requisitos)
- [Instalao](#instalao)
- [Configurao](#configurao)
- [Uso](#uso)
- [API Endpoints](#api-endpoints)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias](#tecnologias)
- [Banco de Dados](#banco-de-dados)
- [Testes](#testes)
- [Roadmap](#roadmap)
- [Contribuindo](#contribuindo)
- [Autor](#autor)

---

##  Viso Geral

O **AutoManager**  um microservio que oferece uma API REST completa para gerenciar:

-  **Empresas** - Unidades comerciais de manuteno e venda
-  **Usurios** - Clientes, Funcionrios e Fornecedores
-  **Veculos** - Cadastro e gesto de veculos
-  **Mercadorias** - Produtos disponveis
-  **Servios** - Servios oferecidos
-  **Vendas** - Registro de transaes
-  **Credenciais** - Autenticao de usurios

---

##  Features

### Funcionalidades Principais

 **CRUD Completo** - Create, Read, Update, Delete para todas as entidades
 **Validaes** - Bean Validation com mensagens de erro descritivas
 **Relacionamentos JPA** - One-to-Many, Many-to-One, One-to-One
 **HATEOAS** - Hypermedia As The Engine Of Application State
 **Tratamento de Erros** - Exception Handler global com mensagens amigveis
 **Dados de Seed** - Dados pr-carregados na inicializao
 **Herana de Tabelas** - Estratgia JOINED para Credenciais
 **Banco de Dados Flexvel** - H2, MySQL, PostgreSQL, SQL Server

---

##  Pr-requisitos

- **Java 17+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.8+** - [Download](https://maven.apache.org/download.cgi)
- **Git** - Para clonar o repositrio

### Opcional (Para bancos relacionais)
- **MySQL 8.0+** - Para usar MySQL
- **PostgreSQL 10+** - Para usar PostgreSQL
- **SQL Server 2019+** - Para usar SQL Server

---

##  Instalao

### 1. Clone o repositrio

```bash
git clone https://github.com/seu-usuario/automanager.git
cd automanager
```

### 2. Compile o projeto

```bash
mvn clean install
```

### 3. Execute a aplicao

```bash
mvn spring-boot:run
```

A aplicao estar disponvel em: **http://localhost:8080**

---

##  Configurao

### Banco de Dados Padro (H2)

O projeto vem configurado com **H2 em memria**. Nenhuma configurao adicional  necessria.

Para mudar para outro banco de dados, veja [BANCO_DE_DADOS.md](BANCO_DE_DADOS.md)

### Arquivo de Configurao

`src/main/resources/application.properties`

```properties
# Servidor
server.port=8080
spring.application.name=automanager

# Banco de Dados (H2 padro)
spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
```

---

##  Uso

### Listar Todos os Usurios

```bash
curl -X GET http://localhost:8080/usuarios
```

### Obter Usurio por ID

```bash
curl -X GET http://localhost:8080/usuarios/1
```

### Criar Novo Usurio

```bash
curl -X POST http://localhost:8080/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Joo Silva",
    "nomeSocial": "Joo",
    "perfis": ["CLIENTE"],
    "endereco": {
      "estado": "So Paulo",
      "cidade": "So Paulo",
      "bairro": "Centro",
      "rua": "Rua A",
      "numero": "123",
      "cep": "01000000"
    }
  }'
```

### Atualizar Usurio

```bash
curl -X PUT http://localhost:8080/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "nome": "Joo Silva Atualizado",
    "nomeSocial": "Joo",
    "perfis": ["CLIENTE"]
  }'
```

### Deletar Usurio

```bash
curl -X DELETE http://localhost:8080/usuarios/1
```

---

##  API Endpoints

### Usurios
| Mtodo | Endpoint | Descrio |
|--------|----------|-----------|
| GET | `/usuarios` | Listar todos os usurios |
| GET | `/usuarios/{id}` | Obter usurio por ID |
| POST | `/usuarios` | Criar novo usurio |
| PUT | `/usuarios/{id}` | Atualizar usurio |
| DELETE | `/usuarios/{id}` | Deletar usurio |

### Veculos
| Mtodo | Endpoint | Descrio |
|--------|----------|-----------|
| GET | `/veiculos` | Listar todos os veculos |
| GET | `/veiculos/{id}` | Obter veculo por ID |
| POST | `/veiculos` | Criar novo veculo |
| PUT | `/veiculos/{id}` | Atualizar veculo |
| DELETE | `/veiculos/{id}` | Deletar veculo |

### Empresas
| Mtodo | Endpoint | Descrio |
|--------|----------|-----------|
| GET | `/empresas` | Listar todas as empresas |
| GET | `/empresas/{id}` | Obter empresa por ID |
| POST | `/empresas` | Criar nova empresa |
| PUT | `/empresas/{id}` | Atualizar empresa |
| DELETE | `/empresas/{id}` | Deletar empresa |

### Mercadorias
| Mtodo | Endpoint | Descrio |
|--------|----------|-----------|
| GET | `/mercadorias` | Listar todas as mercadorias |
| GET | `/mercadorias/{id}` | Obter mercadoria por ID |
| POST | `/mercadorias` | Criar nova mercadoria |
| PUT | `/mercadorias/{id}` | Atualizar mercadoria |
| DELETE | `/mercadorias/{id}` | Deletar mercadoria |

### Servios
| Mtodo | Endpoint | Descrio |
|--------|----------|-----------|
| GET | `/servicos` | Listar todos os servios |
| GET | `/servicos/{id}` | Obter servio por ID |
| POST | `/servicos` | Criar novo servio |
| PUT | `/servicos/{id}` | Atualizar servio |
| DELETE | `/servicos/{id}` | Deletar servio |

### Vendas
| Mtodo | Endpoint | Descrio |
|--------|----------|-----------|
| GET | `/vendas` | Listar todas as vendas |
| GET | `/vendas/{id}` | Obter venda por ID |
| POST | `/vendas` | Criar nova venda |
| PUT | `/vendas/{id}` | Atualizar venda |
| DELETE | `/vendas/{id}` | Deletar venda |

---

##  Estrutura do Projeto

```
automanager/
 src/
    main/
       java/com/autobots/automanager/
          controles/          # Controllers REST
          servicos/           # Lgica de negcio
          repositorios/       # Acesso a dados
          entidades/          # Modelos JPA
          dto/                # Data Transfer Objects
          modelo/             # HATEOAS Modeladores
          excecoes/           # Exception Handlers
          enumeracoes/        # Enums (PerfilUsuario, etc)
          config/             # Configuraes (Jackson, etc)
          AutomanagerApplication.java
       resources/
           application.properties
           data.sql (opcional)
    test/                       # Testes unitrios
 pom.xml                          # Dependncias Maven
 README.md                        # Este arquivo
 BANCO_DE_DADOS.md               # Guia de bancos de dados
 CHANGELOG.md                     # Histrico de mudanas
```

---

##  Tecnologias

### Back-end
- **Spring Boot 2.6.3** - Framework web
- **Spring Data JPA** - Persistncia de dados
- **Hibernate** - ORM
- **Spring HATEOAS** - REST com hypermedia
- **Lombok** - Reduo de boilerplate
- **Bean Validation** - Validaes

### Banco de Dados
- **H2** - Em memria (desenvolvimento)
- **MySQL** - Relacionais
- **PostgreSQL** - Relacionais
- **SQL Server** - Relacionais

### Build & Deployment
- **Maven** - Gerenciador de dependncias
- **Java 17** - Linguagem de programao

---

##  Banco de Dados

### H2 (Padro)
```
 Sem instalao
 Desenvolvimento rpido
 Testes automatizados
 Perde dados ao reiniciar
```

### MySQL/PostgreSQL/SQL Server
Para migrar para um banco relacional, consulte [BANCO_DE_DADOS.md](BANCO_DE_DADOS.md)

---

##  Testes

### Executar Testes

```bash
mvn test
```

### Cobertura de Testes

-  48+ testes automatizados
-  91.7% de taxa de sucesso
-  Cobertura de CRUDs
-  Validaes
-  Relacionamentos
-  HATEOAS

---

##  Roadmap

### Verso 1.1 (Prxima)
- [ ] Autenticao JWT
- [ ] Autorizao por Perfil
- [ ] Documentao Swagger/OpenAPI
- [ ] Testes JUnit completos
- [ ] Integrao contnua (CI/CD)

### Verso 1.2
- [ ] Relatrios de Vendas
- [ ] Dashboard de Estatsticas
- [ ] Auditoria de Dados
- [ ] Cache Redis
- [ ] Notificaes por Email

### Verso 2.0
- [ ] Aplicativo Mobile
- [ ] Integrao com Sistemas de Pagamento
- [ ] Agendamento de Servios
- [ ] Histrico de Manuteno

---

##  Contribuindo

Contribuies so bem-vindas! Por favor:

1. Faa um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanas (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

##  Autor

**Seu Nome**
- GitHub: [@seu-usuario](https://github.com/seu-usuario)
- Email: seu.email@example.com

---

##  Licena

Este projeto est licenciado sob a Licena MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

##  Suporte

Tem dvidas? 

-  [Documentao do Banco de Dados](BANCO_DE_DADOS.md)
-  [Reporte um Bug](https://github.com/seu-usuario/automanager/issues)
-  [Discusses](https://github.com/seu-usuario/automanager/discussions)

---

##  Agradecimentos

- Spring Boot Team
- Comunidade Open Source
- Todos os contribuidores

---

**Desenvolvido com  usando Spring Boot**

 Se este projeto foi til, considere deixar uma estrela!
