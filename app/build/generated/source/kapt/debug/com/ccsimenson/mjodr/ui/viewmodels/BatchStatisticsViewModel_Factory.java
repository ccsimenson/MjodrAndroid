package com.ccsimenson.mjodr.ui.viewmodels;

import com.ccsimenson.mjodr.data.BatchRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class BatchStatisticsViewModel_Factory implements Factory<BatchStatisticsViewModel> {
  private final Provider<BatchRepository> repositoryProvider;

  public BatchStatisticsViewModel_Factory(Provider<BatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public BatchStatisticsViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static BatchStatisticsViewModel_Factory create(
      Provider<BatchRepository> repositoryProvider) {
    return new BatchStatisticsViewModel_Factory(repositoryProvider);
  }

  public static BatchStatisticsViewModel newInstance(BatchRepository repository) {
    return new BatchStatisticsViewModel(repository);
  }
}
