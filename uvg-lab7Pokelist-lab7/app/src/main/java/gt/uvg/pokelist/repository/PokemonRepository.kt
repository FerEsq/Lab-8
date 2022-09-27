package gt.uvg.pokelist.repository

import gt.uvg.pokelist.model.Pokemon

class PokemonRepository {

    // Obtain pokemon list from https://pokeapi.co/
    fun getPokemonList(): List<Pokemon> {
        return listOf(
            Pokemon(1, "Bulbasaur"),
            Pokemon(2, "Ivysaur"),
            Pokemon(3, "Venusaur"),
            Pokemon(4, "Charmander"),
            Pokemon(5, "Charmeleon"),
            Pokemon(6, "Charizard"),
            Pokemon(7, "Squirtle"),
            Pokemon(8 , "Wartortle"),
            Pokemon(9, "Blastoise"),
            Pokemon(10,"Caterpie")
        )
    }
}