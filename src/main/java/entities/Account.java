package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Table(name = "accounts")
@lombok.ToString
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6814884279485049540L;
	@jakarta.persistence.Id
	@jakarta.persistence.Column(name = "user_name")
	private String userName;
	private String password;
}
