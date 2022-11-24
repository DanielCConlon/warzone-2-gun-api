package com.warzone2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "weaponClass")
public class WeaponClass implements Serializable {
    private Integer id;
    private String weapon;

}
