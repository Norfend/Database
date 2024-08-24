/*
package CP5.model.types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class AddressUserType {
    @Override
    public int getSqlType() {
        return Types.ARRAY;
    }

    @Override
    public Class<Address> returnedClass() {
        return Address.class;
    }

    @Override
    public boolean equals(Address x, Address y) throws HibernateException {
        if (x == y) return true;
        if (x == null || y == null) return false;
        return x.equals(y);
    }

    @Override
    public int hashCode(Address x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Address nullSafeGet(ResultSet rs, int i, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        String value = rs.getString(i);
        if (value == null) {
            return null;
        }
        String[] parts = value.split(",");
        if (parts.length < 2) {
            return null;
        }
        Address address = new Address();
        address.setStreet(parts[0]);
        address.setCity(parts[1]);
        return address;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Address value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            Address address = (Address) value;
            String stringValue = address.getStreet() + "," + address.getCity();
            st.setString(index, stringValue);
        }
    }

    @Override
    public Address deepCopy(Address o) {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Address o) {
        return null;
    }

    @Override
    public Address assemble(Serializable serializable, Object o) {
        return null;
    }

    @Override
    public Address replace(Address o, Address j1, Object o2) {
        return null;
    }
}*/
