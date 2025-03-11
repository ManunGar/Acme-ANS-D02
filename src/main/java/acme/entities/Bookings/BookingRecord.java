
package acme.entities.Bookings;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.entities.Passengers.Passenger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookingRecord extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ManyToOne(optional = false)
	private Booking				booking;

	@ManyToOne(optional = false)
	private Passenger			passenger;

}
