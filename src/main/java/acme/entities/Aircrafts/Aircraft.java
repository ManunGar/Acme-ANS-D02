
package acme.entities.Aircrafts;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.constraints.ValidLongText;
import acme.constraints.ValidShortText;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes

	@Mandatory
	@ValidShortText
	@Automapped
	private String				model;

	@Mandatory
	@ValidShortText
	@Column(unique = true)
	private String				registrationNumber;

	@Mandatory
	@ValidNumber
	@Automapped
	private Integer				capacity;

	@Mandatory
	@ValidNumber(min = 2000, max = 50000)
	@Automapped
	private Integer				cargoWeight;

	@Mandatory
	@Automapped
	private AircraftStatus		status;

	@Optional
	@ValidLongText
	@Automapped
	private String				details;

}
