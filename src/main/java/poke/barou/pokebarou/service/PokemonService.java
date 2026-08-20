package poke.barou.pokebarou.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import poke.barou.pokebarou.entity.PokemonEntity;
import poke.barou.pokebarou.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final RestTemplate restTemplate;


    public PokemonService(PokemonRepository pokemonRepository, RestTemplate restTemplate) {
        this.pokemonRepository = pokemonRepository;
        this.restTemplate = restTemplate;
    }


    public void fetchAllAndSave() {
        //
        String listUrl = "https://pokeapi.co/api/v2/pokemon?limit=10000";
        JsonNode root = restTemplate.getForObject(listUrl, JsonNode.class);

        if (root != null && root.has("results")) {
            JsonNode results = root.get("results");
            System.out.println("Total de Pokémons encontrados na API: " + results.size());

            for (JsonNode pokemonNode : results) {
                String url = pokemonNode.get("url").asText();
                int id = extractIdFromUrl(url);

                if (!pokemonRepository.existsById(id)) {
                    try {
                        fetchAndSavePokemon(id);
                        System.out.println("Pokémon salvo com sucesso: ID " + id + " - " + pokemonNode.get("name").asText());

                        Thread.sleep(200);

                    } catch (Exception e) {
                        System.err.println("Erro ao salvar Pokémon ID " + id + ": " + e.getMessage());
                    }
                } else {
                    System.out.println("Pokémon ID " + id + " já existe no banco. Pulando...");
                }
            }
            System.out.println("Sincronização de todos os Pokémons finalizada!");
        }
    }

    public PokemonEntity fetchAndSavePokemon(int pokemonId) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonId;

        JsonNode root = restTemplate.getForObject(url, JsonNode.class);

        if (root == null) {
            throw new RuntimeException("Pokémon não encontrado na API");
        }

        PokemonEntity entity = new PokemonEntity();

        entity.setId_pokemon(root.get("id").asInt());
        entity.setPokemon_name(root.get("name").asText());

        JsonNode types = root.get("types");
        if (types != null && types.size() > 0) {
            entity.setType1(types.get(0).get("type").get("name").asText());
        }
        if (types != null && types.size() > 1) {
            entity.setType2(types.get(1).get("type").get("name").asText());
        }

        JsonNode stats = root.get("stats");
        if (stats != null) {
            for (JsonNode statNode : stats) {
                String statName = statNode.get("stat").get("name").asText();
                int baseStat = statNode.get("base_stat").asInt();

                switch (statName) {
                    case "hp": entity.setHp(baseStat); break;
                    case "attack": entity.setAtk(baseStat); break;
                    case "defense": entity.setDef(baseStat); break;
                    case "special-attack": entity.setSpAtk(baseStat); break;
                    case "special-defense": entity.setSpDef(baseStat); break;
                    case "speed": entity.setSpeed(baseStat); break;
                }
            }
        }

        JsonNode heldItems = root.get("held_items");
        if (heldItems != null && heldItems.size() > 0) {
            String itemUrl = heldItems.get(0).get("item").get("url").asText();
            entity.setItem(extractIdFromUrl(itemUrl));
        }

        JsonNode moves = root.get("moves");
        if (moves != null) {
            if (moves.size() > 0) entity.setMove1(extractIdFromUrl(moves.get(0).get("move").get("url").asText()));
            if (moves.size() > 1) entity.setMove2(extractIdFromUrl(moves.get(1).get("move").get("url").asText()));
            if (moves.size() > 2) entity.setMove3(extractIdFromUrl(moves.get(2).get("move").get("url").asText()));
            if (moves.size() > 3) entity.setMove4(extractIdFromUrl(moves.get(3).get("move").get("url").asText()));
        }

        return pokemonRepository.save(entity);
    }


    private int extractIdFromUrl(String url) {
        if (url == null || url.isEmpty()) return 0;

        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }

        String[] parts = url.split("/");
        try {
            return Integer.parseInt(parts[parts.length - 1]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}