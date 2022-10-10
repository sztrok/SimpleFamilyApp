package com.example.worktask.family.initial_data;

import com.example.worktask.family.data.Family;
import com.example.worktask.family.data.FamilyMember;
import com.example.worktask.family.repositories.FamilyMemberRepository;
import com.example.worktask.family.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Class generating initial sample data
 */
@Component
public class DBInsert implements CommandLineRunner {
    @Autowired
    FamilyMemberRepository repository;
    @Autowired
    FamilyRepository familyRepository;

    @Override
    public void run(String... args) {

        repository.saveAll(List.of(
                new FamilyMember("Kamil", 1L, "Sakowicz"),
                new FamilyMember("aaa",1L,"sss"),
                new FamilyMember("gg","aa")
        ));
        familyRepository.saveAll(List.of(
                new Family("SSSS",0,0,0),
                new Family("AAAA",1,2,4)
        ));
        System.out.println("DATA SAVED");
    }
}
