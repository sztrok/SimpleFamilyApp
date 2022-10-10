package com.example.worktask.family.repositories;

import com.example.worktask.family.data.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JPA Data Repository for Family objects
 */
public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findAllByFamilyName(String familyName);
    List<Family> findAllByNrOfAdults(Integer nrOfAdults);
    Family findTopByFamilyName(String name);
    void deleteAllByFamilyName(String name);
    @Query(value = "SELECT coalesce(max(id),0) FROM Family ")
    Long getMaxId();
    @Query(value = "SELECT coalesce(max(id),0) FROM Family WHERE familyName='TESTP'")
    Long getMaxTestId();
}
