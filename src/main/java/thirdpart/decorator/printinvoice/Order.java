package thirdpart.decorator.printinvoice;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Vector;


public abstract class Order {

    private OrderLine inkOrderLine;
    @Getter
    @Setter
    protected String customerName;
    @Getter
    @Setter
    protected Date salesDate;
    protected Vector<OrderLine> items = new Vector<>(10);

    public void print() {
        for (OrderLine item : items) {
            item.printLine();
        }
    }

    public void addItem(OrderLine item) {
        items.add(item);
    }

    public void removeItem(OrderLine item) {
        items.remove(item);
    }

    public double getGrandTotal(){
        double amnt = 0.0D;
        for (OrderLine item : items) {
            amnt += item.getSubTotal();
        }
        return amnt;
    }

    protected String formatCurrency(double amnt){
        return "";
    }

}
