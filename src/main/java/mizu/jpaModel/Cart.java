package mizu.jpaModel;

import javax.persistence.*;

/**
 * Created by ms.rodriguez on 21/2/2017.
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @Column(name = "productId")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private int productId;

}
