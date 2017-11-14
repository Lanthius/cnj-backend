package edu.hm.cs.cnj.cnjbackend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Hanway on 14.11.2017.
 */
public interface VeranstaltungRepository extends JpaRepository<Veranstaltung, Long> {

    List<Veranstaltung> findByBeginnBefore(Date date);

}
