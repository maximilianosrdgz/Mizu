package mizu.proxy;

import mizu.jpaModel.Product;
import mizu.jpaModel.Staff;

/**
 * Created by ms.rodriguez on 12/4/2017.
 */
public class Main {
    public static void main (String[] args){
        ProductJsonMapper mapper = new ProductJsonMapper();
        String json = "{\"id\": 1, \"name\": \"Erika\"}";
        String json2 = "{\n" +
                "\t\"productId\": 2,\n" +
                "\t\"productName\":\"Harley Quinn Wig\",\n" +
                "\t\"price\": 10,\n" +
                "\t\"description\": \"Harley Quinn Customized Wig\",\n" +
                "\t\"category\": {\n" +
                "\t\t\"categoryId\": 2,\n" +
                "\t\t\"categoryDescription\": \"Category 2\"\n" +
                "\t}\n" +
                "}";

        System.out.println(json);

        Staff staff = null;
        staff = mapper.mapStaffFromJson(json);

        System.out.println(staff);

        System.out.println("json2: " + json2);

        Product product = null;
        product = mapper.mapProductFromJson(json2);

        System.out.println(mapper.mapJsonFromProduct(product));

    }
}
