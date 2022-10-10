package com.example.worktask.family.components;
import com.example.worktask.family.data.Family;
import com.example.worktask.family.data.FamilyMember;
import com.example.worktask.family.data.FamilyWithMembers;
import com.example.worktask.family.data.dto.FamilyDTO;
import com.example.worktask.family.data.dto.FamilyMemberDTO;
import com.example.worktask.family.data.dto.FamilyWithMembersDTO;
import com.example.worktask.family.exceptions.FamilyNotFoundException;
import com.example.worktask.family.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class managing Family objects
 */
@Component
public class FamilyApp {

    FamilyRepository familyRepository;
    FamilyMemberApp familyMemberApp;

    /**
     * Class constructor
     * @param familyRepository JPA Data Repository used to store and manage Family objects
     * @param familyMemberApp Component managing FamilyMember objects
     */
    @Autowired
    public FamilyApp(FamilyRepository familyRepository, FamilyMemberApp familyMemberApp) {
        this.familyRepository = familyRepository;
        this.familyMemberApp = familyMemberApp;
    }

    /**
     * Method validating age of family members and adding new Family to database
     * @param familyWithMembers Family and family members data received through API
     * @return Response entity, when all conditions are matched returns id of new family with Http status ACCEPTED,
     * otherwise returns BAD_REQUEST status
     */
    public ResponseEntity<?> validateFamilyData(FamilyWithMembersDTO familyWithMembers){
        int nrOfAdults=0,nrOfChildren = 0,nrOfInfants = 0 ;
        for(FamilyMemberDTO member : familyWithMembers.getFamilyMemberDTOList()){
            int age = member.getAge();
            if(age <4){
                nrOfInfants++;
            }
            else if(age <16){
                nrOfChildren++;
            }
            else {
                nrOfAdults++;
            }

        }
        if(nrOfAdults!=familyWithMembers.getFamilyDTO().getNrOfAdults() || nrOfChildren!=familyWithMembers.getFamilyDTO().getNrOfChildren() || nrOfInfants!=familyWithMembers.getFamilyDTO().getNrOfInfants()){
            String response = "Wrong family members data";
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        else {
            Long newFamilyId = familyRepository.getMaxId()+1;
            for(FamilyMemberDTO member : familyWithMembers.getFamilyMemberDTOList()){
                familyMemberApp.createFamilyMember(new FamilyMember(member.getGivenName(),newFamilyId,familyWithMembers.getFamilyDTO().getFamilyName(), member.getAge()));
            }
            familyRepository.save(new Family(newFamilyId,familyWithMembers.getFamilyDTO().getFamilyName(),familyWithMembers.getFamilyDTO().getNrOfAdults(),familyWithMembers.getFamilyDTO().getNrOfChildren(),familyWithMembers.getFamilyDTO().getNrOfInfants()));
            String response = "Successfully created new family, id: "+newFamilyId;
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }

    }

    /**
     * Method used to find family with members from database
     * @param id ID of the family which we want to get information about from database
     * @return If family with this id is found, returns family data and a list of associated family members,
     * otherwise throws exception
     */
    public FamilyWithMembersDTO getFamily(Long id){
        Family family = familyRepository.findById(id)
                .orElseThrow(()-> new FamilyNotFoundException(id));
        List<FamilyMember> memberList = familyMemberApp.familyMemberRepository.findAllByFamilyId(id);

        FamilyDTO familyDTO = new FamilyDTO(family.getId(),family.getFamilyName(),family.getNrOfAdults(),family.getNrOfChildren(),family.getNrOfInfants());
        List<FamilyMemberDTO> memberDTOS = new ArrayList<>();
        for(FamilyMember member : memberList){
            memberDTOS.add(new FamilyMemberDTO(member.getFamilyId(), member.getGivenName(), member.getFamilyId(), member.getFamilyName(), member.getAge()));
        }

        return new FamilyWithMembersDTO(familyDTO,memberDTOS);

    }


}
