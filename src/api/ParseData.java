package api;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Variables;
import service.GetTime;

public class ParseData{
    private GetTime time;

    public void program(String responseBody, Variables variable){
        time = new GetTime();

        JSONObject json = new JSONObject(responseBody);
        JSONObject main = json.getJSONObject("main");
        
        variable.setTemperature(main.getDouble("temp"));

        JSONArray jsonArray = json.getJSONArray("weather");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            variable.setConditions(jsonobject.getString("main"));
        }
        time.program(variable);
    }
}