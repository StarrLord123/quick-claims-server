package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;

import java.util.List;

public interface ClaimService {

    public List<Claim> getAllClaims();

    public Claim getById(Integer id) throws ClaimNotFoundException;

    public List<Claim> getByInsuranceType(String insuranceType);

    public List<Claim> getByStatus(String status);
}
