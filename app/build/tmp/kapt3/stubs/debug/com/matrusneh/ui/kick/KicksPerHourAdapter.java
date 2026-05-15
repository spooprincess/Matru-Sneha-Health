package com.matrusneh.ui.kick;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/matrusneh/ui/kick/KicksPerHourAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/matrusneh/ui/kick/KicksPerHourRow;", "Lcom/matrusneh/ui/kick/KicksPerHourAdapter$VH;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Diff", "VH", "app_debug"})
public final class KicksPerHourAdapter extends androidx.recyclerview.widget.ListAdapter<com.matrusneh.ui.kick.KicksPerHourRow, com.matrusneh.ui.kick.KicksPerHourAdapter.VH> {
    
    public KicksPerHourAdapter() {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.matrusneh.ui.kick.KicksPerHourAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.matrusneh.ui.kick.KicksPerHourAdapter.VH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/matrusneh/ui/kick/KicksPerHourAdapter$Diff;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/matrusneh/ui/kick/KicksPerHourRow;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class Diff extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.matrusneh.ui.kick.KicksPerHourRow> {
        @org.jetbrains.annotations.NotNull()
        public static final com.matrusneh.ui.kick.KicksPerHourAdapter.Diff INSTANCE = null;
        
        private Diff() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.matrusneh.ui.kick.KicksPerHourRow oldItem, @org.jetbrains.annotations.NotNull()
        com.matrusneh.ui.kick.KicksPerHourRow newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.matrusneh.ui.kick.KicksPerHourRow oldItem, @org.jetbrains.annotations.NotNull()
        com.matrusneh.ui.kick.KicksPerHourRow newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/matrusneh/ui/kick/KicksPerHourAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/matrusneh/databinding/ItemKicksPerHourBinding;", "(Lcom/matrusneh/databinding/ItemKicksPerHourBinding;)V", "getBinding", "()Lcom/matrusneh/databinding/ItemKicksPerHourBinding;", "app_debug"})
    public static final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.matrusneh.databinding.ItemKicksPerHourBinding binding = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        com.matrusneh.databinding.ItemKicksPerHourBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.matrusneh.databinding.ItemKicksPerHourBinding getBinding() {
            return null;
        }
    }
}