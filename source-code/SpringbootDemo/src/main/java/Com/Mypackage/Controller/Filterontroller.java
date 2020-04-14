package Com.Mypackage.Controller;

import Com.Mypackage.Common.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Filterontroller {


    @Autowired
    private Com.Mypackage.Common.ServerSettings ServerSettings;

    @GetMapping("/api2/getSetting")
    public Object getSetting()
    {
        return ServerSettings;
    }
}
