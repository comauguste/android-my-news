package com.mynews.ui.articledetail

import android.content.Intent
import javax.inject.Inject

class ArticleDetailRouter @Inject constructor(
    private val fragment: ArticleDetailFragment,
) : ArticleDetailContract.Router {

    override fun shareArticle(url: String) {
        fragment.context?.let { context ->
            val shareBody = "Check out this article in My News App: $url"
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                "Check out this article"
            )
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            context.startActivity(
                Intent.createChooser(
                    sharingIntent,
                    shareBody
                ).also {
                    it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
        }

    }
}