package com.example.foodforthought;

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
}
