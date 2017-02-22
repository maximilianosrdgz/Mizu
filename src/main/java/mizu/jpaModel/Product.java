package mizu.jpaModel;


import javax.persistence.*;

/**
 * Created by ms.rodriguez on 20/2/2017.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "description", length = 16000)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "categoryId", length = 16000)
    private Category category;

    public Product(){
        category = new Category("Customized Wig");
    }

    public String toString(){
        return productName + "\n" +
                price + "\n" +
                category.getCategoryDescription();
    }

}
