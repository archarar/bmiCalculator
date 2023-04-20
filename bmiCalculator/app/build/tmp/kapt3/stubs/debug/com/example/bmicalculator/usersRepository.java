package com.example.bmicalculator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/bmicalculator/usersRepository;", "", "usersDao", "Lcom/example/bmicalculator/usersDao;", "(Lcom/example/bmicalculator/usersDao;)V", "getAvgBmi", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/bmicalculator/user;", "getGetAvgBmi", "()Landroidx/lifecycle/LiveData;", "getShortest", "getGetShortest", "getTallest", "getGetTallest", "insertUser", "", "user", "(Lcom/example/bmicalculator/user;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class usersRepository {
    private final com.example.bmicalculator.usersDao usersDao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getTallest = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getShortest = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getAvgBmi = null;
    
    public usersRepository(@org.jetbrains.annotations.NotNull
    com.example.bmicalculator.usersDao usersDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.example.bmicalculator.user user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getGetTallest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getGetShortest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.bmicalculator.user>> getGetAvgBmi() {
        return null;
    }
}