package tr.com.atez.integration.manager.mapper.dto.base;

import java.util.List;

public interface BaseDTOMapper<Domain, DTO> {

    Domain toDomain(DTO dto);

    List<Domain> toDomainList(List<DTO> dtos);

    DTO toDTO(Domain domain);

    List<DTO> toListDTO(List<Domain> entityObjects);

}
