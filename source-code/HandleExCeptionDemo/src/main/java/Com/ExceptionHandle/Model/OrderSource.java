package Com.ExceptionHandle.Model;

public class OrderSource {

    public Customer customer;
    public Address billingAddress;

    public OrderSource(Customer customer, Address billingAddress) {
        this.customer = customer;
        this.billingAddress = billingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "OrderSource{" +
                "customer=" + customer +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
