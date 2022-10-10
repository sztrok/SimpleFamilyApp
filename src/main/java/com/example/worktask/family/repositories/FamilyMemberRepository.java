package com.example.worktask.family.repositories;

import com.example.worktask.family.data.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA Data Repository for FamilyMember objects
 */
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    List<FamilyMember> findAllByFamilyId(Long id);
}
