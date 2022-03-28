package tr.com.atez.integration.manager.dto;

import lombok.Data;
import tr.com.atez.integration.manager.dto.base.BaseDTO;

import javax.validation.constraints.NotNull;

@Data
public class ManifestoRequestDTO extends BaseDTO {

    @NotNull
    private String base64Excel;

    @NotNull
    private String fileName;
}
