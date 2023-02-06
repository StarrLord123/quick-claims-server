package com.allstate.quickclaimsserver.service;

import com.allstate.quickclaimsserver.domain.Claim;
import com.allstate.quickclaimsserver.domain.Note;
import com.allstate.quickclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.quickclaimsserver.exceptions.NoteNotFoundException;

import java.util.List;
import java.util.Map;

public interface NoteService {

    public List<Note> getAllNotes();

    public List<Note> getAllNotesForClaim(Integer claimId) throws ClaimNotFoundException;

    public Note getById(Integer id) throws NoteNotFoundException;

    public Note saveNote(Note note);

    public List<Note> saveNotes(Integer claimId, List<Note> notes);

    public Note updateNote(Integer id, Map<String, Object> fields);
}
