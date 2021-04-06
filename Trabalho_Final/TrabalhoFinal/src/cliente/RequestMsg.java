/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestMsg {
    private int messageType = 0;
    private int requestId;
    private String methodId;
    private String objectReference;
    private String[] arguments;
    
    public RequestMsg(String objectReference, String methodId, String[] arguments, int requestId) {
        this.methodId = methodId;
        this.objectReference = objectReference;
        this.arguments = arguments;
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    
    public String toString() {
        this.requestId++;
        JSONArray array = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("messageType", this.messageType);
        json.put("requestId", this.requestId);
        json.put("methodId", this.methodId);
        json.put("objectReference", this.objectReference);
        for (String args: this.arguments) {
            array.put(args);
        }
        json.put("arguments", array);
        return json.toString();
    }
}
