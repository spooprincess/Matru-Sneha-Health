package com.matrusneh.ui.nutrition;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/matrusneh/ui/nutrition/NutritionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/matrusneh/ui/nutrition/NutritionUiState;", "kotlin.jvm.PlatformType", "dao", "Lcom/matrusneh/data/nutrition/NutritionDao;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "loadToday", "", "tips", "", "", "pickWeeklyTip", "saveToday", "app_debug"})
public final class NutritionViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.matrusneh.data.nutrition.NutritionDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.matrusneh.ui.nutrition.NutritionUiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.matrusneh.ui.nutrition.NutritionUiState> state = null;
    
    public NutritionViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.matrusneh.ui.nutrition.NutritionUiState> getState() {
        return null;
    }
    
    public final void loadToday(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tips) {
    }
    
    public final void saveToday(@org.jetbrains.annotations.NotNull()
    com.matrusneh.ui.nutrition.NutritionUiState state) {
    }
    
    private final java.lang.String pickWeeklyTip(java.util.List<java.lang.String> tips) {
        return null;
    }
}