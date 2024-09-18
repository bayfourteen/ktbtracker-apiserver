package com.bayfourteen.kingtiger.ktbtracker.apiserver.repository;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteUsersRepository extends JpaRepository<SiteUser, String> {

    public Optional<SiteUser> findByName(String displayName);


}
