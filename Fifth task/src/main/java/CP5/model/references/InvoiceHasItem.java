package CP5.model.references;

import CP5.model.Item;
import CP5.model.entities.Invoice;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"Invoice_has_items\"", schema = "public")
public class InvoiceHasItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Invoice_has_items_id_gen")
    @SequenceGenerator(name = "Invoice_has_items_id_gen", sequenceName = "Invoice_has_items_NMID_seq", allocationSize = 1)
    @Column(name = "\"NMID\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"items_item_ID\"", nullable = false)
    private Item itemsItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItemsItem() {
        return itemsItem;
    }

    public void setItemsItem(Item itemsItem) {
        this.itemsItem = itemsItem;
    }

}