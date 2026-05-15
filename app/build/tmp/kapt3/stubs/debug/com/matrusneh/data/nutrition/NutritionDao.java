package com.matrusneh.data.nutrition;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/matrusneh/data/nutrition/NutritionDao;", "", "getByDate", "Lcom/matrusneh/data/nutrition/NutritionLog;", "dateIso", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "", "log", "(Lcom/matrusneh/data/nutrition/NutritionLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NutritionDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.matrusneh.data.nutrition.NutritionLog log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM nutrition_logs WHERE dateIso = :dateIso LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String dateIso, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.matrusneh.data.nutrition.NutritionLog> $completion);
}