# Situação-Problema: Jogo de RPG

## Contexto
Você é o desenvolvedor principal de um jogo de RPG simples que será utilizado em uma atividade educacional.
A primeira tarefa é implementar o sistema de combate básico entre personagens e inimigos. Para isso, você precisa criar as classes que representam o Personagem, o Inimigo e os Ataques. Cada classe deve ter atributos e comportamentos que reflitam um sistema de combate de RPG, como ataque físico, ataque mágico e cálculo de dano baseado no nível do personagem ou na experiência adquirida.

## Objetivo
Criar as classes de um jogo de RPG simples.

1. **Personagem**: Representa os personagens do jogo.
2. **Inimigo**: Representa os inimigos do jogo.
3. **Ataque**: Representa os ataques que existem no jogo.

A interação entre essas classes deve permitir a simulação de um combate entre o personagem e inimigo.

---

## Dados fornecidos para construção das classes

### Classe Personagem
- **Atributos**: 
  - `id` (identificador do personagem)
  - `nome` (nome do personagem)
  - `hp` (vida total do personagem)
  - `forca` (quantidade do atributo força do personagem)
  - `inteligencia` (quantidade do atributo inteligência do persogem)
- **Métodos**:
  - `atacar(inimigo, ataque)`: Reduz a quantidade de vida do inimigo com base no dano do ataque(funcão calcularDanoPersonagem).
  - `receber_dano()`: Reduz a vida do personagem.

### Classe Inimigo
- **Atributos**: 
  - `id` (identificador do inimigo)
  - `nome` (nome do inimigo)
  - `hp` (vida total do inimigo)
  - `dano` (dano que o inimigo causa)
- **Métodos**:
  - `atacar(personagem, ataque)`: Reduz a quantidade de vida do personagem com base no dano do ataque(funcão calcularDanoInimigo).
  - `receber_dano()`: Reduz a vida do inimigo.

### Classe Ataque
- **Atributos**:
  - `id` (identificador do Ataque)
  - `tipo` (fisico ou magico)
  - `dano` (dano que o ataque causa)
- **Métodos**:
  - `calcularDanoPersonagem(personagem)`: Faz o calculo ao realizar o ataque, o calculo tem como base:
        - se for ataque físico é o dano multiplacado pela quantidade de força do personagem.
        - se for ataque mágico é o dano multiplacado pela quantidade de inteligência do personagem.
  - `calcularDanoInimigo(inimigo)`: Faz o calculo do dano do inimigo, o calculo é o somatorio do dano do inimigo com o dano do ataque.

---

## Resultados Esperados
1. **Criar as classes com base no modelo acima.**
2. **Simular do jogo** 
   - **Exemplo de personasgem**:  
     - Produto 1: Harry, vida de 1000, força de 10, inteligência 200.
     - Produto 2: Hobbit, vida de 500, força de 200, inteligência 10.
   - **Exemplo de inimigo**:
     - Inimigo 1: O Dragão, vida de 3000, dano de 300.
     - Inimigo 2: O Gigante, vida de 5000, dano de 200.
  - **Exemplo de ataques**
     - Ataque 1: ataque físico, 20 de dano.
     - Ataque 2: ataque mágico, 50 de dano.
3. **Simular o batalha**:
    - Harry ataca o Gigante, com ataque mágico.
    - Hobbit ataca o Dragão, com ataque físico.
    - Dragão ataca o Hobbit, com ataque físico.

