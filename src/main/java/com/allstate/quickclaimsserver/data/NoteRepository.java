package com.allstate.quickclaimsserver.data;
import com.allstate.quickclaimsserver.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    public List<Note> findAllByClaimId(Integer claimId);
}
