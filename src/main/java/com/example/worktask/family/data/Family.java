package com.example.worktask.family.data;


import javax.persistence.*;
import java.util.Objects;

/**
 * Data class with automatically generated methods connected to database through JPA
 */
@Entity
@Table(name="family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String familyName;
    private Integer nrOfAdults;
    private Integer nrOfChildren;
    private Integer nrOfInfants;

    public Family() {
    }

    public Family(Long id, String familyName, Integer nrOfAdults, Integer nrOfChildren, Integer nrOfInfants) {
        this.id = id;
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }

    public Family(String familyName, Integer nrOfAdults, Integer nrOfChildren, Integer nrOfInfants) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(Integer nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public Integer getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(Integer nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public Integer getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(Integer nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(id, family.id) && Objects.equals(familyName, family.familyName) && Objects.equals(nrOfAdults, family.nrOfAdults) && Objects.equals(nrOfChildren, family.nrOfChildren) && Objects.equals(nrOfInfants, family.nrOfInfants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyName, nrOfAdults, nrOfChildren, nrOfInfants);
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", nrOfAdults=" + nrOfAdults +
                ", nrOfChildren=" + nrOfChildren +
                ", nrOfInfants=" + nrOfInfants +
                '}';
    }
}
