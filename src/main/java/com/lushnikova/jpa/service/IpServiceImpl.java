package com.lushnikova.jpa.service;

import com.lushnikova.jpa.model.entity.Ip;
import com.lushnikova.jpa.repository.IpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class IpServiceImpl {
    private final IpRepository ipRepository;

    public void saveIp(String ip, LocalDate date) {
        var ipToSave = Ip.builder()
                .ip(ip)
                .date(date)
                .build();

        log.debug("Saving ip {}", ipToSave);

        ipRepository.save(ipToSave);
    }
}
