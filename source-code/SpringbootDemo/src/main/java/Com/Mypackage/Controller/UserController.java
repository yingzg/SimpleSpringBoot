package Com.Mypackage.Controller;

import Com.Mypackage.Common.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/User")

public class UserController {

    @Autowired
    private ServerSettings ServerSettings;


    @GetMapping("getSetting")
    public Object getSetting()
    {
        return ServerSettings;
    }

}
