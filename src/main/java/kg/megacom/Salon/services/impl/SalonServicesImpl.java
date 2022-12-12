package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.SalonMapper;
import kg.megacom.Salon.model.dtos.SalonDto;
import kg.megacom.Salon.repository.SalonRepository;
import kg.megacom.Salon.services.SalonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalonServicesImpl implements SalonServices {
    @Autowired
    private SalonRepository salonRepository;


    @Override
    public SalonDto save(SalonDto salonDto) {
        return SalonMapper.INSTANCE.toDto(salonRepository.save(SalonMapper.INSTANCE.toEntity(salonDto)));
    }

    @Override
    public SalonDto findById(Long id) {
        return SalonMapper.INSTANCE.toDto(salonRepository.findById
                (id).orElseThrow(()->new RuntimeException("Не найден салон с таким id")));
    }

    @Override
    public List<SalonDto> findAll() {
        return SalonMapper.INSTANCE.toDtos(salonRepository.findAll());
    }

}
