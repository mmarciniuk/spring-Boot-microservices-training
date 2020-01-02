package pl.mm.sbmt.moviecatalogservice.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pl.mm.sbmt.moviecatalogservice.model.CatalogItem;
import pl.mm.sbmt.moviecatalogservice.model.Movie;
import pl.mm.sbmt.moviecatalogservice.model.Rating;
import pl.mm.sbmt.moviecatalogservice.model.UserRating;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/catalog")
@RestController
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsData/users/mariusz", UserRating.class);

        return userRating.getUserRatingList().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
            /*Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/


            return new CatalogItem(movie.getName(), "Description", rating.getRating());
        }).collect(Collectors.toList());
    }

}
