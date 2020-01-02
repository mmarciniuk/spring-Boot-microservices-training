package pl.mm.sbmt.ratingdataservice.model;

import java.util.List;

public class UserRating {

    private List<Rating> userRatingList;

    public UserRating() {
    }

    public List<Rating> getUserRatingList() {
        return userRatingList;
    }

    public UserRating setUserRatingList(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
        return this;
    }

}
