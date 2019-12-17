package pl.flaaaxxx.springksb2catfact.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.flaaaxxx.springksb2catfact.client.AnimalFacts;

@Controller
public class CatController {

    public CatController() {
        RestTemplate restTemplate = new RestTemplate();
        AnimalFacts[] forObject = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random?animal_type=dog&amount=5",
                AnimalFacts[].class);
        for (AnimalFacts animalFacts: forObject) {
            System.out.println(animalFacts);
        }

    }
}
