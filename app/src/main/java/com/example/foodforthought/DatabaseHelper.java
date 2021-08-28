package com.example.foodforthought;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "CookBookDB";

    // Table names
    private static final String TABLE_RECIPE = "recipes";
    private static final String TABLE_TAG = "tags";
    private static final String TABLE_INGREDIENT = "ingredients";
    private static final String TABLE_STEP = "steps";
    private static final String TABLE_RECIPE_TAG = "recipeTag";
    private static final String TABLE_RECIPE_INGREDIENT = "recipeIngredient";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_RECIPE_ID = "recipeID";

    // RECIPE Table - column names
    private static final String KEY_RECIPE_DESCRIPTION = "description";
    private static final String KEY_RECIPE_COOK_TIME = "cookTime";

    // INGREDIENT Table - column names
    private static final String KEY_INGREDIENT_UNIT = "unit";

    // STEP Table - column names
    private static final String KEY_STEP_ORDER = "stepOrder";
    private static final String KEY_STEP_DESCRIPTION = "description";

    // RECIPE_TAG Table - column names
    private static final String KEY_TAG_ID = "tagID";

    // RECIPE_INGREDIENTS Table - column names
    private static final String KEY_INGREDIENT_ID = "ingredientID";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_PREPARATION = "preparation";


    // Table Create Statements
    // RECIPE Table - create statement
    private static final String CREATE_TABLE_RECIPE = "CREATE TABLE " + TABLE_RECIPE + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " VARCHAR,"
            + KEY_RECIPE_DESCRIPTION + " VARCHAR,"
            + KEY_RECIPE_COOK_TIME + " VARCHAR" + ")";

    // TAG Table - create statement
    private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_TAG + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " VARCHAR" + ")";

    // INGREDIENT Table - create statement
    private static final String CREATE_TABLE_INGREDIENT = "CREATE TABLE " + TABLE_INGREDIENT + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " VARCHAR,"
            + KEY_INGREDIENT_UNIT + " VARCHAR" + ")";

    // STEP Table - create statement
    private static final String CREATE_TABLE_STEP = "CREATE TABLE " + TABLE_STEP + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_STEP_ORDER + " INTEGER,"
            + KEY_STEP_DESCRIPTION + " VARCHAR,"
            + KEY_RECIPE_ID + " INTEGER,"
            + " FOREIGN KEY (" + KEY_RECIPE_ID + ") REFERENCES " + TABLE_RECIPE + "(" + KEY_RECIPE_ID + ") ON DELETE CASCADE" + ")";

    // RECIPE_TAG Table - create statement
    private static final String CREATE_TABLE_RECIPE_TAG = "CREATE TABLE " + TABLE_RECIPE_TAG + "("
            + KEY_RECIPE_ID + " INTEGER,"
            + KEY_TAG_ID + " INTEGER,"
            + " FOREIGN KEY (" + KEY_RECIPE_ID + ") REFERENCES " + TABLE_RECIPE + "(" + KEY_RECIPE_ID + ") ON DELETE CASCADE,"
            + " FOREIGN KEY (" + KEY_TAG_ID + ") REFERENCES " + TABLE_TAG + "(" + KEY_TAG_ID + ") ON DELETE CASCADE" + ")";

    // RECIPE_INGREDIENT Table - create statement
    private static final String CREATE_TABLE_RECIPE_INGREDIENT = "CREATE TABLE " + TABLE_RECIPE_INGREDIENT +  "("
            + KEY_RECIPE_ID + " INTEGER,"
            + KEY_INGREDIENT_ID + " INTEGER,"
            + KEY_AMOUNT + " INTEGER,"
            + KEY_PREPARATION + " VARCHAR,"
            + " FOREIGN KEY (" + KEY_RECIPE_ID + ") REFERENCES " + TABLE_RECIPE + "(" + KEY_RECIPE_ID + ") ON DELETE CASCADE,"
            + " FOREIGN KEY (" + KEY_INGREDIENT_ID + ") REFERENCES " + TABLE_INGREDIENT + "(" + KEY_INGREDIENT_ID + ") ON DELETE CASCADE" + ")";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create all the tables
        db.execSQL(CREATE_TABLE_RECIPE);
        db.execSQL(CREATE_TABLE_TAG);
        db.execSQL(CREATE_TABLE_INGREDIENT);
        db.execSQL(CREATE_TABLE_STEP);
        db.execSQL(CREATE_TABLE_RECIPE_TAG);
        db.execSQL(CREATE_TABLE_RECIPE_INGREDIENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STEP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_TAG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_INGREDIENT);

        // create new tables
        onCreate(db);
    }



    // ------------------ RECIPE methods ------------------ //

    // Add a new recipe
    public long addRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        // insert Name, Description, CookTime into RECIPE table
        ContentValues row = new ContentValues();
        row.put(KEY_NAME, recipe.getName());
        row.put(KEY_RECIPE_DESCRIPTION, recipe.getDescription());
        row.put(KEY_RECIPE_COOK_TIME, recipe.getCookTime());
        long recipeID = db.insert(TABLE_RECIPE, null, row);
        row.clear();

//        // insert recipe-tag pairs
//        Tag[] recipeTags = recipe.getTags();
//        for (int i = 0; i < recipeTags.length; i++) {
//            addRecipeTagPair(recipeID, recipeTags[i].getID());
//        }
//
//        // insert recipe-ingredient pairs
//        RecipeIngredient[] recipeIngredients = recipe.getRecipeIngredients();
//        for (int i = 0; i < recipeIngredients.length; i++) {
//            addRecipeIngredientPair(recipeID, recipeIngredients[i].getIngredientID(), recipeIngredients[i].getAmount(), recipeIngredients[i].getPreparation());
//        }
//
//        // insert steps
//        Step[] steps = recipe.getSteps();
//        for (int i = 0; i < steps.length; i++) {
//            addStep(steps[i].getID(), steps[i].getOrder(), steps[i].getDescription(), recipeID);
//        }

        return recipeID;
    }


    // ------------------ TAG methods ------------------------ //


    
    // ------------------ STEP methods ----------------------- //
    // Add a step
    public void addStep(int stepID, int order, String description, long recipeID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(KEY_ID, stepID);
        row.put(KEY_STEP_ORDER, order);
        row.put(KEY_STEP_DESCRIPTION, description);
        row.put(KEY_RECIPE_ID, recipeID);
        db.insert(TABLE_STEP, null, row);
    }


    // ------------------ RECIPE-TAG methods ----------------- //
    // Add a RECIPE-TAG pair
    public void addRecipeTagPair(long recipeID, int tagID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(KEY_RECIPE_ID, recipeID);
        row.put(KEY_TAG_ID, tagID);
        db.insert(TABLE_RECIPE_TAG, null, row);
    }


    // ------------------- RECIPE-INGREDIENT methods ------------- //
    // Add a RECIPE-INGREDIENT pair
    public void addRecipeIngredientPair(long recipeID, int ingredientID, int amount, String preparation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(KEY_RECIPE_ID, recipeID);
        row.put(KEY_INGREDIENT_ID, ingredientID);
        row.put(KEY_AMOUNT, amount);
        row.put(KEY_PREPARATION, preparation);
        db.insert(TABLE_RECIPE_INGREDIENT, null, row);
    }
}
