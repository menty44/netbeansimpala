/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.controller;

/**
 *
 * @author fred
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.fred.dao.SiddhuCrudDao;
import com.fred.model.Rates;

public class SiddhuCRUDController extends HttpServlet {

    private static final long serialVersionUID = 177831973239L;
    //private static final long serialVersionUID = 1L;
    private SiddhuCrudDao dao;

    public SiddhuCRUDController() {
        dao = new SiddhuCrudDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            List<Rates> lstRate = new ArrayList<Rates>();
            String action = (String) request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            if (action.equals("list")) {
                try {
                    lstRate = dao.getAllRates();
                    JsonElement element = gson.toJsonTree(lstRate, new TypeToken<List<Rates>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    String listData = jsonArray.toString();
                    listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                    response.getWriter().print(listData);
                } catch (Exception ex) {                   
                    
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getMessage() + "}";
                    response.getWriter().print(error);
                    ex.printStackTrace();
                }
            } else if (action.equals("create") || action.equals("update")) {
                Rates rate = new Rates();

                if (request.getParameter("id") != null) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    rate.setId(id);
                }

                if (request.getParameter("ratename") != null) {
                    String ratename = (String) request.getParameter("ratename");
                    rate.setRatename(ratename);
                }

                if (request.getParameter("rateValue") != null) {
                    String ratevalue = (String) request.getParameter("ratevalue");
                    rate.setRatevalue(ratevalue);
                }
                //if(request.getParameter(“email”)!=null){
                //String email=(String)request.getParameter(“email”);
                //user.setEmail(email);
                //}

                try {
                    if (action.equals("create")) {
                        dao.addRate(rate);
                        lstRate.add(rate);
                        String json = gson.toJson(rate);
                        String listData =
                        "{\"Result\":\"OK\",\"Record\":"+json + "}";
                        response.getWriter().print(listData);
                    } else if (action.equals("update")){
                        dao.updateRate(rate);
                        //String listData = ”{\”Result\”:\”OK\”}”;
                        String listData = "{\"Result\" : \"OK\"}";
                        response.getWriter().print(listData);
                    }
                } catch (Exception ex) {
                    String error =
                    "{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString() +  "}";
                    response.getWriter().print(error);
                    ex.printStackTrace();
                }
            } else if (action.equals("delete")){//Delete record
                try {
                                    if (request.getParameter("id")!=null){
                String id = (String) request.getParameter("id");
                dao.deleteRate(Integer.parseInt(id));
                        String listData = "{\"Result\" : \"OK\"}";
                        response.getWriter().print(listData);
                    }
                } catch (Exception ex) {
                    String error =
                    "{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString() +
                    "}";
                    response.getWriter().print(error);
                    ex.printStackTrace();
                }
            }
        }
    }
}
