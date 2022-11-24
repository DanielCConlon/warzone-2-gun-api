package com.warzone2.repository;

import com.warzone2.model.WeaponClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponClassRepository extends JpaRepository<WeaponClass, Integer> {
    WeaponClass findAllWeaponsByUserId(Integer id) throws Exception;
}
