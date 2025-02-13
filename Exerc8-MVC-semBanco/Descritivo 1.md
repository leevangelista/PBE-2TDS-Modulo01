# Utilizando a estrutura MVC - será desvolvido em aula juntamente com o professor para deixar como exemplo.
## Objetivo
- O objetivo é demonstar o padrão MVC na criação de uma API, porém ainda não utilizaremos o banco de dados.

## Classes
### Classe User
- **Atributos**: 
    - `id` (long)
    - `nome` (String)
    - `sobrenome` (String)

## Rotas
    - Buscar Todos (GET)
        - retorna um JSON com todos os dados
    - Buscar com base no ID (GET/{id})
        - retorna um JSON com os dados do funcionário/departamento encontrado
    - Adicionar (POST)
    - Atualizar (PUT)