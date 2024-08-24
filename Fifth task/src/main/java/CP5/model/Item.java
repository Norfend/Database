package CP5.model;

import CP5.model.references.InvoiceHasItem;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "items", schema = "public")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "items_id_gen")
    @SequenceGenerator(name = "items_id_gen", sequenceName = "items_item_ID_seq", allocationSize = 1)
    @Column(name = "\"item_ID\"", nullable = false)
    private Long id;

    @Column(name = "item", nullable = false, length = Integer.MAX_VALUE)
    private String item;

    @OneToMany(mappedBy = "itemsItem")
    private Set<InvoiceHasItem> invoiceHasItems = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Set<InvoiceHasItem> getInvoiceHasItems() {
        return invoiceHasItems;
    }

    public void setInvoiceHasItems(Set<InvoiceHasItem> invoiceHasItems) {
        this.invoiceHasItems = invoiceHasItems;
    }

}