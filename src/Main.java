import models.Pokedex;
import services.PokedexService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PokedexService pokedexService = new PokedexService();

        pokedexService.crearPokedex("Charmander", "Fuego", 5);
        pokedexService.crearPokedex("Ghastly", "Fantasma, Veneno", 0.5);
        pokedexService.crearPokedex("Ludicolo", "Agua, Planta", 50);
        pokedexService.crearPokedex("Seedott", "Planta", 10);
        pokedexService.crearPokedex("Kartana", "Planta, Acero", 15);
        pokedexService.crearPokedex("Raging Bolt", "Dragon, Electrico", 20);
        pokedexService.crearPokedex("Zekrom", "Dragon, Electrico", 30);
        pokedexService.crearPokedex("Squirtle", "Agua", 6);
        pokedexService.crearPokedex("Pikachu", "Electrico", 12);
        pokedexService.crearPokedex("Darkrai", "Siniestro", 17);

        System.out.println("Listado de todas as entradas de pokedex: ");
        List<Pokedex> listaPokedex = pokedexService.listarPokedex();
        for (Pokedex p : listaPokedex){
            System.out.println(p);
        }

        Pokedex pActualizar1 = listaPokedex.get(1);
        Pokedex pActualizar2 = listaPokedex.get(2);
        pActualizar2.setNome("Charizard");
        pActualizar1.setNome("Lucario");
        pokedexService.actualizarPokedex(pActualizar1);
        pokedexService.actualizarPokedex(pActualizar2);

        for (Pokedex p : listaPokedex){
            System.out.println(p);
        }

        pokedexService.eliminarAllPokedex();
    }

    }
