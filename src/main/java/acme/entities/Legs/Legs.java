
package acme.entities.Legs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.Aircrafts.Aircraft;
import acme.entities.Airports.Airport;
import acme.entities.Flight.Flight;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Legs extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Flight				flight;

	@Mandatory
	@ValidString(max = 7)
	@Column(unique = true)
	private String				IATAcode;

	@Mandatory
	@ValidMoment(past = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				departure;

	@Mandatory
	@ValidMoment(past = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				arrival;

	@Mandatory
	@ValidNumber
	@Automapped
	private Integer				duration;

	@Mandatory
	@Valid
	@Automapped
	private LegsStatus			status;

	@Mandatory
	@Valid
	@Automapped
	private Airport				departureAirport;

	@Mandatory
	@Valid
	@Automapped
	private Airport				arrivalAirport;

	@Mandatory
	@Valid
	@Automapped
	private Aircraft			aircraft;

}
