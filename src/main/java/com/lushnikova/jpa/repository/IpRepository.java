package com.lushnikova.jpa.repository;

import com.lushnikova.jpa.model.entity.Ip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpRepository extends JpaRepository<Ip, Long> {
}
