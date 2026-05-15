package com.matrusneh.data.kick;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ \u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/matrusneh/data/kick/KickDao;", "", "countBetween", "", "start", "", "end", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "log", "Lcom/matrusneh/data/kick/KickLog;", "(Lcom/matrusneh/data/kick/KickLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lastKickBetween", "timestampsSince", "", "since", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface KickDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.matrusneh.data.kick.KickLog log, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM kick_logs WHERE timestamp BETWEEN :start AND :end")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countBetween(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT MAX(timestamp) FROM kick_logs WHERE timestamp BETWEEN :start AND :end")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object lastKickBetween(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT timestamp FROM kick_logs WHERE timestamp >= :since ORDER BY timestamp ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object timestampsSince(long since, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.Long>> $completion);
}