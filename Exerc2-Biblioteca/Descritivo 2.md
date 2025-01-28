# Situação-Problema: Sistema de Gestão de Estoque para uma Papelaria

## Contexto
Uma biblioteca chamada **Livros para Todos** está tendo muita dificuldade para controlar o aluguel de seus livros, já que atualmente o controle é feito em papel e caneta, as vezes em planilha excel. Para melhorar esse gerênciamento a gerência pensou em contratar programadores para criar um sistema.
Os programadores sugeriram um programa contendo três classes, Livro, Cliente e Empréstimo realizados, caso necessário poderá ser criado novas classes.

## Objetivo
Criar um sistema de gerenciamento básico composto por três classes principais:

1. **Livro**: Representa os livros existentes na biblioteca.
2. **Cliente**: Armazena os dados dos clientes pegam livros emprestados.
3. **Emprestimo**: Representa os emprestimos realizados pelos clientes, relacionando cliente e livros, com sua respesctiva quantidade e data de devolução.

A interação entre essas classes deve permitir a simulação de um emprestimo feito por um cliente e a atualização do estoque dos livros.

---

## Dados fornecidos para construção das classes

### Classe Livro
- **Responsável:** Aluno 1
- **Atributos**: 
  - `id` (identificador do livro)
  - `nome` (nome do livro)
  - `preco` (preço unitário)
  - `quantidade_estoque` (quantidade disponível no estoque)
- **Métodos**:
  - `reduzir_estoque(quantidade)`: Reduz a quantidade do estoque ao realizar um emprestimo.
  - `exibir_detalhes()`: Mostra as informações do livro.

### Classe Cliente
- **Responsável:** Aluno 2
- **Atributos**: 
  - `id` (identificador do cliente)
  - `nome` (nome do cliente)
  - `email` (e-mail para contato)
- **Métodos**:
  - `exibir_cliente()`: Mostra os dados do cliente.

### Classe Emprestimo
- **Responsável:** Aluno 3
- **Atributos**:
  - `id` (identificador do emprestimo)
  - `data_devolucao` (data que o cliente tera que devolver o livro)
  - `cliente` (objeto da classe Cliente)
  - `livros` (lista de tuplas com livro e quantidade)
- **Métodos**:
  - `adicionar_livro(livro, quantidade)`: Adiciona um livro ao Emprestimo.
  - `calcular_total()`: Retorna o valor total do Emprestimo.
  - `finalizar_emprestimo(data_devolucao)`: Calcula o valor total do emprestimo do Emprestimo e retorna um resumo.

---

## Resultados Esperados
1. **Criar as classes com base no modelo acima.**
2. **Simular a criação de 3 livros, 2 clientes e 1 emprestimo.**
   - **Exemplo de livros**:  
     - Livro 1: Harry Potter, preço R$ 5.00, estoque 10 unidades.
     - Livro 2: O Senhor dos Anéis, preço R$ 5.50, estoque 15 unidades.
     - Livro 3: O Código da Vinci, preço R$ 4.50, estoque 20 unidades.
   - **Exemplo de clientes**:
     - Cliente 1: José Lopes, email `jose@email.com`.
     - Cliente 2: Ana Lua, email `ana@email.com`.
3. **Simular o emprestimo**:
   - Cliente José Lopes pegou emprestado:
     - 2 Harry Potter.
     - 1 O Senhor dos Anéis.
   - O sistema deve calcular o total do emprestimo, exibir um resumo para o cliente e atualizar o estoque dos livros.

