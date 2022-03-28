package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.dto.BeyannameStatus;
import tr.com.atez.integration.manager.entity.Manifesto;
import tr.com.atez.integration.manager.service.base.BaseSecService;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public interface ManifestoService extends BaseSecService<Manifesto> {

    void processFile(InputStream file, HashMap<String, BeyannameStatus> isPoNumberExistsInDb, HashMap<String, List<String>> malzemeKodList) throws IOException;
    List<Manifesto> findByStatusOrderByCreateDate(Manifesto.Status status);
    void save(Manifesto row, Manifesto.Status successful);

}
