package com.seek.back.service;

import com.seek.back.domain.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate createCandidate(Candidate candidate);
    Candidate getCandidateById(Long id);
    List<Candidate> getAllCandidates();
    void deleteCandidate(Long id);
}
