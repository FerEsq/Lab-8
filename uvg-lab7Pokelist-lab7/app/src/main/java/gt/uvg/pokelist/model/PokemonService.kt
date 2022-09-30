package gt.uvg.pokelist.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon?limit=100")
    fun getPokemon(): Call<GetPokemonResponse>
}