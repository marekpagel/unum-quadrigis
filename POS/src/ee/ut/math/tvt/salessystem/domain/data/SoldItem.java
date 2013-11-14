package ee.ut.math.tvt.salessystem.domain.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving
 * history.
 */
public class SoldItem implements Cloneable, DisplayableItem {
	@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;

	//@OneToOne
	//@JoinColumn(name = "stockitem_id", nullable = true)
	private StockItem stockItem;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "itemprice")
	private double price;


	public SoldItem(StockItem stockItem, int quantity) {
		this.stockItem = stockItem;
		this.id = stockItem.getId();
		this.name = stockItem.getName();
		this.price = stockItem.getPrice();
		this.quantity = quantity;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getSum() {
		return ((double) ((int) (Math
				.round((price * ((double) quantity)) * 100)))) / 100;
	}

	public StockItem getStockItem() {
		return stockItem;
	}

	public void setStockItem(StockItem stockItem) {
		this.stockItem = stockItem;
	}

}
