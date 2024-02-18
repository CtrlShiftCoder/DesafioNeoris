package cl.camiletti.desafio.service;

import cl.camiletti.desafio.model.PhoneModel;
import cl.camiletti.desafio.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }


    public PhoneModel savePhone(PhoneModel phone) {
        return phoneRepository.save(phone);
    }
}
