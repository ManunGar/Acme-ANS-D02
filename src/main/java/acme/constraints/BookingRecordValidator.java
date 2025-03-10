
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.entities.Bookings.BookingRecord;
import acme.entities.Bookings.BookingRecordRepository;

public class BookingRecordValidator extends AbstractValidator<ValidBookingRecord, BookingRecord> {

	@Autowired
	BookingRecordRepository bookingRecordRepository;


	@Override
	protected void initialise(final ValidBookingRecord annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final BookingRecord bookingRecord, final ConstraintValidatorContext context) {

		boolean result;
		assert context != null;

		if (bookingRecord == null || bookingRecord.getBooking() == null || bookingRecord.getPassenger() == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			Long numberOfSameBookingRecord = this.bookingRecordRepository.PassengerInBooking(bookingRecord.getPassenger(), bookingRecord.getBooking());
			boolean uniqueBookingRecord = numberOfSameBookingRecord <= 1;
			super.state(context, uniqueBookingRecord, "*", "acme.validation.booking-record.duplicated.message");

		}

		result = !super.hasErrors(context);
		return result;
	}

}
