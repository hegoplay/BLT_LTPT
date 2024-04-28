package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Table(name = "edit_histories")
public class EditHistory implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2485122972982980544L;
	@jakarta.persistence.Id
	@Column(name = "edit_id")
	private int id;
//	0 là thêm sản phẩm
//	1 tơi 15 đại diện cho từng sự cập nhật từng trường name, quantity, price, status
	private int status;
	@Column(name = "date_modify")
	private LocalDate dateModify;
	@ManyToOne
	@JoinColumn(name = "cd_id")
	private CD cd;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private StorageEmployee storageEmployee;
	
}
