
package acme.entities.Reviews;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.constraints.ValidReview;
import acme.entities.Airlines.Airline;
import acme.entities.Airports.Airport;
import acme.entities.Services.Service;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidReview
public class Review extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				subject;

	@Mandatory
	@ValidString(min = 1, max = 255)
	@Automapped
	private String				text;

	@Optional
	@ValidNumber(min = 0, max = 10, integer = 2, fraction = 2)
	@Automapped
	private double				score;

	@Optional
	@Automapped
	private boolean				recommended;

	@Optional
	@Valid
	@Automapped
	private Airline				airline;

	@Optional
	@Valid
	@Automapped
	private Airport				airport;

	@Optional
	@Valid
	@Automapped
	private Service				service;

}
