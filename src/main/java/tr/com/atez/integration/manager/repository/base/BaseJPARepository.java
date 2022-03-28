package tr.com.atez.integration.manager.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseJPARepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

}
