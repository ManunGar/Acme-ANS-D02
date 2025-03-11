
package acme.forms;

import acme.client.components.basis.AbstractForm;
import acme.client.components.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDashboard extends AbstractForm {

	private static final long	serialVersionUID	= 1L;

	String[]					lastFiveDestinations;
	Money						moneySpentInBookingsLastYear;
	Integer						numberOfBookingsEconomy;
	Integer						numberOfBookingsBusiness;
	Money						countOfBookingsLastFiveYears;
	Money						averageCostOfBookingsLastFiveYears;
	Money						minimumCostOfBookingsLastFiveYears;
	Money						maximumCostOfBookingsLastFiveYears;
	Money						standardDeviationCostOfBookingsLastFiveYears;
	Integer						countOfPassengersInBookings;
	Double						averagePassengersInBookings;
	Integer						minimumPassengersInBookings;
	Integer						maximumPassengersInBookings;
	Double						standardDeviationPassengersInBookings;

}
