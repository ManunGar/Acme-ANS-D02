
package acme.entities.Passengers;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import acme.entities.Bookings.Booking;

public class PassengerBooking extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ManyToOne(optional = false)
	private Booking				booking;

	@ManyToOne(optional = false)
	private Passenger			passenger;

	@Optional //esto hay que ponerlo?? y va aqui??
	@ValidString //cuanto??
	@Column(unique = true)
	private String				seatNumber;

}
