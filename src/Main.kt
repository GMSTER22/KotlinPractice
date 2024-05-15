import java.util.*
import java.util.Scanner

fun main() {
    println("                =============================================")
    println("                ======= Welcome to the Recipe Manager =======")
    println("                =============================================")

    val scanner = Scanner(System.`in`)

    val recipeManager: RecipeManager = RecipeManager()

//    val recipes: MutableList<Recipe> = recipeManager.getRecipeList()

    var isProgramOn : Boolean = true

    while (isProgramOn) {

        showOptions()

        var userChoice: String = scanner.nextLine()

        if (userChoice.toInt() == 1) {

            val numberOfRecipes: Int = recipeManager.getRecipesCount()
            val recipes: MutableList<Recipe> = recipeManager.getRecipeList()

            for (i in 0..numberOfRecipes - 1) {
                val (id, name) = recipes[i]
                println("$id ---> $name \n")
            }

        } else if (userChoice.toInt() == 2) {

            println()
            print("Enter the Recipe Id: ")
            var recipeId: String = scanner.nextLine()

            val recipe: Recipe? = recipeManager.getRecipeById(recipeId.toInt())

            if (recipe != null) recipe.printRecipeOverview()

        } else if (userChoice.toInt() == 3) {

            println()
            print("Enter the Recipe Name: ")
            var recipeName: String = scanner.nextLine()

            val recipe: Recipe? = recipeManager.getRecipeByName(recipeName)

            if (recipe != null) recipe.printRecipeOverview()

        } else if (userChoice.toInt() == 4) {

            println()
            print("Enter the Recipe Name: ")
            val recipeName: String = scanner.nextLine()

            print("Enter the Recipe Category: ")
            val recipeCategory: String = scanner.nextLine()

            print("Enter the Recipe Area: ")
            var recipeArea: String = scanner.nextLine()

            println("Prepare to enter the Instructions: ")
            val recipeInstructions: MutableList<String> = mutableListOf()
            var isInstructionsComplete: Boolean = false

            while (! isInstructionsComplete) {
                val stepNumber: Int = recipeInstructions.count() + 1

                print("Enter the step #${stepNumber} ")
                val step: String = scanner.nextLine()

                recipeInstructions.add("$stepNumber.\t$step\n")

                println("\nSelect one of the options below:")
                println("1. Continue adding instructions")
                println("2. Complete instructions ")

                println()
                print("Enter your option: ")
                val isDone: String = scanner.nextLine()

                if (isDone.toInt() == 2) isInstructionsComplete = true

            }


            println("\nPrepare to enter the Ingredients: ")
            val recipeIngredients: MutableList<String> = mutableListOf()
            val recipeMeasures: MutableList<String> = mutableListOf()

            var isIngredientsComplete: Boolean = false

            while (! isIngredientsComplete) {
                val ingredientNumber: Int = recipeIngredients.count() + 1

                print("Enter the ingredient #${ingredientNumber} ")
                val ingredient: String = scanner.nextLine()

                print("Enter the measure of the ingredient #${ingredientNumber} (${ingredient}) ")
                val measure: String = scanner.nextLine()

                recipeIngredients.add(ingredient)
                recipeMeasures.add(measure)

                println("\nSelect one of the options below:")
                println("1. Continue adding ingredients")
                println("2. Complete ingredients ")

                println()
                print("Enter your option: ")
                val isDone: String = scanner.nextLine()

                if (isDone.toInt() == 2) isIngredientsComplete = true

            }

            val newRecipe: Recipe = Recipe(recipeManager.getRecipesCount(), recipeName, recipeCategory, recipeArea,
                recipeInstructions.joinToString(separator = ""), recipeIngredients, recipeMeasures)

            recipeManager.addRecipe(newRecipe)

        } else if (userChoice.toInt() == 5) {

            println()
            print("Enter the Recipe Id: ")
            var recipeId: String = scanner.nextLine()

            val removalOutcome: Boolean = recipeManager.removeRecipeById(recipeId.toInt())

            if (removalOutcome) {

                println("Recipe with id: $recipeId removed successfully")

            } else {

                println("Recipe with id: $recipeId not found")

            }

        } else if (userChoice.toInt() == 6) {

            isProgramOn = false

        }

    }

    println()
    println("Thank You for Using the Recipe Manager!")

}

fun showOptions() {

    println()
    println("Please Select an option\n")
    println("1. View All Recipes")
    println("2. Search Recipe By Id")
    println("3. Search Recipe By name")
    println("4. Add a New Recipe")
    println("5. Delete a Recipe")
    println("6. Quit")
    println()

    print("Enter your option: ")

}