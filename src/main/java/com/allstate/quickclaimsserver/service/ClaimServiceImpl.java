package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        System.out.println("There were " + claims.size() + " found");
        return claims;
    }

    @Override
    public Claim getById(Integer id) throws ClaimNotFoundException {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            return optionalClaim.get();
        }
        else {
            throw new ClaimNotFoundException("There is no payment with id " + id);
        }
    }

    @Override
    public List<Claim> getByInsuranceType(String insuranceType) {
        return claimRepository.findAllByInsuranceType(insuranceType);
    }

    @Override
    public List<Claim> getByPolicyNumber(String policyNumber) {
        return claimRepository.findAllByPolicyNumber(policyNumber);
    }

    @Override
    public List<Claim> getByStatus(String status) {
        return claimRepository.findAllByStatus(status);
    }

    @Override
    public List<String> getAllStatuses() {
        return claimRepository.findAll().stream()
                .map(claim -> claim.getStatus().toLowerCase())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public Claim updateClaim(Integer id, Map<String, Object> fields) {
        Claim claim = claimRepository.findById(id).get();

        //update those fields that have changed

        if (fields.containsKey("policyNumber")) {
            claim.setPolicyNumber(fields.get("policyNumber").toString());
        }

        if (fields.containsKey("date")) {
            claim.setDate(LocalDate.parse(fields.get("date").toString()));
        }

        if (fields.containsKey("forename")) {
            claim.setForename(fields.get("forename").toString());
        }

        if (fields.containsKey("surname")) {
            claim.setSurname(fields.get("surname").toString());
        }

        if (fields.containsKey("insuranceType")) {
            claim.setInsuranceType(fields.get("insuranceType").toString());
        }

        if (fields.containsKey("propertyAddress")) {
            claim.setPropertyAddress(fields.get("propertyAddress").toString());
        }

        if (fields.containsKey("vehicleMake")) {
            claim.setVehicleMake(fields.get("vehicleMake").toString());
        }

        if (fields.containsKey("vehicleModel")) {
            claim.setVehicleModel(fields.get("vehicleModel").toString());
        }

        if (fields.containsKey("vehicleYear")) {
            claim.setVehicleYear(fields.get("vehicleYear").toString());
        }

        if (fields.containsKey("insuranceType")) {
            claim.setInsuranceType(fields.get("insuranceType").toString());
        }

        if (fields.containsKey("animalType")) {
            claim.setAnimalType(fields.get("animalType").toString());
        }

        if (fields.containsKey("animalBreed")) {
            claim.setAnimalBreed(fields.get("animalBreed").toString());
        }

        if (fields.containsKey("amount")) {
            claim.setAmount(Double.parseDouble(fields.get("amount").toString()));
        }

        if (fields.containsKey("reason")) {
            claim.setReason(fields.get("reason").toString());
        }

        if (fields.containsKey("updates")) {
            claim.setUpdates(fields.get("updates").toString());
        }

        if (fields.containsKey("status")) {
            claim.setStatus(fields.get("status").toString());
        }

        System.out.println(id);
        System.out.println(fields);
        System.out.println(claim);

        //save and return the claim
        return claimRepository.save(claim);
    }

}
