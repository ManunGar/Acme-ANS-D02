
package acme.entities.Flight;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.constraints.ValidLongText;
import acme.constraints.ValidShortText;
import acme.entities.Airlines.Airline;
import acme.entities.Legs.LegRepository;
import acme.realms.AirlineManager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;
	@Autowired
	private LegRepository		repository;

	// Attributes

	@Mandatory
	@ValidShortText
	@Automapped
	private String				highlights;

	@Mandatory
	@Automapped
	private Boolean				selfTransfer;

	@Mandatory
	@ValidMoney(min = 0, max = 1000000)
	@Automapped
	private Money				cost;

	@Optional
	@ValidLongText
	@Automapped
	private String				description;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private AirlineManager		manager;


	@Transient
	public Date getSheduledDeparture() {
		Date result;
		result = this.repository.findDepartureByFlightId(this.getId());

		return result;
	}

	@Transient
	public Date getArrival() {
		Date result;
		result = this.repository.findArrivalByFlightId(this.getId());

		return result;
	}

	@Transient
	public String getOrigin() {
		String result;
		result = this.repository.findOriginCityByFlightId(this.getId());

		return result;
	}

	@Transient
	public String getDestination() {
		String result;
		result = this.repository.findDestinationCityByFlightId(this.getId());

		return result;
	}

	@Transient
	public Integer getLayovers() {
		Integer result;
		result = this.repository.numberOfLayours(this.getId());

		return result;
	}

}
