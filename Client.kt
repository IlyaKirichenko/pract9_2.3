package `Internet-Market`

class Client(val id: Int, val name: String) {
    private var orderCounter = 0

    fun makeOrder(products: Array<Product>, productCount: Int): Order {
        orderCounter++
        val orderId = "ORD$orderCounter"
        val order = Order(orderId, products, productCount)
        println("Клиент $name создал заказ: $order")
        return order
    }

    fun payOrder(order: Order): Boolean {
        if (order.pay()) {
            println("Клиент $name оплатил заказ.")
            return true
        }
        println("Оплата не удалась.")
        return false
    }
}