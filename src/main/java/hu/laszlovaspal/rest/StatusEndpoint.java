package hu.laszlovaspal.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusEndpoint {

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getApplicitionStatus() {
        return "Ok";
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getApplicationVersion() {
        return "0.1";
    }

}
