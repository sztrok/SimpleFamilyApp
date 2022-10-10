package com.example.worktask.family.data;

import java.util.List;

/**
 * Helper data class with automatically generated methods
 */
public class FamilyWithMembers {
    private final Family family;
    private final List<FamilyMember> familyMembers;

    public FamilyWithMembers(Family family, List<FamilyMember> familyMembers) {
        this.family = family;
        this.familyMembers = familyMembers;
    }

    public Family getFamily() {
        return family;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    @Override
    public String toString() {
        return "FamilyWithMembers{" +
                "family=" + family +
                ", familyMembers=" + familyMembers +
                '}';
    }

}
