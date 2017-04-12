package mizu.proxy;

import mizu.jpaModel.Product;
import mizu.jpaModel.Staff;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by ms.rodriguez on 23/2/2017.
 */
@Component
public class ProductJsonMapper {

    private ObjectMapper mapper;

    public ProductJsonMapper(){
        mapper = new ObjectMapper();
    }

    public String mapJsonFromProduct(Product product){
        String json = "";
        try {
            json = mapper.writeValueAsString(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String mapJsonFromStaff(Staff staff){
        String json = "";
        try {
            json = mapper.writeValueAsString(staff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Product mapProductFromJson(String json){

        Product product = null;
        try {
            product = mapper.readValue(json, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Staff mapStaffFromJson(String json){
        Staff staff = null;

        try {
            staff = mapper.readValue(json, Staff.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staff;
    }

}
