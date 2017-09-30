

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LiveChatOnlineTest.class, 
	LiveChatTest.class,
	LoginTest.class, 
	LookingHolidaySearchTest.class,
	ReservationTest.class,
	SmokeTest.class })
public class AllTests {
}
