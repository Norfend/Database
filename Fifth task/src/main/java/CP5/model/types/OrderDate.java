package CP5.model.types;

public class OrderDate {
    private String day;
    private String month;
    private String year;

    public OrderDate() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static OrderDate fromString(String address) {
        String[] parts = address.split(",");
        OrderDate descriptor = new OrderDate();
        descriptor.setDay(parts[0]);
        descriptor.setMonth(parts[1]);
        descriptor.setYear(parts[2]);
        return descriptor;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDate orderDate)) return false;

        return day.equals(orderDate.day) && month.equals(orderDate.month) && year.equals(orderDate.year);
    }

    @Override
    public int hashCode() {
        int result = day.hashCode();
        result = 31 * result + month.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return day + "," + month + "," + year;
    }
}
