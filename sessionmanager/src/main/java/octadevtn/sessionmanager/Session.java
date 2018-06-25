package octadevtn.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
/*
created by Mohamed chiheb ben jemaa

 25-06-2018
 */
public class Session<T> {

    public static final String NOT_EXISTS="{}";

    public static final String KEY_JSON="session";


    Context context;

    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Gson gson;

    OnSessionDestroyed onSessionDestroyed;



    public Session(Context context){
        this.context=context;
        pref=context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
        editor=pref.edit();
        gson=new Gson();

    }


    public void save(T t){
        editor.putString(KEY_JSON,gson.toJson(t));
        editor.commit();

    }

    public T get(Class<T> type){

        if(exists()) {
            String json = pref.getString(KEY_JSON, NOT_EXISTS);
            T t = gson.fromJson(json, type);
            return t;

        }else{
            return null;
        }


    }




    public boolean exists(){
        return !pref.getString(KEY_JSON,NOT_EXISTS).equals(NOT_EXISTS);
    }



    public void destroy(){
        editor.remove(KEY_JSON).commit();
        if(onSessionDestroyed!=null) {
            onSessionDestroyed.destroy();
        }
    }


    public void setOnSessionDestroyed(OnSessionDestroyed onSessionDestroyed) {
        this.onSessionDestroyed = onSessionDestroyed;
    }

    public boolean existsInt(String property){
       return    pref.getInt(property,0)!=0;
    }

    public boolean existsString(String property){
        return  !pref.getString(property,"").equals("");
    }

    public boolean existsBoolean(String property){
        return  !pref.getBoolean(property,false);
    }

    public boolean existsLong(String property){
        return  pref.getLong(property,0)!=0;
    }

    public boolean existsFloat(String property){
        return  pref.getFloat(property,0)!=0;
    }









    public void putProperty(String key, int value ){
        editor.putInt(key,value);
        editor.commit();
    }



    public void putProperty(String key, String value ){
        editor.putString(key,value);
        editor.commit();
    }


    public void putProperty(String key, boolean value ){
        editor.putBoolean(key,value);
        editor.commit();
    }


    public void putProperty(String key, long value ){
        editor.putLong(key,value);
        editor.commit();
    }


    public void putProperty(String key, float value ){
        editor.putFloat(key,value);
        editor.commit();
    }



    public int getInt(String key){
        return pref.getInt(key,0);
    }

    public float getFloat(String key){
        return pref.getFloat(key,0);
    }

    public boolean getBoolean(String key){
        return pref.getBoolean(key,false);
    }

    public long getLong(String key){
        return pref.getLong(key,0);
    }


    public String getString(String key){
        return pref.getString(key,"");
    }


    public interface OnSessionDestroyed{

        void destroy();

    }




}
