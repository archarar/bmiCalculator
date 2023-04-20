package com.example.bmicalculator;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J!\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000b\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/bmicalculator/usersDao;", "", "getAvgBmi", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/bmicalculator/user;", "getShortest", "getTallest", "insertUser", "", "user", "", "([Lcom/example/bmicalculator/user;)V", "app_debug"})
public abstract interface usersDao {
    
    @androidx.room.Upsert
    public abstract void insertUser(@org.jetbrains.annotations.NotNull
    com.example.bmicalculator.user... user);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT heightin, heightft, MAX(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getTallest();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT heightin, heightft, MIN(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getShortest();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT heightin, heightft, heightTotal, neck, waist, AVG(bmi) AS bmi, id FROM USERS")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getAvgBmi();
}