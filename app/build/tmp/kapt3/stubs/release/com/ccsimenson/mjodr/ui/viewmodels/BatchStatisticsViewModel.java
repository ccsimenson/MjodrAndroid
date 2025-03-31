package com.ccsimenson.mjodr.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/ccsimenson/mjodr/ui/viewmodels/BatchStatisticsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ccsimenson/mjodr/data/BatchRepository;", "(Lcom/ccsimenson/mjodr/data/BatchRepository;)V", "_statistics", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ccsimenson/mjodr/data/BatchStatistics;", "statistics", "Lkotlinx/coroutines/flow/StateFlow;", "getStatistics", "()Lkotlinx/coroutines/flow/StateFlow;", "loadStatistics", "", "batchId", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class BatchStatisticsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ccsimenson.mjodr.data.BatchRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ccsimenson.mjodr.data.BatchStatistics> _statistics = null;
    
    @javax.inject.Inject
    public BatchStatisticsViewModel(@org.jetbrains.annotations.NotNull
    com.ccsimenson.mjodr.data.BatchRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ccsimenson.mjodr.data.BatchStatistics> getStatistics() {
        return null;
    }
    
    public final void loadStatistics(@org.jetbrains.annotations.NotNull
    java.lang.String batchId) {
    }
}