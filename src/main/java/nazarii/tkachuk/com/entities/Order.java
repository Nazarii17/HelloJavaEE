package nazarii.tkachuk.com.entities;

import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order extends EntityID /*implements CSVSerializable*/ {
    private Integer id;
    private Timestamp orderDate;
    private Integer quantity;
    private Integer customerID;
    private Integer productID;
    private BigDecimal price;

    private ProductService productService = new ProductService();

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(int id, Timestamp orderDate, Integer quantity, Integer customerID, Integer productID) {
        this.id = id;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.customerID = customerID;
        this.productID = productID;
        this.price = BigDecimal.valueOf(quantity).multiply(productService.getByID(productID).getPrice());
    }

    public Order(Timestamp orderDate, Integer quantity, Integer customerID, Integer productID, BigDecimal price) {
        this.id = null;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.customerID = customerID;
        this.productID = productID;
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Order(Timestamp orderDate, Integer quantity, Integer customerID, Integer productID) {
        this.id = id;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.customerID = customerID;
        this.productID = productID;
        this.price = BigDecimal.valueOf(quantity).multiply(productService.getByID(productID).getPrice());
    }

    public Order(Integer id, Timestamp orderDate, Integer quantity, Integer customerID, Integer productID, BigDecimal price) {
        this.id = id;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.customerID = customerID;
        this.productID = productID;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp dateTime) {
        this.orderDate = dateTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    //    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
    @Override
    public String toString() {
        return "Order{" +
                "ID=" + id +
                ", dateTime=" + orderDate +
                ", quantity=" + quantity +
                ", customerID=" + customerID +
                ", productID=" + productID +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderDate().equals(order.getOrderDate()) &&
                getQuantity().equals(order.getQuantity()) &&
                customerID.equals(order.customerID) &&
                productID.equals(order.productID) &&
                price.equals(order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderDate(), getQuantity(), customerID, productID, price);
    }
//    @Override
//    public String toCSVFormattedString() {
//        return String.format(CSVFormats.ORDER.getFormatValue(),  id + ",", orderDate + ",",
//                quantity + ",", customerID + ",", productID  + ",", price);
//    }
//
//    @Override
//    public String toCSVString() {
//        return id + ","+ orderDate + ","+ quantity + "," + customerID + "," + productID  + "," + price+"\n";
//    }
}