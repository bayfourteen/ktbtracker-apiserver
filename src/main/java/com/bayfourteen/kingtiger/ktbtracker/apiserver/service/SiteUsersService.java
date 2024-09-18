package com.bayfourteen.kingtiger.ktbtracker.apiserver.service;


import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.SiteUser;
import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.SiteUsersPageResponse;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.repository.SiteUsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUsersService {

    private final SiteUsersRepository siteUsersRepository;

    private final ModelMapper modelMapper;


    public SiteUser upsert(SiteUser siteUser) {
        return modelMapper.map(
                siteUsersRepository.save(modelMapper.map(siteUser, com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.SiteUser.class)),
                SiteUser.class);
    }

    public SiteUsersPageResponse findSiteUsers(Pageable pageable) {
        return modelMapper.map(siteUsersRepository.findAll(pageable), SiteUsersPageResponse.class);
    }

    public Optional<SiteUser> findSiteUserById(String userId) {
        return Optional.ofNullable(modelMapper.map(siteUsersRepository.findById(userId), SiteUser.class));
    }

    public Optional<SiteUser> findSiteUserByDisplayName(String displayName) {
        return Optional.ofNullable(modelMapper.map(siteUsersRepository.findByName(displayName), SiteUser.class));
    }
}
