# 🏦 Alpha Bank - Sistema Bancário Java
Neste projeto, foi explorado os conceitos de **Modelagem de Classes com UML** e **Programação Orientada a Objetos (POO)** em Java, criando um **sistema bancário completo** com herança, polimorfismo e encapsulamento.

## 📌 Descrição do Projeto
O **Alpha Bank** é um sistema bancário completo que simula as operações de um banco real. O projeto implementa:
- **Conta Corrente**: Com cheque especial e operações básicas (saque, depósito, transferência)  
- **Conta Poupança**: Com cálculo automático de rendimentos mensais  
- **Gerenciador de Clientes**: Cadastro com validação de CPF brasileira  
- **Sistema de Transferências**: Entre contas diferentes com validação de saldo  
- **Menu Interativo**: Interface completa para todas as operações bancárias

## ✨ Funcionalidades Implementadas
- ✅ **Criação de Contas**: Corrente (limite R$500) e Poupança (juros 0,67%)
- ✅ **Operações Bancárias**: Depósito, Saque, Transferência  
- ✅ **Rendimentos Automáticos**: Cálculo polimórfico por tipo de conta
- ✅ **Validação CPF**: Formato brasileiro com 11 dígitos
- ✅ **Formatação Monetária**: R$ 1.234,56
- ✅ **Listagem Completa**: Extrato de todas as contas
- ✅ **Tratamento de Erros**: Contas inexistentes, saldo insuficiente
- 🆕 Sistema de login e autenticação
- 🆕 Controle de acesso por usuário

## 🆕 Novas implementações:
- 🔐 Sistema de Login com CPF + senha
- 👥 Cadastro com usuário único (validação completa)
- 📱 Dois menus separados: Inicial e Principal
- 🔒 Controle de acesso: usuário visualiza apenas suas contas
- 🚪 Login e Logout no sistema
- 📋 Extrato automático no menu principal
- ✅ Validação completa: nome, data e CPF
- 🎨 Melhoria de UX no terminal: tabelas e separadores
-🔒 Encapsulamento mais rigoroso com uso de final

## 🛠️ Tecnologias e Conceitos Abordados
Durante o desenvolvimento, foi aplicado:
- **Collections**: `ArrayList<Conta>` para gerenciar todas as contas  
- **Herança**: `ContaCorrente` e `ContaPoupanca` extendem `Conta` abstrata  
- **Polimorfismo**: `calcularRendimento()` diferente por tipo de conta  
- **Encapsulamento**: Atributos `private` + getters/setters  
- **Abstração**: Classe `Conta` abstrata com métodos obrigatórios  
- **UML**: Modelagem de classes com relacionamentos hierárquicos  

## 🚀 Instruções de Uso
1. Clone o projeto:
https://github.com/vitorduartee7/alphabank-java.git
2. Compile:
javac -d bin -sourcepath src src/principal/Main.java
3. Execute:
java -cp bin principal.Main

## 👨‍💻 Contato
![Static Badge](https://img.shields.io/badge/linkedin-blue?style=for-the-badge&logo=LinkedIn)
