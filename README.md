# **ConsultaService**

## **Descrição Geral**
O **ConsultaService** é um microserviço responsável pelo agendamento de consultas odontológicas. Ele verifica a disponibilidade do consultório, se o beneficiário possui acesso ao benefício e se o consultório cobre o benefício solicitado.

---

## **Objetivo**
- Gerenciar o agendamento de consultas para beneficiários.
- Garantir que o agendamento respeite as regras do sistema, como:
  - Disponibilidade dentro do horário de funcionamento do consultório.
  - Agendamento prévio.
  - Verificação de acesso do beneficiário ao benefício.
  - Verificação de cobertura do benefício pelo consultório.

---

## **Principais Recursos**
1. **Agendamento de Consultas**:
   - Agendar consultas para beneficiários.
   - Verificar se o horário está disponível no consultório.
   - Garantir que o benefício solicitado seja coberto pelo consultório.

2. **Validação de Acesso**:
   - Confirmar se o beneficiário possui assinatura ativa com acesso ao benefício.

3. **Verificação de Cobertura**:
   - Garantir que o consultório ofereça o benefício solicitado.

---

## **Tecnologias Utilizadas**

### **Linguagem e Frameworks**
- **Java 17**: Linguagem principal para desenvolvimento do serviço.
- **Spring Security**: Para autenticação e autorização.
- **Spring Web**: Para construção de APIs REST.

### **Banco de Dados**
- **MySQL**: Banco de dados relacional utilizado para persistência das informações de consultas, horários e coberturas.

### **Infraestrutura e Comunicação**
- **Eureka**: Para descoberta e registro de serviços.
- **Spring Cloud Gateway**: Para roteamento de requisições entre os microserviços.
- **RabbitMQ**: Para comunicação assíncrona entre microserviços.

---
