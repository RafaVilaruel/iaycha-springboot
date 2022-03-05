package com.vilaruel.rafael.iaycha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vilaruel.rafael.iaycha.model.PlayerInfoDTO;

public interface PlayerInfoRepository extends JpaRepository<PlayerInfoDTO, Long>{

	PlayerInfoDTO findById(long id);
}
