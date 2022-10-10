package com.example.worktask.family.components;

import com.example.worktask.family.data.FamilyMember;
import com.example.worktask.family.repositories.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class managing FamilyMember objects
 */
@Component
public class FamilyMemberApp {

    FamilyMemberRepository familyMemberRepository;

    /**
     * Class constructor
     * @param familyMemberRepository JPA Data Repository used to store and manage FamilyMember objects
     */
    @Autowired
    public FamilyMemberApp(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    /**
     * Method used to adding FamilyMember object to database through JPA Data Repository
     * @param member FamilyMember object that is being added to database
     */
    void createFamilyMember(FamilyMember member){
        familyMemberRepository.save(member);
    }

}
