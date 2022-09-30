package gt.uvg.pokelist.model

data class GetPokemonResponse(
    val count: Int = 0,
    val results: List<Result> = listOf()
)