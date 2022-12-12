package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.MasterMapper;
import kg.megacom.Salon.mapper.SalonMapper;
import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.dtos.MasterDto;
import kg.megacom.Salon.repository.MasterRepository;
import kg.megacom.Salon.services.MasterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasterServicesImpl implements MasterServices {
    @Autowired
    private MasterRepository masterRepository;
    @Override
    public MasterDto save(MasterDto masterDto) {
        return MasterMapper.INSTANCE.toDto(masterRepository.save(MasterMapper.INSTANCE.toEntity(masterDto)));
    }

    @Override
    public MasterDto findById(Long id) {
        return MasterMapper.INSTANCE.toDto(masterRepository.findById
                (id).orElseThrow(()->new RuntimeException("Не найден мастер с таким id")));
    }

    @Override
    public List<MasterDto> findAll() {
        return MasterMapper.INSTANCE.toDtos(masterRepository.findAll());
    }

    @Override
    public List<MasterDto> findBySalon(Long id) {
        List<Master> masters = masterRepository.findBySalon(id);
        return MasterMapper.INSTANCE.toDtos(masters);
    }
}
