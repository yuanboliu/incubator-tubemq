package org.apache.tubemq.manager.controller;

import java.util.List;
import java.util.Optional;
import org.apache.tubemq.manager.entry.BusinessEntry;
import org.apache.tubemq.manager.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/business")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    /**
     * add new business.
     *
     * @return - businessResult
     * @throws Exception - exception
     */
    @PostMapping("/add")
    public ResponseEntity<?> addBusiness() throws Exception {
        return ResponseEntity.ok().build();
    }

    /**
     * check business status
     *
     * @return -  BusinessResult
     * @throws Exception - exception
     */
    @GetMapping("/checkStatus")
    public ResponseEntity<List<BusinessEntry>> getBusiness() throws Exception {
        return ResponseEntity.ok().build();
    }

    /**
     * get business by id.
     *
     * @param id business id
     * @return BusinessResult
     * @throws Exception
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<BusinessEntry> getBusinessByID(
            @PathVariable Long id) throws Exception {
        Optional<BusinessEntry> businessEntry = businessRepository.findById(id);
        if (businessEntry.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
