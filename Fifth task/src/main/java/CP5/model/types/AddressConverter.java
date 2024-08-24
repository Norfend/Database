package CP5.model.types;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {
    @Override
    public String convertToDatabaseColumn(Address attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        Address result = new Address();
        String[] parts = dbData.split(" ");
        result.setCity(parts[0]);
        result.setStreet(parts[1]);
        return result;
    }
}
