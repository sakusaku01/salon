package kg.megacom.Salon.services;

import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.dtos.MasterDto;

import java.util.List;

public interface MasterServices extends BaseServices<MasterDto>{
    List<MasterDto> findBySalon(Long id);
}
