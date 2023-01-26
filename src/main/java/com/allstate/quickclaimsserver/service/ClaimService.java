package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;

import java.util.List;
import java.util.Map;

public interface ClaimService {

    public List<Claim> getAllClaims();

    public Claim getById(Integer id) throws ClaimNotFoundException;

    public List<Claim> getByInsuranceType(String insuranceType);

    public List<Claim> getByPolicyNumber(String policyNumber);

    public List<String> getAllUpdates();

    public List<Claim> getByUpdates(String updates);

    public Claim saveClaim(Claim payment);

    public Claim updateClaim(Integer id, Map<String, Object> fields);
}
