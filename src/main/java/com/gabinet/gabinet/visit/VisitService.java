package com.gabinet.gabinet.visit;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit add(Visit visit) {
        return visitRepository.save(visit);
    }

    public Optional byId(Long id) {
        return visitRepository.findById(id);
    }

    public List<Visit> all(){
        return visitRepository.findAll();
    }

    public void delete(Long id){
        visitRepository.deleteById(id);
    }

    public List<Visit> getByClientId(Long id){
        return visitRepository.findByClientId(id);
    }

    public Visit update (Long id, Visit visit) {
        Optional<Visit> oldVisit = visitRepository.findById(id);
        if (oldVisit.isPresent()){
            Visit newVisit = oldVisit.get();
            newVisit.setDate(visit.getDate());
            newVisit.setNote(visit.getNote());
            return visitRepository.save(newVisit);
        }
        return visit;
    }
}
