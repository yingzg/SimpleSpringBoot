package Com.ExceptionHandle.Model;

import lombok.Data;

@Data
public class CarType {
    private String type;

    public CarType(String type)
    {
        this.type=type;
    }

}
