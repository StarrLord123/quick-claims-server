package com.allstate.quickclaimsserver.domain;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String policyNumber;
    private LocalDate date;
    private String insuranceType;
    private String title;
    private String forename;
    private String surname;
    private Double amount;
    private String reason;
    private String updates;
    private String status;
    private String propertyAddress;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleYear;
    private String animalType;
    private String animalBreed;

    public Claim(Integer id, String policyNumber, LocalDate date, String insuranceType, String title, String forename, String surname, Double amount, String reason, String updates, String status, String propertyAddress, String vehicleMake, String vehicleModel, String vehicleYear, String animalType, String animalBreed) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.date = date;
        this.insuranceType = insuranceType;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.amount = amount;
        this.reason = reason;
        this.updates = updates;
        this.status = status;
        this.propertyAddress = propertyAddress;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.animalType = animalType;
        this.animalBreed = animalBreed;
    }

    public Claim() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUpdates() {
        return updates;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", policyNumber=" + policyNumber +
                ", date=" + date +
                ", insuranceType='" + insuranceType + '\'' +
                ", title='" + title + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", updates='" + updates + '\'' +
                ", status='" + status + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleYear='" + vehicleYear + '\'' +
                ", animalType='" + animalType + '\'' +
                ", animalBreed='" + animalBreed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return Objects.equals(id, claim.id) && Objects.equals(policyNumber, claim.policyNumber) && Objects.equals(date, claim.date) && Objects.equals(insuranceType, claim.insuranceType) && Objects.equals(title, claim.title) && Objects.equals(forename, claim.forename) && Objects.equals(surname, claim.surname) && Objects.equals(amount, claim.amount) && Objects.equals(reason, claim.reason) && Objects.equals(updates, claim.updates)
                && Objects.equals(status, claim.status) && Objects.equals(propertyAddress, claim.propertyAddress) && Objects.equals(vehicleMake, claim.vehicleMake) && Objects.equals(vehicleModel, claim.vehicleModel) && Objects.equals(vehicleYear, claim.vehicleYear) && Objects.equals(animalType, claim.animalType) && Objects.equals(animalBreed, claim.animalBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, policyNumber, date, insuranceType, title, forename, surname, amount, reason, updates, status, propertyAddress, vehicleMake, vehicleModel, vehicleYear, animalType, animalBreed);
    }
}
