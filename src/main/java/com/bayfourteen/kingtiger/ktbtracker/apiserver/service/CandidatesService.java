package com.bayfourteen.kingtiger.ktbtracker.apiserver.service;


import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.Candidate;
import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.CandidatesPageResponse;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.repository.CandidatesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatesService {

    private final CandidatesRepository candidatesRepository;
    private final ModelMapper modelMapper;


    public Candidate create(Candidate candidate) {
        return modelMapper.map(candidatesRepository.save(
                modelMapper.map(candidate, com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Candidate.class)), Candidate.class);
    }

    public void delete(Candidate candidate) {
        candidatesRepository.delete(
                modelMapper.map(candidate, com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Candidate.class));
    }



    public Optional<Candidate> findById(Integer candidateId) {
        return candidatesRepository.findById(candidateId).map(o -> modelMapper.map(o, Candidate.class));
    }

    public List<Candidate> findByCycleId(Integer cycleId) {
        return candidatesRepository.findByCycleIdOrderByIdDesc(cycleId).stream().map(e -> modelMapper.map(e, Candidate.class))
                .toList();
    }

    public CandidatesPageResponse findByCycleId(Integer cycleId, Pageable pageable) {
        return modelMapper.map(candidatesRepository.findByCycleIdOrderByIdDesc(cycleId, pageable), CandidatesPageResponse.class);
    }

    public List<Candidate> findAllForUser(String userId) {
        return candidatesRepository.findAllForUser(userId).stream().map(e -> modelMapper.map(e, Candidate.class))
                .toList();
    }

    public Candidate update(Candidate candidate) {
        return modelMapper.map(candidatesRepository.save(
                modelMapper.map(candidate, com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Candidate.class)), Candidate.class);
    }
}
