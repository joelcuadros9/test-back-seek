package com.seek.back.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.seek.back.domain.Candidate;
import com.seek.back.repository.CandidateRepository;
import com.seek.back.service.impl.CandidateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    private Candidate candidate;

    @BeforeEach
    public void setUp() {
        candidate = new Candidate();
        candidate.setName("Joel Cuadros");
        candidate.setEmail("joel.cuadros@example.com");
    }

    @Test
    public void testCreateCandidate() {
        when(candidateRepository.save(candidate)).thenReturn(candidate);

        Candidate created = candidateService.createCandidate(candidate);

        assertEquals("Joel Cuadros", created.getName());
        assertEquals("joel.cuadros@example.com", created.getEmail());
        verify(candidateRepository, times(1)).save(candidate);
    }
}
