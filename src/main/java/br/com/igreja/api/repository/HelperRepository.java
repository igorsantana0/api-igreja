package br.com.igreja.api.repository;

import br.com.igreja.api.entidade.HelpersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelperRepository extends JpaRepository<HelpersEntity, Long> {
    List<HelpersEntity> findByUserId(Long id);
}
