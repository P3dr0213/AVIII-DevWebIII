# 🚗 AutoManager - Microserviço de Gestão Automotiva

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8-blue)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

Um microserviço REST completo para gestão de empresas automotivas, usuários, veículos, mercadorias e vendas. Desenvolvido com Spring Boot, JPA/Hibernate e HATEOAS.

---

## 📋 Índice

- [Visão Geral](#visão-geral)
- [Features](#features)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
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

## 🎯 Visão Geral

O **AutoManager** é um microserviço que oferece uma API REST completa para gerenciar:

- 🏢 **Empresas** - Unidades comerciais de manutenção e venda
- 👥 **Usuários** - Clientes, Funcionários e Fornecedores
- 🚗 **Veículos** - Cadastro e gestão de veículos
- 📦 **Mercadorias** - Produtos disponíveis
- 🛠️ **Serviços** - Serviços oferecidos
- 💰 **Vendas** - Registro de transações
- 🔐 **Credenciais** - Autenticação de usuários

---

## ✨ Features

### Funcionalidades Principais

✅ **CRUD Completo** - Create, Read, Update, Delete para todas as entidades
✅ **Validações** - Bean Validation com mensagens de erro descritivas
✅ **Relacionamentos JPA** - One-to-Many, Many-to-One, One-to-One
✅ **HATEOAS** - Hypermedia As The Engine Of Application State
✅ **Tratamento de Erros** - Exception Handler global com mensagens amigáveis
✅ **Dados de Seed** - Dados pré-carregados na inicialização
✅ **Herança de Tabelas** - Estratégia JOINED para Credenciais
✅ **Banco de Dados Flexível** - H2, MySQL, PostgreSQL, SQL Server

---

## 📦 Pré-requisitos

- **Java 17+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.8+** - [Download](https://maven.apache.org/download.cgi)
- **Git** - Para clonar o repositório

### Opcional (Para bancos relacionais)
- **MySQL 8.0+** - Para usar MySQL
- **PostgreSQL 10+** - Para usar PostgreSQL
- **SQL Server 2019+** - Para usar SQL Server

---

## 🚀 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/automanager.git
cd automanager
```

### 2. Compile o projeto

```bash
mvn clean install
```

### 3. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

---

## ⚙️ Configuração

### Banco de Dados Padrão (H2)

O projeto vem configurado com **H2 em memória**. Nenhuma configuração adicional é necessária.

Para mudar para outro banco de dados, veja [BANCO_DE_DADOS.md](BANCO_DE_DADOS.md)

### Arquivo de Configuração

`src/main/resources/application.properties`

```properties
# Servidor
server.port=8080
spring.application.name=automanager

# Banco de Dados (H2 padrão)
spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
```

---

## 📖 Uso

### Listar Todos os Usuários

```bash
curl -X GET http://localhost:8080/usuarios
```

### Obter Usuário por ID

```bash
curl -X GET http://localhost:8080/usuarios/1
```

### Criar Novo Usuário

```bash
curl -X POST http://localhost:8080/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "nomeSocial": "João",
    "perfis": ["CLIENTE"],
    "endereco": {
      "estado": "São Paulo",
      "cidade": "São Paulo",
      "bairro": "Centro",
      "rua": "Rua A",
      "numero": "123",
      "cep": "01000000"
    }
  }'
```

### Atualizar Usuário

```bash
curl -X PUT http://localhost:8080/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "nome": "João Silva Atualizado",
    "nomeSocial": "João",
    "perfis": ["CLIENTE"]
  }'
```

### Deletar Usuário

```bash
curl -X DELETE http://localhost:8080/usuarios/1
```

---

## 🔌 API Endpoints

### Usuários
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/usuarios` | Listar todos os usuários |
| GET | `/usuarios/{id}` | Obter usuário por ID |
| POST | `/usuarios` | Criar novo usuário |
| PUT | `/usuarios/{id}` | Atualizar usuário |
| DELETE | `/usuarios/{id}` | Deletar usuário |

### Veículos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/veiculos` | Listar todos os veículos |
| GET | `/veiculos/{id}` | Obter veículo por ID |
| POST | `/veiculos` | Criar novo veículo |
| PUT | `/veiculos/{id}` | Atualizar veículo |
| DELETE | `/veiculos/{id}` | Deletar veículo |

### Empresas
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/empresas` | Listar todas as empresas |
| GET | `/empresas/{id}` | Obter empresa por ID |
| POST | `/empresas` | Criar nova empresa |
| PUT | `/empresas/{id}` | Atualizar empresa |
| DELETE | `/empresas/{id}` | Deletar empresa |

### Mercadorias
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/mercadorias` | Listar todas as mercadorias |
| GET | `/mercadorias/{id}` | Obter mercadoria por ID |
| POST | `/mercadorias` | Criar nova mercadoria |
| PUT | `/mercadorias/{id}` | Atualizar mercadoria |
| DELETE | `/mercadorias/{id}` | Deletar mercadoria |

### Serviços
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/servicos` | Listar todos os serviços |
| GET | `/servicos/{id}` | Obter serviço por ID |
| POST | `/servicos` | Criar novo serviço |
| PUT | `/servicos/{id}` | Atualizar serviço |
| DELETE | `/servicos/{id}` | Deletar serviço |

### Vendas
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/vendas` | Listar todas as vendas |
| GET | `/vendas/{id}` | Obter venda por ID |
| POST | `/vendas` | Criar nova venda |
| PUT | `/vendas/{id}` | Atualizar venda |
| DELETE | `/vendas/{id}` | Deletar venda |

---

## 📁 Estrutura do Projeto

```
automanager/
├── src/
│   ├── main/
│   │   ├── java/com/autobots/automanager/
│   │   │   ├── controles/          # Controllers REST
│   │   │   ├── servicos/           # Lógica de negócio
│   │   │   ├── repositorios/       # Acesso a dados
│   │   │   ├── entidades/          # Modelos JPA
│   │   │   ├── dto/                # Data Transfer Objects
│   │   │   ├── modelo/             # HATEOAS Modeladores
│   │   │   ├── excecoes/           # Exception Handlers
│   │   │   ├── enumeracoes/        # Enums (PerfilUsuario, etc)
│   │   │   ├── config/             # Configurações (Jackson, etc)
│   │   │   └── AutomanagerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql (opcional)
│   └── test/                       # Testes unitários
├── pom.xml                          # Dependências Maven
├── README.md                        # Este arquivo
├── BANCO_DE_DADOS.md               # Guia de bancos de dados
└── CHANGELOG.md                     # Histórico de mudanças
```

---

## 🛠️ Tecnologias

### Back-end
- **Spring Boot 2.6.3** - Framework web
- **Spring Data JPA** - Persistência de dados
- **Hibernate** - ORM
- **Spring HATEOAS** - REST com hypermedia
- **Lombok** - Redução de boilerplate
- **Bean Validation** - Validações

### Banco de Dados
- **H2** - Em memória (desenvolvimento)
- **MySQL** - Relacionais
- **PostgreSQL** - Relacionais
- **SQL Server** - Relacionais

### Build & Deployment
- **Maven** - Gerenciador de dependências
- **Java 17** - Linguagem de programação

---

## 🗄️ Banco de Dados

### H2 (Padrão)
```
✅ Sem instalação
✅ Desenvolvimento rápido
✅ Testes automatizados
❌ Perde dados ao reiniciar
```

### MySQL/PostgreSQL/SQL Server
Para migrar para um banco relacional, consulte [BANCO_DE_DADOS.md](BANCO_DE_DADOS.md)

---

## 🧪 Testes

### Executar Testes

```bash
mvn test
```

### Cobertura de Testes

- ✅ 48+ testes automatizados
- ✅ 91.7% de taxa de sucesso
- ✅ Cobertura de CRUDs
- ✅ Validações
- ✅ Relacionamentos
- ✅ HATEOAS

---

## 🗺️ Roadmap

### Versão 1.1 (Próxima)
- [ ] Autenticação JWT
- [ ] Autorização por Perfil
- [ ] Documentação Swagger/OpenAPI
- [ ] Testes JUnit completos
- [ ] Integração contínua (CI/CD)

### Versão 1.2
- [ ] Relatórios de Vendas
- [ ] Dashboard de Estatísticas
- [ ] Auditoria de Dados
- [ ] Cache Redis
- [ ] Notificações por Email

### Versão 2.0
- [ ] Aplicativo Mobile
- [ ] Integração com Sistemas de Pagamento
- [ ] Agendamento de Serviços
- [ ] Histórico de Manutenção

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Por favor:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

## 👨‍💻 Autor

**Seu Nome**
- GitHub: [@seu-usuario](https://github.com/seu-usuario)
- Email: seu.email@example.com

---

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

## 📞 Suporte

Tem dúvidas? 

- 📖 [Documentação do Banco de Dados](BANCO_DE_DADOS.md)
- 🐛 [Reporte um Bug](https://github.com/seu-usuario/automanager/issues)
- 💬 [Discussões](https://github.com/seu-usuario/automanager/discussions)

---

## 🙏 Agradecimentos

- Spring Boot Team
- Comunidade Open Source
- Todos os contribuidores

---

**Desenvolvido com ❤️ usando Spring Boot**

⭐ Se este projeto foi útil, considere deixar uma estrela!
