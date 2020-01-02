package pl.mm.sbmt.ratingdataservice.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mm.sbmt.ratingdataservice.model.Rating;
import pl.mm.sbmt.ratingdataservice.model.UserRating;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ratingsData")
@RestController
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratingList = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        return new UserRating().setUserRatingList(ratingList);
    }

}
