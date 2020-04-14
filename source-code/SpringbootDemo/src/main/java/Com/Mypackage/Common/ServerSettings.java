package Com.Mypackage.Common;

//服务器配置

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:Config/author.properties")
@ConfigurationProperties(prefix ="settings")
public class ServerSettings {

    private String name;

    private  String domain;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
         this.name=name;
    }

    public String getdomain()
    {
        return this.domain;
    }

    public void setdomain(String domain)
    {
        this.domain=domain;
    }
}
