package tr.com.atez.integration.manager.dto;

import lombok.Data;
import tr.com.atez.integration.manager.entity.Beyanname;

@Data
public class BeyannameStatus {

    private Beyanname beyanname;
    private boolean status;

}
