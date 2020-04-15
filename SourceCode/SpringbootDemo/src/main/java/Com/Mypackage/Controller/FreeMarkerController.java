package Com.Mypackage.Controller;

import Com.Mypackage.Common.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemaker")
public class FreeMarkerController {

    @Autowired
    private ServerSettings setting;


    @GetMapping("hello")
    public String index(ModelMap model)
    {
        model.addAttribute("set",setting);
        return "User";

    }

}
