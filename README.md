# poke-berou

This is the backend service for a Java-based project integrated with PokéAPI. It manages the server-side logic and data processing for a simple Pokémon combat system. 

Movecontroller.java:

Methods

saveMove(MoveEntity move) (POST /move): Receives a new move object in the request body and saves it to the database, returning the saved entity.

listMove() (GET /move): Queries the database for all existing move records and returns them as a list.

updateMove(Integer id, MoveEntity alterMove) (PUT /move/{id}): Searches for an existing move by id, updates its move_name attribute with the new value, saves the changes, and returns the updated entity.

deleteMove(Integer id) (DELETE /move/{id}): Removes the move matching the provided id from the database.


PokemonController.java:

savePokemon(PokemonEntity Pokemon) (POST /pokemon): Receives a new Pokémon object in the request body and saves it to the database, returning the saved entity.

listPokemon() (GET /pokemon): Queries the database for all existing Pokémon records and returns them as a list.

updatePokemon(Integer id, PokemonEntity alterPokemon) (PUT /pokemon/{id}): Searches for an existing Pokémon by id, updates its pokemon_name attribute with the new value, saves the changes, and returns the updated entity.

deletePokemon(Integer id) (DELETE /pokemon/{id}): Removes the Pokémon matching the provided id from the database.

syncAllPokemons() (POST /pokemon/sync-all): Triggers an asynchronous background thread to fetch and save all Pokémon data from PokéAPI, returning an immediate confirmation message to prevent request timeouts.


TeamController.java:

saveTeam(TeamEntity Team) (POST /team): Receives a new team object in the request body and saves it to the database, returning the saved entity.

listTeam() (GET /team): Queries the database for all existing team records and returns them as a list.

updateTeam(Integer id, TeamEntity alterTeam) (PUT /team/{id}): Searches for an existing team by id, updates its team_name attribute with the new value, saves the changes, and returns the updated entity.

deleteTeam(Integer id) (DELETE /team/{id}): Removes the team matching the provided id from the database.

UserController.java:

saveUser(UserEntity User) (POST /user): Receives a new user object in the request body and saves it to the database, returning the saved entity.

listUser() (GET /user): Queries the database for all existing user records and returns them as a list.

updateUser(Integer id, UserEntity alterUser) (PUT /user/{id}): Searches for an existing user by id, updates its user_name attribute with the new value, saves the changes, and returns the updated entity.

deleteUser(Integer id) (DELETE /user/{id}): Removes the user matching the provided id from the database.

