package edu.hm.cs.cnj.cnjbackend.service;

import edu.hm.cs.cnj.cnjbackend.persistence.Teilnahme;
import edu.hm.cs.cnj.cnjbackend.persistence.TeilnahmeStatus;
import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;
import edu.hm.cs.cnj.cnjbackend.persistence.VeranstaltungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by Hanway on 14.11.2017.
 */
@Service
@Transactional
public class VeranstaltungService {

    @Autowired
    private VeranstaltungRepository repository;

    public Long erzeugeVeranstaltung(String titel, String beschreibung, Date beginn) {
        Veranstaltung veranstaltung = new Veranstaltung(titel, beschreibung, beginn);
        repository.save(veranstaltung);
        return veranstaltung.getId();
    }

    public void fuegeTeilnahmeHinzu(long key, String name, int begleiter) {
        Veranstaltung veranstaltung = repository.findOne(key);
        Teilnahme teilnahme = new Teilnahme(name, begleiter);
        veranstaltung.add(teilnahme);
    }

    public void sageOffeneTeilnahmenAbBis(Date date){
        for(Veranstaltung veranstaltung : repository.findByBeginnBefore(date)){
            for(Teilnahme teilnahme : veranstaltung.getTeilnahme()){
                if(teilnahme.getStatus().equals(TeilnahmeStatus.OFFEN)){
                    teilnahme.setStatus(TeilnahmeStatus.ABSAGE);
                }
            }
        }
    }

}