package com.gabinet.gabinet.visit;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/visit")
@RestController
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("/add")
    public Visit add(@RequestBody Visit visit) {
        return visitService.add(visit);
    }

    @GetMapping("/all")
    public List<Visit> all(){
        return visitService.all();
    }

    @PostMapping("/{id}/delete")
    public void deleteById(Long id){
        visitService.delete(id);
    }
    @GetMapping("/client/{id}")
    public List<Visit> getByClientId(@PathVariable Long id){
        return visitService.getByClientId(id);
    }

}
