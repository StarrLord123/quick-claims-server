package com.allstate.quickclaimsserver;

import com.allstate.quickclaimsserver.data.ClaimRepository;
import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.service.ClaimService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ClaimServiceTests {

    @Autowired
    private ClaimService claimService;

    @MockBean
    private ClaimRepository claimRepository;

    @Test
    public void testGetAllClaims() {
        List<Claim> claim = new ArrayList<>();
        claim.add(new Claim(null, 101, LocalDate.of(2023, Month.JANUARY,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", ""));
        claim.add(new Claim(null, 102, LocalDate.of(2023,Month.JANUARY,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", ""));
        claim.add(new Claim(null, 103, LocalDate.of(2023,Month.JANUARY,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", ""));
        claim.add(new Claim(null, 104, LocalDate.of(2023,Month.JANUARY,01), "Property", "Mr", "John", "Smith", 100.00, "House burnt down", "New Claim", "Open", "1 Fake Street", "", "", "", "", ""));

        Mockito.when(claimRepository.findAll()).thenReturn(claim);

        List<Claim> claims = claimService.getAllClaims();
        assertEquals(4, claim.size());
    }

}