package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.OlcuBirim;
import tr.com.atez.integration.manager.entity.Ulke;
import tr.com.atez.integration.manager.service.base.BaseSecService;

import java.util.Map;

public interface OlcuBirimService extends BaseSecService<OlcuBirim> {

    Map<String, OlcuBirim> findAllByCms();

}
