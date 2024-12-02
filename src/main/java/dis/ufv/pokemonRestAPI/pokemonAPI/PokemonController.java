package dis.ufv.pokemonRestAPI.pokemonAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class PokemonController {
    @GetMapping("/pokemons")
    public ArrayList<Pokemon> pokemons(){
        ArrayList<Pokemon> listaPokemons = new LectorJson().leeFicheroJson("./src/main/resources/pokemonConId.json");
        return listaPokemons;
    }

    @GetMapping("/pokemon/porNombre/{nombre}")
    public ResponseEntity<Pokemon> getPorNombre(@PathVariable String nombre){
        ArrayList<Pokemon> listaPokemons = new LectorJson().leeFicheroJson("./src/main/resources/pokemonConId.json");
        Pokemon encontrado = null;
        for (Pokemon pokemon : listaPokemons) {
            if (pokemon.getName().equalsIgnoreCase(nombre)) {
                encontrado = pokemon;
            }
        }
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
}