package br.com.igreja.api.service;

import br.com.igreja.api.entidade.HelpersEntity;
import br.com.igreja.api.repository.HelperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelperService {
    private final HelperRepository helperRepository;

    public HelperService(HelperRepository helperRepository) {
        this.helperRepository = helperRepository;
    }

    public List<HelpersEntity> all(){
        return helperRepository.findAll();
    }

    public List<HelpersEntity> findByUserId(Long id){
        return helperRepository.findByUserId(id);
    }

    public void save(HelpersEntity helpersEntity){
        helperRepository.save(helpersEntity);
    }

    public void updateStatus(Long id, String status){
        Optional<HelpersEntity> helper = helperRepository.findById(id);
        helper.map(h -> {
            h.setStatus(status);
            helperRepository.save(h);
            return h;
        });
    }
}
