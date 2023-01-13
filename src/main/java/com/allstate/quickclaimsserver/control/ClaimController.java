package com.allstate.quickclaimsserver.control;

import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.quickclaimsserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<Claim> getAllClaims(@RequestParam(value="insuranceType", required = false) String insuranceType) {
        if (insuranceType == null) {
            return claimService.getAllClaims();
        }
        else {
            return claimService.getByInsuranceType(insuranceType);
        }
    }

    @GetMapping("/{id}")
    public Claim findById (@PathVariable Integer id) throws ClaimNotFoundException {
        return claimService.getById(id);
    }
}