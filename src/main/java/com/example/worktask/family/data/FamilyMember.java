package com.example.worktask.family.data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Data class with automatically generated methods connected to database through JPA
 */
@Entity
@Table(name="family_member")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String givenName;
    private Long familyId;
    private String familyName;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public FamilyMember(String givenName, String familyName, Integer age) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

    public FamilyMember() {
    }

    public FamilyMember(Long id, String givenName, Long familyId, String familyName) {
        this.id = id;
        this.givenName = givenName;
        this.familyId = familyId;
        this.familyName = familyName;
    }

    public FamilyMember(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public FamilyMember(String givenName, Long familyId, String familyName) {
        this.givenName = givenName;
        this.familyId = familyId;
        this.familyName = familyName;
    }

    public FamilyMember(String givenName, Long familyId, String familyName, Integer age) {
        this.givenName = givenName;
        this.familyId = familyId;
        this.familyName = familyName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(id, that.id) && Objects.equals(givenName, that.givenName) && Objects.equals(familyId, that.familyId) && Objects.equals(familyName, that.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, familyId, familyName);
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", givenName='" + givenName + '\'' +
                ", familyId=" + familyId +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
