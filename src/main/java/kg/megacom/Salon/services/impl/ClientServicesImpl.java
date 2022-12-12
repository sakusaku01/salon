package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.ClientMapper;
import kg.megacom.Salon.model.dtos.ClientDto;
import kg.megacom.Salon.repository.ClientRepository;
import kg.megacom.Salon.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServicesImpl implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto clientDto) {
        return ClientMapper.INSTANCE.toDto(clientRepository.save(ClientMapper.INSTANCE.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Long id) {
        return ClientMapper.INSTANCE.toDto(clientRepository.findById
                (id).orElseThrow(()->new RuntimeException("Не найден клиент с таким id")));
    }

    @Override
    public List<ClientDto> findAll() {
        return ClientMapper.INSTANCE.toDtos(clientRepository.findAll());
    }
}
