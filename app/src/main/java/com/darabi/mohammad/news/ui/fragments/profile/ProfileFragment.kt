package com.darabi.mohammad.news.ui.fragments.profile

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.darabi.mohammad.news.BuildConfig
import com.darabi.mohammad.news.R
import com.darabi.mohammad.news.databinding.FragmentProfileBinding
import com.darabi.mohammad.news.ui.base.BaseFragment
import com.darabi.mohammad.news.utils.openBrowser
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment @Inject constructor() : BaseFragment(), View.OnClickListener {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    override fun onClick(view: View?) {
        interactorViewModel.openBottomSheet.value = true
    }

    private fun initViews() {

        val githubRepoText = getString(R.string.github_repo)

        binding.txtGithubLink.apply {

            text = SpannableString(githubRepoText).apply {

                setSpan(object: ClickableSpan() {

                    override fun onClick(widget: View) {
                        openBrowser(BuildConfig.GITHUB_LINK)
                    }

                    override fun updateDrawState(textPaint: TextPaint) {
                        super.updateDrawState(textPaint)
                        textPaint.isUnderlineText = true
                    }
                }, 0, githubRepoText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            }
            movementMethod = LinkMovementMethod.getInstance()
        }

        binding.btnAboutMe.setOnClickListener(this)
    }
}