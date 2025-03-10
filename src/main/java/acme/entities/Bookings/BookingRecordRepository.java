
package acme.entities.Bookings;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.Passengers.Passenger;

@Repository
public interface BookingRecordRepository extends AbstractRepository {

	@Query("SELECT COUNT(br) FROM BookingRecord br WHERE br.booking = :booking AND br.passenger = 	:passenger")
	Long PassengerInBooking(@Param("passenger") Passenger passenger, @Param("booking") Booking booking);

}
