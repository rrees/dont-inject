package com.shudderfix.stores {
	object MapStore extends Store {
		val store = scala.collection.mutable.Map[String, Int]()
	}
	
	trait Store {
		val store : scala.collection.mutable.Map[String, Int]
		
		def increment(key: String) = {
			if(store contains(key)) store(key) = store(key) + 1 else store(key) = 1
			store(key)
		}
		
		def decrement(key: String) = {
			store.contains(key) match {
				case true if store(key) > 0 => store(key) = store(key) - 1
				case false => store(key) = 0
			}
			store(key)
		}
	}
		
}