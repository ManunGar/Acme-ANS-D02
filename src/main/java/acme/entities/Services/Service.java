
package acme.entities.Services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.PositiveOrZero;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.constraints.ValidShortText;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@Mandatory
	@ValidShortText
	@Automapped
	private String				name;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				pictureUrl;

	@Mandatory
	@PositiveOrZero
	@Automapped
	private Double				averageDwellTime;

	@Optional
	@ValidString(pattern = "^[A-Z]{4}-[0-9]{2}$")
	@Column(unique = true)
	private String				promotionCode;

	@Optional
	@ValidNumber(min = 0, max = 1000)
	@Automapped
	private Double				discount;

}
