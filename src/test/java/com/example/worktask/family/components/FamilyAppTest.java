package com.example.worktask.family.components;

import com.example.worktask.family.data.Family;
import com.example.worktask.family.data.FamilyMember;
import com.example.worktask.family.data.FamilyWithMembers;
import com.example.worktask.family.data.dto.FamilyDTO;
import com.example.worktask.family.data.dto.FamilyMemberDTO;
import com.example.worktask.family.data.dto.FamilyWithMembersDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FamilyAppTest {

    @Autowired
    FamilyApp familyApp;

    @Test
    void validateFamilyData() {

        FamilyDTO family = new FamilyDTO("VAL TEST",1,1,1);
        List<FamilyMemberDTO> members = new ArrayList<>();
        members.add(new FamilyMemberDTO("T1","TEST",20));
        members.add(new FamilyMemberDTO("T2","TEST",12));
        FamilyWithMembersDTO familyWithMembers = new FamilyWithMembersDTO(family,members);
        assertEquals(new ResponseEntity<>("Wrong family members data", HttpStatus.BAD_REQUEST),
                familyApp.validateFamilyData(familyWithMembers));

        members.remove(0);
        members.add(new FamilyMemberDTO("T3","TEST",2));
        familyWithMembers = new FamilyWithMembersDTO(family,members);
        assertEquals(new ResponseEntity<>("Wrong family members data", HttpStatus.BAD_REQUEST),
                familyApp.validateFamilyData(familyWithMembers));

        members.add(new FamilyMemberDTO("T1","TEST",20));
        familyWithMembers = new FamilyWithMembersDTO(family,members);
        String response = "Successfully created new family, id: "+(familyApp.familyRepository.getMaxId()+1);
        assertEquals(new ResponseEntity<>(response, HttpStatus.ACCEPTED),
                familyApp.validateFamilyData(familyWithMembers));
        List<Family> familyList = familyApp.familyRepository.findAllByFamilyName("VAL TEST");
        assertEquals(familyApp.familyRepository.findById(familyApp.familyRepository.getMaxId()).orElse(null),
                familyList.get(familyList.size()-1));
    }

    @Test
    void getFamily() {
        FamilyDTO family = new FamilyDTO("GET TEST",1,1,0);
        List<FamilyMemberDTO> members = new ArrayList<>();
        members.add(new FamilyMemberDTO("T1","TEST",20));
        members.add(new FamilyMemberDTO("T2","TEST",12));
        FamilyWithMembersDTO familyWithMembers = new FamilyWithMembersDTO(family,members);
        familyApp.validateFamilyData(familyWithMembers);
        List<Family> familyList = familyApp.familyRepository.findAllByFamilyName("GET TEST");
        FamilyWithMembersDTO result = familyApp.getFamily(familyList.get(familyList.size()-1).getId());
        assertEquals(familyWithMembers.getFamilyMemberDTOList().size(),
                result.getFamilyMemberDTOList().size());
        assertEquals(familyWithMembers.getFamilyDTO().getFamilyName(),
                result.getFamilyDTO().getFamilyName());
    }

}