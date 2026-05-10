# Changelog

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
e este projeto adere ao [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.0.0] - 2024-01-15

### ✨ Added (Adicionado)

#### Funcionalidades Principais
- ✅ CRUD completo para Usuários
- ✅ CRUD completo para Veículos
- ✅ CRUD completo para Empresas
- ✅ CRUD completo para Mercadorias
- ✅ CRUD completo para Serviços
- ✅ CRUD completo para Vendas
- ✅ Entidade de Endereço com relacionamento One-to-One
- ✅ Entidade de Telefone com relacionamento One-to-Many
- ✅ Entidade de Documento com validação única
- ✅ Entidade de Email com relacionamento One-to-Many
- ✅ Entidade de Credencial com herança (CodigoBarra e UsuarioSenha)

#### Features Técnicas
- ✅ Spring Boot 2.6.3 REST API
- ✅ JPA/Hibernate com relacionamentos complexos
- ✅ HATEOAS links em todas as respostas
- ✅ Bean Validation com mensagens personalizadas
- ✅ Exception Handler global
- ✅ Suporte a H2, MySQL, PostgreSQL, SQL Server
- ✅ Dados de seed pré-carregados na inicialização
- ✅ Jackson Configuration para null handling

#### Tipos de Usuário
- ✅ CLIENTE
- ✅ FUNCIONARIO
- ✅ FORNECEDOR

#### Tipos de Veículo
- ✅ SEDA
- ✅ SUV
- ✅ PICKUP
- ✅ VAN
- ✅ MINIBUS
- ✅ ONIBUS

#### Credenciais
- ✅ Credencial por Código de Barra
- ✅ Credencial por Usuário e Senha

### 🔧 Changed (Mudado)

- Configuração Jackson para aceitar null values
- VeiculoServico agora popula proprietario no DTO
- UsuarioModelador agora processa links HATEOAS de veículos, credenciais, mercadorias e vendas
- UsuarioServico agora popula proprietario nos veículos do usuário

### 🐛 Fixed (Corrigido)

- Corrigido erro de desserialização JSON com null values
- Corrigido proprietario em veículos não sendo retornado em listagens
- Corrigido HATEOAS links não aparecendo em sub-recursos
- Corrigido NPE em selecionadores com Long comparação
- Corrigido erro "effectively final" em UsuarioServico
- Corrigido NULL constraint error em CRIACAO de credenciais
- Corrigido detached entity error ao salvar relacionamentos

### 📦 Dependencies

- Spring Boot 2.6.3
- Spring Data JPA
- Spring HATEOAS
- Spring Validation
- Lombok 1.18.46
- H2 Database 2.2.224
- Jackson (Spring Boot padrão)

### 📊 Testes

- 48+ testes executados
- 91.7% de taxa de sucesso
- Cobertura de CRUD completo
- Cobertura de validações
- Cobertura de relacionamentos
- Cobertura de HATEOAS

### 📚 Documentação

- ✅ README.md completo
- ✅ BANCO_DE_DADOS.md com guia de configuração
- ✅ CHANGELOG.md (este arquivo)
- ✅ Scripts SQL para criar bancos

---

## [1.1.0] - Planejado

### 🔜 Será Adicionado

- Autenticação JWT
- Autorização baseada em Perfil
- Documentação Swagger/OpenAPI
- Testes JUnit completos
- Pipeline CI/CD com GitHub Actions
- Docker support
- Integração com RabbitMQ para fila de mensagens

### 🔜 Será Melhorado

- Performance com LAZY loading
- Queries otimizadas
- Cache com Redis
- Paginação em endpoints GET

---

## [1.2.0] - Planejado

### 🔜 Será Adicionado

- Relatórios de Vendas em PDF
- Dashboard de Estatísticas
- Auditoria de Dados
- Notificações por Email
- Integração com Sistemas de Pagamento

---

## [2.0.0] - Futuro

### 🔜 Será Adicionado

- Aplicativo Mobile (iOS/Android)
- Agendamento de Serviços
- Histórico de Manutenção de Veículos
- Sistema de Avaliações
- Integração com Google Maps
- Push Notifications

---

## Notas de Versão

### v1.0.0 - Release Inicial

Esta é a primeira versão estável do AutoManager. Todas as funcionalidades principais foram implementadas e testadas:

✅ **Completo e Funcional**
- ✓ Todos os CRUDs implementados
- ✓ Validações de negócio
- ✓ Relacionamentos JPA
- ✓ HATEOAS implementado
- ✓ Tratamento de erros robusto
- ✓ Dados de seed automáticos
- ✓ Múltiplos bancos de dados suportados

⚠️ **Próximas Melhorias**
- Autenticação e Autorização
- Documentação Swagger
- Testes JUnit completos
- Performance otimizada

---

## Como Reportar Bugs

Se encontrou um bug, abra uma [issue](https://github.com/seu-usuario/automanager/issues) com:

1. **Título descritivo**
2. **Descrição do problema**
3. **Passos para reproduzir**
4. **Resultado esperado vs obtido**
5. **Stack trace (se aplicável)**
6. **Ambiente**: SO, versão Java, etc.

---

## Sugestões de Features

Tem uma ideia? Abra uma [discussão](https://github.com/seu-usuario/automanager/discussions) ou uma [issue](https://github.com/seu-usuario/automanager/issues) com a tag `enhancement`.

---

**Última atualização:** 2024-01-15
