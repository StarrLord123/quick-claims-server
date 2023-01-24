package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public List<Claim> getByStatus(String status) {
        return claimRepository.findAllByStatus(status);
    }

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public Claim updateClaim(Integer id, Map<String, Object> fields) {
        Claim claim = claimRepository.findById(id).get();

        if (fields.containsKey("amount")) {
            //any logic eg is amount > 0?
            claim.setAmount(Double.parseDouble(fields.get("amount").toString()));
        }

        //save and return the payment
        return claimRepository.save(claim);
    }

}
