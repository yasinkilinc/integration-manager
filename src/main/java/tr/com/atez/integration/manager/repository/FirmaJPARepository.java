package tr.com.atez.integration.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.atez.integration.manager.entity.Firma;

import java.io.Serializable;

public interface FirmaJPARepository<T, ID extends Serializable> extends JpaRepository<Firma, String> {
    Firma findByfirmaId(String firmaId);
}
