import com.google.gson.Gson
import java.io.File

class RecipeManager {

    val jsonFile = File("src/recipes.json")
    val jsonString = jsonFile.readText()
    val gson = Gson()

    val recipes: MutableList<Recipe> = gson.fromJson(jsonString, Array<Recipe>::class.java).toMutableList()

    fun getRecipesCount(): Int = recipes.count()

    fun getRecipeById(id: Int): Recipe? = recipes.find { it.id == id }

    fun getRecipeByName(name: String): Recipe? = recipes.find { it.name.lowercase() == name.lowercase() }

//    fun getRecipesByCategory(category: String): List<Recipe> = recipes.filter { it.category.lowercase() == category.lowercase() }

//    fun getRecipesByArea(area: String): List<Recipe> = recipes.filter { it.area == area }

    fun getRecipeList(): MutableList<Recipe> = recipes

    fun addRecipe(recipe: Recipe) = recipes.add(recipe)

    fun removeRecipeById(id: Int): Boolean {

        val recipeToRemove = recipes.find { it.id == id }

        return if (recipeToRemove != null) {

            recipes.remove(recipeToRemove)

            true

        } else {

            false

        }

    }

}