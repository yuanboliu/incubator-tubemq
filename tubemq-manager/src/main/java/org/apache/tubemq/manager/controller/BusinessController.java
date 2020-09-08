package org.apache.tubemq.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/business")
public class BusinessController {

    /**
     * add new business.
     *
     * @return - businessResult
     * @throws Exception - exception
     */
    @PostMapping("/add")
    public BusinessResult addBusiness() throws Exception {
        return new BusinessResult();
    }

    /**
     * check business status
     *
     * @return -  BusinessResult
     * @throws Exception - exception
     */
    @GetMapping("/checkStatus")
    public BusinessResult getBusiness() throws Exception {
        return new BusinessResult();
    }

    /**
     * get business by id.
     *
     * @param businessId business id
     * @return BusinessResult
     * @throws Exception
     */
    @GetMapping("/get/{id}")
    public BusinessResult getBusinessByID(@PathVariable Long businessId) throws Exception {
        return new BusinessResult();
    }
}
