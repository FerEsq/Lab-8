package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    //Método para contar la cantidad de items (pokemon)
    override fun getItemCount(): Int {
        return pokemonList.size
    }

    //Método para reemplazar el contenido actual en la vista con nueva información
    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val pokemon = pokemonList[position] //Crear una instancia de un pokemon
        holder.binding.pokemonName.text = pokemon.name //Cargar nombre
        Picasso.get().load(pokemon.imageUrlFront).into(holder.binding.pokemonPhoto) //cargar fotos de Picasso

        // Al hacer click en el boton con el pokemon
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(pokemon)
        holder.binding.root.setOnClickListener{
            holder.itemView.findNavController().navigate(action)
        }

    }

}