import com.google.gson.Gson
import java.io.File

//Recipe manager Object gets data from the recipes.json file and save them in the recipes list
class RecipeManager {

    val jsonFile = File("src/recipes.json")
    val jsonString = jsonFile.readText()
    val gson = Gson()

    val recipes: MutableList<Recipe> = gson.fromJson(jsonString, Array<Recipe>::class.java).toMutableList()

//    returns the size of the recipes list
    fun getRecipesCount(): Int = recipes.count()

//    finds by id and returns a recipe
    fun getRecipeById(id: Int): Recipe? = recipes.find { it.id == id }

//    finds by name and returns a recipe
    fun getRecipeByName(name: String): Recipe? = recipes.find { it.name.lowercase() == name.lowercase() }

//    Returns the list of recipes
    fun getRecipeList(): MutableList<Recipe> = recipes

//    Add a recipe to the recipe list
    fun addRecipe(recipe: Recipe) = recipes.add(recipe)

//    finds a recipe by id and removes it from list
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