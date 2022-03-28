package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.Firma;

public interface FirmaService {
    Firma findByFirmaId(String firmaId);

}
