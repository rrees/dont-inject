package test {

	import org.scalatest._
	import org.scalatest.matchers._

	class PassFunctions extends FeatureSpec with ShouldMatchers {
		import chelsea._
		
		val fakeOrder = new BreakfastOrder
	
		feature("function passing") {
			scenario("vetoing function vetos") {
				var flag = false
			
				Hotel.serveBreakfast(new Guest, (Guest) => {flag = true; fakeOrder}, Some((Guest) => true))
			
				flag should be(false)
			}
		
			scenario("vetoing function does not veto") {
				var flag = false
			
				Hotel.serveBreakfast(new Guest, (Guest) => {flag = true; fakeOrder}, Some((Guest) => false))
			
				flag should be(true)
			}
			scenario("no vetoing function supplied") {
				Hotel.serveBreakfast(new Guest, (Guest) => {fakeOrder}) should be(Some(fakeOrder))
			}
		}
		
	} 
}