package pl.mm.sbmt.moviecatalogservice.model;

public class CatalogItem {

    private String name;
    private String description;
    private int rating;

    public CatalogItem(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public CatalogItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CatalogItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public CatalogItem setRating(int rating) {
        this.rating = rating;
        return this;
    }
}
