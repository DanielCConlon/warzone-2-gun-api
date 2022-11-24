package com.warzone2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "weaponClass")
public class WeaponClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Transient
    private  String username;

    private String weapon;
    private String muzzle;
    private String barrel;
    private String laser;
    private String optic;
    private String stock;
    private String grip;
    private String magazine;
    private String ammunition;
    private String underbarrel;

    private Integer userId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    @Transient
    private int voteCount;

//    Generate constructor, getters, setters, equals(), hasCode(), toString() methods

    public WeaponClass(Integer id, String username, String weapon, String muzzle, String barrel, String laser, String optic, String stock, String grip, String magazine, String ammunition, String underbarrel, Integer userId, Date postedAt, Date updatedAt, int voteCount) {
        this.id = id;
        this.username = username;
        this.weapon = weapon;
        this.muzzle = muzzle;
        this.barrel = barrel;
        this.laser = laser;
        this.optic = optic;
        this.stock = stock;
        this.grip = grip;
        this.magazine = magazine;
        this.ammunition = ammunition;
        this.underbarrel = underbarrel;
        this.userId = userId;
        this.postedAt = postedAt;
        this.updatedAt = updatedAt;
        this.voteCount = voteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getMuzzle() {
        return muzzle;
    }

    public void setMuzzle(String muzzle) {
        this.muzzle = muzzle;
    }

    public String getBarrel() {
        return barrel;
    }

    public void setBarrel(String barrel) {
        this.barrel = barrel;
    }

    public String getLaser() {
        return laser;
    }

    public void setLaser(String laser) {
        this.laser = laser;
    }

    public String getOptic() {
        return optic;
    }

    public void setOptic(String optic) {
        this.optic = optic;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getGrip() {
        return grip;
    }

    public void setGrip(String grip) {
        this.grip = grip;
    }

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }

    public String getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(String ammunition) {
        this.ammunition = ammunition;
    }

    public String getUnderbarrel() {
        return underbarrel;
    }

    public void setUnderbarrel(String underbarrel) {
        this.underbarrel = underbarrel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponClass that = (WeaponClass) o;
        return voteCount == that.voteCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(weapon, that.weapon) &&
                Objects.equals(muzzle, that.muzzle) &&
                Objects.equals(barrel, that.barrel) &&
                Objects.equals(laser, that.laser) &&
                Objects.equals(optic, that.optic) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(grip, that.grip) &&
                Objects.equals(magazine, that.magazine) &&
                Objects.equals(ammunition, that.ammunition) &&
                Objects.equals(underbarrel, that.underbarrel) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(postedAt, that.postedAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, weapon, muzzle, barrel, laser, optic, stock, grip, magazine, ammunition, underbarrel, userId, postedAt, updatedAt, voteCount);
    }

    @Override
    public String toString() {
        return "WeaponClass{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", weapon='" + weapon + '\'' +
                ", muzzle='" + muzzle + '\'' +
                ", barrel='" + barrel + '\'' +
                ", laser='" + laser + '\'' +
                ", optic='" + optic + '\'' +
                ", stock='" + stock + '\'' +
                ", grip='" + grip + '\'' +
                ", magazine='" + magazine + '\'' +
                ", ammunition='" + ammunition + '\'' +
                ", underbarrel='" + underbarrel + '\'' +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", voteCount=" + voteCount +
                '}';
    }
}
