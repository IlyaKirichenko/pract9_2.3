package `Internet-Market`

class Product(val id: Int, val name: String, val price: Double) {
    override fun toString(): String {
        return "Товар: $name (ID: $id), Цена: $price руб."
    }
}