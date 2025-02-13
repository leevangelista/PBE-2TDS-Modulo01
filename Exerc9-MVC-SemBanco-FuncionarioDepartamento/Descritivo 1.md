# Situação problema: Desenvolva Dois Endpoints - Utilizando a estrutura MVC
## Objetivo
- O exercício tem como objetivo demonstrar a criação de duas rotas no mesmo projeto englobando a estutura MVC, não existindo ainda a comunição via banco de dados ou relacionamento entre as classes. Os dados serão salvos em um ArrayList.

## Classes
### Classe Departamento
- **Atributos**: 
    - `id` (identificador do departamento)
    - `nome` (nome do departamento)

### Classe Funcionário
- **Atributos**
    - `id` (Long)
    - `nome` (String)
    - `sobrenome` (String)
    - `curso` (String)
    - `salario` (double)
    - `departamento` (objeto departamento)

## Rotas
- Precisa existir para cada classe as rotas:
    - Buscar Todos (GET)
        - retorna um JSON com todos os dados
    - Buscar com base no ID (GET/{id})
        - retorna um JSON com os dados do funcionário/departamento encontrado
    - Adicionar (POST)
    - Atualizar (PUT)

## Observação
    - Não vamos nos preocupar com o relacionamento entre as classes departamento e funcionário, devido a não estarmos utilizando um banco de dados, mas assim salvando em ArrayList