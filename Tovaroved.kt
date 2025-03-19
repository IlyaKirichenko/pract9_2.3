package `Internet-Market`

class Tovaroved {
    private val products = Array(100) {Product(0,"", 0.0)}
    private var productCount = 0

    private val blacklist = Array(100) { Client(0, "") }
    private var blacklistCount = 0

    fun addProduct(product: Product) {
        if (productCount < products.size) {
            products[productCount] = product
            productCount++
            println("Добавлен товар: $product")
        } else {
            println("Невозможно добавить товар: достигнут лимит.")
        }
    }

    fun registerSale(order: Order, client: Client): Sell {
        if (isClientInBlacklist(client)) {
            throw IllegalStateException("Клиент ${client.name} находится в черном списке и не может совершать покупки.")
        }
        val sale = Sell(order, client)
        println("Продажа заказа ${order.orderId} зарегистрирована.")
        return sale
    }

    fun addToBlacklist(client: Client) {
        if (blacklistCount < blacklist.size) {
            blacklist[blacklistCount] = client
            blacklistCount++
            println("Клиент ${client.name} добавлен в черный список.")
        } else {
            println("Невозможно добавить клиента в черный список: достигнут лимит.")
        }
    }
    private fun isClientInBlacklist(client: Client): Boolean {
        for (i in 0 until blacklistCount) {
            if (blacklist[i].id == client.id) {
                return true
            }
        }
        return false
    }
    fun getProducts(): Array<Product> {
        return products.copyOfRange(0, productCount)
    }
}