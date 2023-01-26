package com.allstate.quickclaimsserver.control;

import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.quickclaimsserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<Claim> getAllClaims(@RequestParam(value="policyNumber", required = false) String policyNumber,
                                    @RequestParam(value="updates", required = false) String updates) {
        if (policyNumber != null) {
            return claimService.getByPolicyNumber(policyNumber);
        }
        else if (updates != null) {
            return claimService.getByUpdates(updates);
        }
        else {
            return claimService.getAllClaims();
        }
    }

    @GetMapping("/{id}")
    public Claim findById (@PathVariable Integer id) throws ClaimNotFoundException {
        return claimService.getById(id);
    }

    @PostMapping
    public Claim saveNewClaim(@RequestBody Claim claim) {
        System.out.println(claim);
        return claimService.saveClaim(claim);
    }

    @PutMapping("/{id}")
    public Claim updatePayment(@PathVariable Integer id, @RequestBody HashMap<String, Object> fields) {
        return claimService.updateClaim(id, fields);
    }
}