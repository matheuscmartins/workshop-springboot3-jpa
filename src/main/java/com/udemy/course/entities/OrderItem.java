package com.udemy.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId //refencia com a classe OrdemItemPK
    private OrderItemPK id = new OrderItemPK();
    //sempre que for criar uma classe auxiliar que é id composto tem que instanciar pra ela nao inicializar com null
    private Integer quantity;
    private Double price;

    public OrderItem(){

    }
    //neste casso os construtores não são criados automatico com o  ID, são feitos na mão o Order e Product
    public OrderItem(Order order,Product product,Integer quantity, Double price) {
        super();
        id.setOrder(order); //criado
        id.setProduct(product); //criado a mão
        this.quantity = quantity;
        this.price = price;
    }

    // getters e setters de Order e Product tbm foram criados a mão
    @JsonIgnore //para evitar o problema de loop
    public Order getOrder(){
        return  id.getOrder();
    }
    public void setOrder(Order order){
          id.setOrder(order);
    }
    public Product getProduct(){
        return  id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
