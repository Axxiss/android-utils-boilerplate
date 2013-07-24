package io.github.axxiss.android.aub.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Provides read/write access to {@link SharedPreferences}.
 *
 * @author Axxiss
 */
public class BoilerplateSettings {
    /**
     * App's preferences.
     */
    private SharedPreferences mPreferences;

    /**
     * Default int value to return when no value was found for the given key.
     */
    public final static int DEFAULT_INT = -99;

    /**
     * Default float value to return when no value was found for the given key.
     */
    public final static float DEFAULT_FLOAT = -99;

    /**
     * Current context
     */
    private Context mContext;

    /**
     * Create a new Settings instance getting the default preference. Default preference mode is {@link
     * Context#MODE_PRIVATE}.
     * <p/>
     * To use a custom preference file or different access mode use
     * {@link #BoilerplateSettings(android.content.Context, String, int)} instead
     *
     * @param appContext
     */
    public BoilerplateSettings(Context appContext) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        mContext = appContext;
    }

    /**
     * Crates a new settings instance using a custom preference file and access mode.
     *
     * @param appContext Current context
     * @param name       Preferences name
     * @param mode       Access mode
     */
    public BoilerplateSettings(Context appContext, String name, int mode) {
        mPreferences = mContext.getSharedPreferences(name, mode);
        mContext = appContext;
    }

    /**
     * Update the current context.
     *
     * @param context
     */
    protected void setContext(Context context) {
        mContext = context;
    }

    /**
     * Set a String preference
     *
     * @param key
     * @param value
     */
    protected void setStringPreference(int key, String value) {
        mPreferences.edit().putString(mContext.getString(key), value).apply();
    }

    /**
     * Get a string preference
     *
     * @param key
     * @return
     */
    protected String getStringPreference(int key) {
        return mPreferences.getString(mContext.getString(key), null);
    }

    /**
     * Get a boolean preference, default value is {@code false}
     *
     * @param key
     * @return
     */
    protected boolean getBooleanPreference(int key) {
        return mPreferences.getBoolean(mContext.getString(key), false);
    }

    /**
     * Set a String preference
     *
     * @param key
     * @param value
     */
    protected void setBooleanPreference(int key, boolean value) {
        mPreferences.edit().putBoolean(mContext.getString(key), value).apply();
    }

    protected int getIntPreference(int key) {
        return mPreferences.getInt(mContext.getString(key), DEFAULT_INT);
    }

    protected void setIntPreference(int key, int value) {
        mPreferences.edit().putInt(mContext.getString(key), value).apply();
    }

    protected float getFloatPreference(int key) {
        return mPreferences.getFloat(mContext.getString(key), DEFAULT_FLOAT);
    }

    protected void setFloatPreference(int key, int value) {
        mPreferences.edit().putInt(mContext.getString(key), value).apply();
    }
}
