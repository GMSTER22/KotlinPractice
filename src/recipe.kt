data class Recipe (
    val id: Int,
    val name: String,
    val category: String,
    val area: String,
    val instructions: String,
    val ingredients: List<String>,
    val measures: List<String>
) {

    fun printRecipeOverview() {
        println("\nname = $name")
        println("category = $category")
        println("area = $area\n")
        println("Instructions:")
        println(instructions)
        println()
        println("Ingredients")
        for (i in ingredients.indices) {
            println("${i + 1}_ ${ingredients[i]} = ${measures[i]}")
        }
    }

}