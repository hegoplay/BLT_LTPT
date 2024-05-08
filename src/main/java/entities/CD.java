package entities;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "cds")
@lombok.ToString
public class CD implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8897589669826109808L;
	@Id
	@Column(name = "cd_id")
	private String cdID;
	private String name;
	private int quantity;
	private double price;
	private boolean status;
	@jakarta.persistence.OneToMany(mappedBy = "cd")
	private Set<OrderDetail> od;
}
