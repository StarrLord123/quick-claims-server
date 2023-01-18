package com.allstate.quickclaimsserver.data;

import com.allstate.quickclaimsserver.domain.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    public List<Claim> findAllByInsuranceType(String insuranceType);
    public List<Claim> findAllByStatus(String status);

}
