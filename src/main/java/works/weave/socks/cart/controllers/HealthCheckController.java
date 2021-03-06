package works.weave.socks.cart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import works.weave.socks.cart.entities.HealthCheck;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HealthCheckController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/health")
    public
    @ResponseBody
    Map<String, List<HealthCheck>> getHealth() {
       Map<String, List<HealthCheck>> map = new HashMap<String, List<HealthCheck>>();
       List<HealthCheck> healthChecks = new ArrayList<HealthCheck>();
       Date dateNow = Calendar.getInstance().getTime();

       HealthCheck app = new HealthCheck("carts", "OK", dateNow);
       HealthCheck database = new HealthCheck("carts-db", "OK", dateNow);

       healthChecks.add(app);
       healthChecks.add(database);

       map.put("health", healthChecks);
       return map;
    }
}
