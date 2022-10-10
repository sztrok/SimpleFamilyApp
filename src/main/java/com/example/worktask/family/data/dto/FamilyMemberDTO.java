package com.example.worktask.family.data.dto;

/**
 * Data transfer object
 */
public class FamilyMemberDTO {
    private Long id;
    private String givenName;
    private Long familyId;
    private String familyName;
    private Integer age;

    public FamilyMemberDTO() {
    }

    public FamilyMemberDTO(Long id, String givenName, Long familyId, String familyName, Integer age) {
        this.id = id;
        this.givenName = givenName;
        this.familyId = familyId;
        this.familyName = familyName;
        this.age = age;
    }

    public FamilyMemberDTO(String givenName, String familyName, Integer age) {
        this.givenName = givenName;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
