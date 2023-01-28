package com.example.organization_info.component;

import com.example.organization_info.domain.District;
import com.example.organization_info.domain.Region;
import com.example.organization_info.repository.DistrictRepository;
import com.example.organization_info.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DistrictRepository districtRepository;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            Region region = new Region();
            region.setName("Tashkent");
            Region savedRegion = regionRepository.save(region);
            District district = new District();
            district.setName("YUNUSOBOD");
            district.setRegion(savedRegion);
            districtRepository.save(district);
        }
    }
}
