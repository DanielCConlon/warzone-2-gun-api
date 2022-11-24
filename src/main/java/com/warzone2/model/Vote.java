package com.warzone2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "vote")
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer weaponClassId;

    public Vote(Integer id, Integer userId, Integer weaponClassId) {
        this.id = id;
        this.userId = userId;
        this.weaponClassId = weaponClassId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeaponClassId() {
        return weaponClassId;
    }

    public void setWeaponClassId(Integer weaponClassId) {
        this.weaponClassId = weaponClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(id, vote.id) && Objects.equals(userId, vote.userId) && Objects.equals(weaponClassId, vote.weaponClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, weaponClassId);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", weaponClassId=" + weaponClassId +
                '}';
    }
}
