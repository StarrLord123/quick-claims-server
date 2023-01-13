package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Service
public class BootstrapService {

    @Autowired
    private ClaimRepository claimRepository;

    @PostConstruct
    public void setUpInitialData() {
        int numberOfClaims = claimRepository.findAll().size();
        if (numberOfClaims == 0) {
            Claim newClaim = new Claim(1, 101, new Date(2023,01,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", "");
            Claim savedClaim = claimRepository.save(newClaim);
            System.out.println("Claim saved with id " + savedClaim.getId());
        }
    }

}