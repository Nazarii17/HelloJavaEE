package nazarii.tkachuk.com.services;

import nazarii.tkachuk.com.dao.OrderDao;
import nazarii.tkachuk.com.entities.Order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderService {

    private OrderDao orderDao = new OrderDao();

    public Order getByID(int id){
        return orderDao.getByID(id).get();
    }

    public List<Order> getAll(){
        return orderDao.getAll();
    }

    public List<Order> getAllByDate(String date){
        return orderDao.getAllByDate(date);
    }

    public void save(Order order){
        orderDao.save(order);
    }

    public void save(Timestamp orderDate,
                     Integer quantity,
                     Integer customerID,
                     Integer productID,
                     BigDecimal price){
        orderDao.save(new Order(orderDate, quantity, customerID, productID, price));
    }

    public void update(Order order){
        orderDao.update(order);
    }

    public void update(Integer id, String[] params){
        orderDao.update(new Order(id),params);
    }

    public void update(Order order, String[] params){
        orderDao.update(order,params);
    }

    public void update(Integer id,
                       Timestamp orderDate,
                       Integer quantity,
                       Integer customerID,
                       Integer productID,
                       BigDecimal price ){
        String[] params = new String[]{orderDate.toString(), quantity.toString(), customerID.toString(), productID.toString(), price.toString()};
        orderDao.update(new Order(id),params);
    }

    public void update(Order order,
                       Timestamp orderDate,
                       Integer quantity,
                       Integer customerID,
                       Integer productID,
                       BigDecimal price ){
        String[] params = new String[]{orderDate.toString(), quantity.toString(), customerID.toString(), productID.toString(), price.toString()};
        orderDao.update(order, params);
    }

    public void delete(Order order){
        orderDao.delete(order);
    }

    public void deleteByID(Integer id){
        orderDao.deleteByID(id);
    }

    public void deleteByDate(String date){
        orderDao.deleteByDate(date);
    }
}
