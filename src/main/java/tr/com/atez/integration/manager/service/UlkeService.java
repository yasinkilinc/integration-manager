package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.Ulke;
import tr.com.atez.integration.manager.service.base.BaseSecService;

import java.util.Map;

public interface UlkeService extends BaseSecService<Ulke> {

    Map<String, Ulke> findAllByKisaAd();

}
