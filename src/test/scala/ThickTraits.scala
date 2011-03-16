package test.traits {

	import org.scalatest._
	import org.scalatest.matchers._
	import org.scalatest.mock._
	
	class StoreSpec extends Spec with ShouldMatchers with MockitoSugar {
		import com.shudderfix.stores._
		
		object MockStore extends Store {
			val store = mock[scala.collection.mutable.Map[String, Int]]
		}
	
		describe("The cache") {
			describe("using a real store") {
				it("should have concrete properties") {
					MapStore.increment("joe") should be(1)
				}
			}
			describe ("using the mock store") {
				import org.mockito.Mockito._
				
				it("should allow verification") {
					stub(MockStore.store.contains("sally")).toReturn(false)
					MockStore.decrement("sally")
					verify(MockStore.store)
				}
			}
		}	
	}
	
}