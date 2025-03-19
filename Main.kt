package `Internet-Market`
fun main() {
    val tovaroved = Tovaroved()
    val client1 = Client(1, "Иван Иванов")
    val client2 = Client(2, "Петр Петров")

    val product1 = Product(101, "Ноутбук", 50000.0)
    val product2 = Product(102, "Смартфон", 30000.0)

    tovaroved.addProduct(product1)
    tovaroved.addProduct(product2)

    val products = tovaroved.getProducts()
    val order1 = client1.makeOrder(products, products.size)
    if (client1.payOrder(order1)) {
        tovaroved.registerSale(order1, client1)
    }

    val order2 = client2.makeOrder(arrayOf(product1), 1)
    if (!client2.payOrder(order2)) {
        tovaroved.addToBlacklist(client2)
    }
    
    try {
        tovaroved.registerSale(order2, client2)
    } catch (e: IllegalStateException) {
        println(e.message)
    }
}
