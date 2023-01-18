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
            Claim newClaim1 = new Claim(null, 101, Date.valueOf("2023-01-01"), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", "");
            Claim savedClaim1 = claimRepository.save(newClaim1);

            Claim newClaim2 = new Claim(null, 102, Date.valueOf("2023-01-01"), "Motor", "Mr", "Arnold", "Smithy", 100.00, "Car on fire", "Assessed", "Open", "", "Ford", "Fiesta", "2000", "", "");
            Claim savedClaim2 = claimRepository.save(newClaim2);

            Claim newClaim3 = new Claim(null, 103, Date.valueOf("2023-01-01"), "Pet", "Ms", "Barbara", "Johnson", 100.00, "Pet hurt leg", "Rejected", "Closed", "", "", "", "", "Dog", "Westie");
            Claim savedClaim3 = claimRepository.save(newClaim3);

            Claim newClaim4 = new Claim(null, 104, Date.valueOf("2023-01-01"), "Property", "Mr", "Donald", "Williams", 100.00, "House burnt down", "Accepted - Awaiting Payment", "Open", "2 Fake Street", "", "", "", "", "");
            Claim savedClaim4 = claimRepository.save(newClaim4);

            Claim newClaim5 = new Claim(null, 105, Date.valueOf("2023-01-01"), "Motor", "Ms", "Emma", "Brown", 100.00, "Car broke down", "Accepted - Paid", "Closed", "", "Volkswagen", "Polo", "2010", "", "");
            Claim savedClaim5 = claimRepository.save(newClaim5);

            Claim newClaim6 = new Claim(null, 106, Date.valueOf("2023-01-01"), "Pet", "Ms", "Francine", "Jones", 100.00, "Pet hurt leg", "Rejected", "Closed", "", "", "", "", "Cat", "Tabby");
            Claim savedClaim6 = claimRepository.save(newClaim6);

            Claim newClaim7 = new Claim(null, 107, Date.valueOf("2023-01-01"), "Property", "Mr", "Harold", "Garcia", 100.00, "House burnt down", "Rejected", "Closed", "3 Fake Street", "", "", "", "", "");
            Claim savedClaim7 = claimRepository.save(newClaim7);

            Claim newClaim8 = new Claim(null, 108, Date.valueOf("2023-01-01"), "Motor", "Ms", "Jane", "Miller", 100.00, "Car broke down", "Assessed", "Open", "", "Volkswagen", "Golf", "2020", "", "");
            Claim savedClaim8 = claimRepository.save(newClaim8);

            Claim newClaim9 = new Claim(null, 109, Date.valueOf("2023-01-01"), "Pet", "Mr", "Keith", "David", 100.00, "Pet hurt leg", "Accepted - Awaiting Payment", "Open", "", "", "", "", "Dog", "Labradoodle");
            Claim savedClaim9 = claimRepository.save(newClaim9);

            Claim newClaim10 = new Claim(null, 110, Date.valueOf("2023-01-01"), "Property", "Ms", "Laura", "Stephens", 100.00, "House burnt down", "Accepted - Paid", "Closed", "4 Fake Street", "", "", "", "", "");
            Claim savedClaim10 = claimRepository.save(newClaim10);
        }
    }

}