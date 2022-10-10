package com.example.worktask.family.data.dto;

import java.util.List;

/**
 * Data transfer object
 */
public class FamilyWithMembersDTO {
    private FamilyDTO familyDTO;
    private List<FamilyMemberDTO> familyMemberDTOList;

    public FamilyWithMembersDTO() {
    }

    public FamilyWithMembersDTO(FamilyDTO familyDTO, List<FamilyMemberDTO> familyMemberDTOList) {
        this.familyDTO = familyDTO;
        this.familyMemberDTOList = familyMemberDTOList;
    }

    public FamilyDTO getFamilyDTO() {
        return familyDTO;
    }

    public List<FamilyMemberDTO> getFamilyMemberDTOList() {
        return familyMemberDTOList;
    }

    @Override
    public String toString() {
        return "FamilyWithMembers{" +
                "family=" + familyDTO +
                ", familyMembers=" + familyMemberDTOList +
                '}';
    }
}
