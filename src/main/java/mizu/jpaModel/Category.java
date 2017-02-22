package mizu.jpaModel;

import javax.persistence.*;

/**
 * Created by ms.rodriguez on 22/2/2017.
 */
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "description")
    private String categoryDescription;

    public String getCategoryDescription(){
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription){
        this.categoryDescription = categoryDescription;
    }

    public Category(String categoryDescription){
        this.categoryDescription = categoryDescription;
    }

}
