package com.techgeeknext.examples.drools.controller;

import com.techgeeknext.examples.drools.domain.FDRequest_V1;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixedDepositRateController {

    private final KieContainer kieContainer;

    public FixedDepositRateController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    @RequestMapping(value = "/getNextStatus", method = RequestMethod.GET, produces = "application/json")
    public FDRequest_V1 getStatusAndActions(@RequestParam(required = true) String preStatus, @RequestParam(required = true) String lastAction, @RequestParam(required = false) String actor) {
        KieSession kieSession = kieContainer.newKieSession();
        FDRequest_V1 fdRequest;
        if(actor != null ) {
             fdRequest = new FDRequest_V1(preStatus, lastAction, actor);
            
        }else{
             fdRequest = new FDRequest_V1(preStatus, lastAction);
            
        }
        kieSession.insert(fdRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return fdRequest;
    }
}
