# CoffeeRecipe
The goal of this project is to develop an online recipe management system using Java. The system will be a console-based application that allows users to create, modify, search, and rate recipes. The system will implement at least three different design patterns to achieve a flexible and maintainable architecture. When the program is executed, main menu presents 4 options to the user as: create recipe, search recipes, rate recipe, modify recipe.
  
1. Recipe Creation Module:
• Accept recipe details: ingredients, cooking instructions, and serving size.  
• Provide users with the ability to choose up to three categories that the recipe belongs to (e.g. appetizers, main dishes, desserts).  
• Provide users with the ability to choose up to three tags that describe the recipe (e.g. vegetarian, gluten-free, spicy).  
• Do not keep the owner of the recipe.   
• Once the user has entered all the necessary information, the user can select “Save Recipe” to save the recipe to the system.  
• Additionally, each recipe should have an impact property that is computed by the system 
whenever a user provides a rating for that recipe. This impact property can be computed in 
two ways as average rating or number of total ratings according to the choice of the user who 
wants to display details of the recipe at runtime. As default, average rating computation is 
used.
2. Recipe Modification Module:
• Any user can modify any recipe.
• Allow users to modify existing recipes by changing ingredients or cooking instructions.
• Provide users with the ability to choose up to three categories that the modified recipe 
belongs to.
• Provide users with the ability to choose up to three tags that describe the modified recipe.
• Allow users to undo the made modifications.
3. Recipe Search Module:
• Allow users to search for recipes based on tags, ingredients, or categories.
4. Recipe Rating Module:
• Allow users to rate recipes on a scale of 1-5 stars.
Example usage of the program:
• User selects "Create Recipe" option from the main menu.
• User enters recipe details, chooses up to three categories and up to three tags.
• User selects "Save Recipe" to save the recipe to the system.
• User selects "Search Recipes" option from the main menu.
• User enters a keyword to search.
• User selects a recipe from the search results to view details.
• User displays the impact property of the recipe by average rating.
• User selects "Rate Recipe" to rate the recipe on a scale of 1-5 stars
