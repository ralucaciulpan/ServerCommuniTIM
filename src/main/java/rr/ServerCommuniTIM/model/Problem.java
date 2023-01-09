package rr.ServerCommuniTIM.model;

import javax.persistence.*;

@Entity
@Table(name="problems")
public class Problem {
    @Id
    @SequenceGenerator(name="problem_sequence", allocationSize = 1)
    @GeneratedValue(
            generator = "problem_sequence",
            strategy = GenerationType.SEQUENCE
    )

    private Long id;

    private String category;
    private String subcategory;
    private double longitude;
    private double latitude;
    public Problem(){

    }
    public Problem(String category, String subcategory, double longitude, double latitude) {
        this.category = category;
        this.subcategory = subcategory;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}