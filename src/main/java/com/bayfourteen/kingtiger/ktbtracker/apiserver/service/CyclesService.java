package com.bayfourteen.kingtiger.ktbtracker.apiserver.service;

import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.Cycle;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.repository.CyclesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CyclesService {

    private final CyclesRepository cyclesRepository;

    private final ModelMapper modelMapper;


    public Optional<Cycle> getCycleById(Integer cycleId) {
        return Optional.ofNullable(modelMapper.map(cyclesRepository.findById(cycleId), Cycle.class));
    }

    public Cycle findByAlias(String alias) {
        return modelMapper.map(cyclesRepository.findByAlias(alias), Cycle.class);
    }

    public List<Cycle> findAll(Pageable pageable) {
        return cyclesRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .stream().map(e -> modelMapper.map(e, Cycle.class)).toList();
    }
}
