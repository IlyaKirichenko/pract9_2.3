package `Internet-Market`

class Sell (val order: Order, val client: Client) {
    init {
        println("Продажа заказа ${order.orderId} клиенту ${client.name} зарегистрирована.")
    }
}