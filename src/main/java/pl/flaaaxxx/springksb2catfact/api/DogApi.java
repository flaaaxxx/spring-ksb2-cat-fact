package pl.flaaaxxx.springksb2catfact.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogApi {

    private List<Dog> dogList;

    public DogApi() {
        this.dogList = new ArrayList<>();
        dogList.add(new Dog("Leos","Chihuahua"));
        dogList.add(new Dog("Kropka","Beagle"));
        dogList.add(new Dog("Mika","Owczarek"));
        dogList.forEach(System.out::println);
    }

//    need to send param amount as header - use Postman
    @GetMapping
    public List<Dog> get(@RequestHeader int amount){
        return dogList.subList(0, amount);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog) {
        dogList.add(dog);
    }




}
