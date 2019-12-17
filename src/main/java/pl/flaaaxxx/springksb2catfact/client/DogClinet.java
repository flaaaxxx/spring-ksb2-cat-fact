package pl.flaaaxxx.springksb2catfact.client;

import org.apache.tomcat.util.net.NioBlockingSelector;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import pl.flaaaxxx.springksb2catfact.api.Dog;
import sun.net.www.http.HttpClient;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class DogClinet {

    RestTemplate restTemplate;

    public DogClinet(){
        this.restTemplate = new RestTemplate();
    }

//    uruchomienie metody po zbudowaniu całej aplikacji
//@EventListener(ApplicationReadyEvent.class)
    private void getDogs() {
        //    headers have been defined to be forwarded to HttpEntity
        MultiValueMap<String, String > headers = new HttpHeaders();
        headers.add("amount", "4");
        HttpEntity httpEntity = new HttpEntity(headers);
        //    HttpEntity - element which is send to API

//        ResponseEntity typ opakowujący, dzięki któremu możemy przeczytac różne Sinformacje
        ResponseEntity<Dog[]> exchange= restTemplate.exchange("http://localhost:8080/dogs",
                HttpMethod.GET,
                httpEntity,
                Dog[].class);

        //        wyswietlenie listy wszystkich psów
        Stream.of(exchange.getBody()).forEach(System.out::println);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void dogs(){

        Dog dog = new Dog("Pikuś", "Kundel");
        HttpEntity httpEntity = new HttpEntity(dog);

        restTemplate.exchange("http://localhost:8080/dogs",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }


}
