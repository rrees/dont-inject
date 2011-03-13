package chelsea {

	class Guest
	class BreakfastOrder
	
	object Hotel {
		type BreakfastOrderer = (Guest) => BreakfastOrder
		type GuestVeto = (Guest) => Boolean
		
		def serveBreakfast(guest : Guest, orderBreakfast : BreakfastOrderer, veto : Option[GuestVeto] = None) : Option[BreakfastOrder] = {
			veto match {
				case Some(veto) if veto(guest) => None
				case _ => Some(orderBreakfast(guest))
			}
		}
	}
	
}