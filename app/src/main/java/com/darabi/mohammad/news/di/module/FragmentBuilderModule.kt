package com.darabi.mohammad.news.di.module

import androidx.fragment.app.Fragment
import com.darabi.mohammad.news.di.annotation.FragmentKey
import com.darabi.mohammad.news.ui.fragments.BottomSheetFragment
import com.darabi.mohammad.news.ui.fragments.MainFragment
import com.darabi.mohammad.news.ui.fragments.SplashFragment
import com.darabi.mohammad.news.ui.fragments.article.ArticlesFragment
import com.darabi.mohammad.news.ui.fragments.detail.ArticleDetailFragment
import com.darabi.mohammad.news.ui.fragments.profile.ProfileFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap


@Module
@InstallIn(ActivityComponent::class)
abstract class FragmentBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun bindMainFragment(fragment: MainFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ArticleDetailFragment::class)
    abstract fun bindArticleDetailFragment(fragment: ArticleDetailFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ArticlesFragment::class)
    abstract fun bindArticlesFragment(fragment: ArticlesFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ProfileFragment::class)
    abstract fun bindProfileFragment(fragment: ProfileFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(BottomSheetFragment::class)
    abstract fun bindBottomSheetFragment(fragment: BottomSheetFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SplashFragment::class)
    abstract fun bindSplashFragment(fragment: SplashFragment): Fragment

}