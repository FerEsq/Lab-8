package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R

class DetailFragment : Fragment() {
    private val argPokemon by navArgs<DetailFragmentArgs>()

    //Método para modificar el Recycler View
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var img: ImageView = view.findViewById(R.id.front)
        //Mostrar las 4 imagenes del pokemon
        Picasso.get().load(argPokemon.pokemonObj.imageUrlFront).into(img)
        img = view.findViewById(R.id.back)
        Picasso.get().load(argPokemon.pokemonObj.imageUrlBack).into(img)
        img = view.findViewById(R.id.frontShinny)
        Picasso.get().load(argPokemon.pokemonObj.imageUrlShinnyFront).into(img)
        img = view.findViewById(R.id.backShinny)
        Picasso.get().load(argPokemon.pokemonObj.imageUrlShinnyBack).into(img)
    }

    //Metodo para crear el Recycler View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}