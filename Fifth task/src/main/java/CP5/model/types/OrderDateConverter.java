package CP5.model.types;

import jakarta.persistence.AttributeConverter;

public class OrderDateConverter implements AttributeConverter<OrderDate, String> {
    @Override
    public String convertToDatabaseColumn(OrderDate attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public OrderDate convertToEntityAttribute(String dbData) {
        return dbData == null ? null : OrderDate.fromString(dbData);
    }
}
