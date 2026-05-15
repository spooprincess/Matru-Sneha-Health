package com.matrusneh.ui.checkup;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/matrusneh/ui/checkup/CheckupViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/matrusneh/ui/checkup/CheckupUiState;", "kotlin.jvm.PlatformType", "dao", "Lcom/matrusneh/data/checkup/CheckupDao;", "intervalDays", "", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "workManager", "Landroidx/work/WorkManager;", "load", "", "scheduleReminderOneDayBefore", "nextMillis", "", "setLastDate", "lastIso", "", "toState", "nextIso", "Companion", "app_debug"})
public final class CheckupViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.matrusneh.data.checkup.CheckupDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.matrusneh.ui.checkup.CheckupUiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.matrusneh.ui.checkup.CheckupUiState> state = null;
    private final int intervalDays = 28;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIQUE_WORK = "checkup_reminder_one_day_before";
    @org.jetbrains.annotations.NotNull()
    public static final com.matrusneh.ui.checkup.CheckupViewModel.Companion Companion = null;
    
    public CheckupViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.matrusneh.ui.checkup.CheckupUiState> getState() {
        return null;
    }
    
    public final void load() {
    }
    
    public final void setLastDate(@org.jetbrains.annotations.NotNull()
    java.lang.String lastIso) {
    }
    
    private final com.matrusneh.ui.checkup.CheckupUiState toState(java.lang.String lastIso, java.lang.String nextIso) {
        return null;
    }
    
    private final void scheduleReminderOneDayBefore(long nextMillis) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/matrusneh/ui/checkup/CheckupViewModel$Companion;", "", "()V", "UNIQUE_WORK", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}