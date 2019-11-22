package nazarii.tkachuk.com.services;

import nazarii.tkachuk.com.dao.CustomerDAO;
import nazarii.tkachuk.com.entities.Customer;

import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public Customer getByID(int id) {
        return customerDAO.getByID(id).get();
    }

    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    public void save(String name,
                     String lastName,
                     String phoneNumber,
                     String email) {
        save(new Customer(name, lastName, phoneNumber, email));
    }

    public void update(Integer id,
                       String name,
                       String lastName,
                       String phoneNumber,
                       String email) {
        Customer customer = new Customer(id);
        String[] params = new String[]{name, lastName, phoneNumber, email};
        customerDAO.update(customer, params);
    }

    public void update(Customer customer,
                       String name,
                       String lastName,
                       String phoneNumber,
                       String email) {
        String[] params = new String[]{name, lastName, phoneNumber, email};
        customerDAO.update(customer, params);
    }

    public void update(Customer customer,
                       String[] params) {
        customerDAO.update(customer, params);
    }

    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    public void delete(Customer customer) {
        customerDAO.delete(customer);
    }

    public boolean deleteByID(Integer id) {
        return customerDAO.deleteByID(id);
    }

    public boolean deleteByPhoneNumber(String phoneNumber) {
        return customerDAO.deleteByPhoneNumber(phoneNumber);
    }

    public boolean deleteByEmail(String email){
        return customerDAO.deleteByEmail(email);
    }
}

