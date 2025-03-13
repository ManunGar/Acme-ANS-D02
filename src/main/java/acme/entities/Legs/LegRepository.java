
package acme.entities.Legs;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import acme.client.repositories.AbstractRepository;

public interface LegRepository extends AbstractRepository {

	@Query("SELECT t FROM Leg t WHERE t.flight.id = :flightId")
	List<Legs> findAllByFlightId(@Param("flightId") Integer flightId);

	@Query("select l.departure from Leg l where l.flight.id = :flightId order by l.scheduledDeparture")
	Date findDepartureByFlightId(Integer flightId);

	@Query("select l.arrival from Leg l where l.flight.id = :flightId order by l.scheduledDeparture desc")
	Date findArrivalByFlightId(Integer flightId);

	@Query("select l.departureAirport.city from Leg l where l.flight.id = :flightId order by l.scheduledDeparture")
	String findOriginCityByFlightId(Integer flightId);

	@Query("select l.arrivalAirport.city from Leg l where l.flight.id = :flightId order by l.scheduledDeparture desc")
	String findDestinationCityByFlightId(Integer flightId);

	@Query("select count(l) from Leg l where l.flight.id = :flightId")
	Integer numberOfLayours(Integer flightId);
}
