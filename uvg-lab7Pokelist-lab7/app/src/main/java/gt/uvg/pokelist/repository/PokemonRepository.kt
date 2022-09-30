package gt.uvg.pokelist.repository

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.model.GetPokemonResponse
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PokemonRepository {
    private val b: Pokemon = Pokemon(1, "bulbasaur")
    private val pokemonList = mutableListOf<Pokemon>(b)

    // Obtain pokemon list from https://pokeapi.co/
    fun getPokemonList(): List<Pokemon> {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val pokemonService: PokemonService = retrofit.create(PokemonService::class.java)

        pokemonService.getPokemon().enqueue(object: Callback<GetPokemonResponse> {
            override fun onResponse(call: Call<GetPokemonResponse>, response: Response<GetPokemonResponse>){
                Log.i("MainActivity", response.toString())

                if (!response.isSuccessful){
                    return
                }

                pokemonList.remove(b)
                val body = response.body()!!
                val pokemons = body.results
                for((i, pokemon) in pokemons.withIndex()) {
                    pokemonList.add(Pokemon(i+1, pokemon.name))
                }
            }

            override fun onFailure(call: Call<GetPokemonResponse>, t: Throwable){
                Log.i("FAILURE", t.message ?: "Null message")
            }
        })

        return pokemonList
    }
}