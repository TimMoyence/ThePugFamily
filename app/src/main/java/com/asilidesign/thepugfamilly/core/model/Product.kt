data class ProductResponse(val record: List<Product>)

data class Product(
    val name: String,
    val description: String,
    val picture_url: String
)