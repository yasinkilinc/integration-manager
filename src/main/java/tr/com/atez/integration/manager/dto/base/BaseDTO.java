package tr.com.atez.integration.manager.dto.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDTO {

    private String id;

    private Long version;

    private LocalDateTime updateDate;

    private LocalDateTime createDate;
}