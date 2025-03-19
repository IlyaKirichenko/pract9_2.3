package `Internet-Market`

class Order(val orderId: String, val products: Array<Product>, val productCount: Int) {
    val totalAmount: Double
        get() {
            var sum = 0.0
            for (i in 0 until productCount) {
                sum += products[i].price
            }
            return sum
        }

    fun pay(): Boolean {
        println("Заказ $orderId на сумму $totalAmount руб. оплачен.")
        return true
    }

    override fun toString(): String {
        val productNames = StringBuilder()
        for (i in 0 until productCount) {
            productNames.append(products[i].name)
            if (i < productCount - 1) productNames.append(", ")
        }
        return "Заказ $orderId: $productNames, Общая сумма: $totalAmount руб."
    }
}